package com.test.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.board.BoardDTO;
import com.test.board.dao.BoardDao;

@Service
public class BoardService implements IBoardService {
	
	@Autowired
	BoardDao dao;
	
	@Override
	public int boardInsert(BoardDTO bDTO) {
		int result = dao.boardInsert(bDTO);
		
		return result;
	}

	@Override
	public List<BoardDTO> boardSelect() {
		
		List<BoardDTO> list = dao.boardSelect();
		
		return list;
	}

	@Override
	public int boardUpdate(BoardDTO bDTO) {
		
		int result = dao.boardUpdate(bDTO);
		
		if(result == 0 ) {
			System.out.println("Modify Fail!!");
			return 0;
		} else {
			System.out.println("Modify Success!!");
		}
		
		return result;
	}
	
	@Override
	public int boardDelete(BoardDTO bDTO) {
		
		int result = dao.boardDelete(bDTO);
		
		if(result == 0 ) {
			System.out.println("Remove Fail!!");
		} else {
			System.out.println("Remove Success!!");
		}
		
		return result;
	}
}