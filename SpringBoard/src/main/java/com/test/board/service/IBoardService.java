package com.test.board.service;

import java.util.List;

import com.test.board.BoardDTO;

public interface IBoardService {
	int boardInsert(BoardDTO bDTO);
	List<BoardDTO> boardSelect();
	int boardUpdate(BoardDTO bDTO);
	int boardDelete(BoardDTO bDTO);
}