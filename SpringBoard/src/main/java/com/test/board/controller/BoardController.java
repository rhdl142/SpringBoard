package com.test.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.board.BoardDTO;
import com.test.board.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService service;

	// MAIN
	@RequestMapping(value = "/main")
	public String boardMain() {
		return "/main";
	}
	
	// SELECT
	@RequestMapping(value = "/select")
	public ModelAndView boardSelect(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		mav.addObject("list", service.boardSelect());

		mav.setViewName("/list");

		return mav;
	}

	// INSERTFORM
	@RequestMapping(value = "/insertForm", method = RequestMethod.GET)
	public String boardInsertForm() {
		return "/insertForm";
	}

	// INSERT
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String boardInsert(BoardDTO bDTO) {
		service.boardInsert(bDTO);

		return "/main";
	}
	
	// UPDATEFORM
	@RequestMapping(value = "/updateForm", method = RequestMethod.GET)
	public ModelAndView boardUpdate(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("seq", request.getParameter("seq"));

		mav.setViewName("/updateForm");

		return mav;
	}

	// UPDATE
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String boardUpdateForm(BoardDTO bDTO) {
		service.boardUpdate(bDTO);

		return "/main";
	}
	
	// DELETE
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String boardDeleteForm(BoardDTO bDTO) {
		service.boardDelete(bDTO);

		return "/main";
	}
}
