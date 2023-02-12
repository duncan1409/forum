package com.study.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.study.forum.entity.Board;
import com.study.forum.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;

	@GetMapping("/board/write") // localhost:8090/board/write
	public String boardWriteForm() {
		return "boardwrite";
	}

	@PostMapping("/board/writepro")
	public String boardWritePro(Board board) {

		boardService.write(board);
		return "";
	}
}
