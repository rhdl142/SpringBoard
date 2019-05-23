package com.test.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.test.board.BoardDTO;

@Repository
public class BoardDao {

	private JdbcTemplate template;
	
	@Autowired
	public BoardDao(ComboPooledDataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	public int boardInsert(final BoardDTO bDTO) {
		
		int result = 0;
		
		final String sql = "INSERT INTO tblBoard (seq, name, title, content, regdate, passwd) values (boardSeq.nextval,?,?,?,sysdate,?)";

		result = template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, bDTO.getName());
				pstmt.setString(2, bDTO.getTitle());
				pstmt.setString(3, bDTO.getContent());
				pstmt.setString(4, bDTO.getRegdate());
				pstmt.setString(4, bDTO.getPasswd());
			}
		});
		
		return result;
		
	}

	public List<BoardDTO> boardSelect() {
		
		List<BoardDTO> list = null;
		
		final String sql = "SELECT * FROM tblBoard";

		list = template.query(sql, new RowMapper<BoardDTO>() {

			@Override
			public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				BoardDTO bDTO = new BoardDTO();
				bDTO.setSeq(rs.getString("seq"));
				bDTO.setName(rs.getString("name"));
				bDTO.setTitle(rs.getString("title"));
				bDTO.setContent(rs.getString("content"));
				bDTO.setRegdate(rs.getString("regdate"));
				bDTO.setPasswd(rs.getString("passwd"));
				
				return bDTO;
			}
			
		});
		
		if(list.isEmpty()) {
			return null;
		}
		
		return list;
	}

	public int boardUpdate(final BoardDTO bDTO) {
		
		int result = 0;
		
		final String sql = "UPDATE tblBoard SET title = ?, content = ? WHERE seq = ?";

		result = template.update(sql, new PreparedStatementSetter() {
					
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, bDTO.getTitle());
				pstmt.setString(2, bDTO.getContent());
				pstmt.setString(3, bDTO.getSeq());
			}
		});
		return result;
	}

	public int boardDelete(final BoardDTO bDTO) {
		
		int result = 0;
		
		final String sql = "DELETE tblBoard WHERE seq = ?";

		result = template.update(sql, new PreparedStatementSetter() {
					
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, bDTO.getSeq());
			}
		});
		
		return result;
	}
}