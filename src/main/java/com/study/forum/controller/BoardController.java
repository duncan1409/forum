package com.study.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.study.forum.entity.Board;
import com.study.forum.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	// 글 작성 페이지
	@GetMapping("/board/write") // localhost:8090/board/write
	public String boardWriteForm() {
		return "boardwrite";
	}

	@PostMapping("/board/writepro")
	public String boardWritePro(Board board) {

		boardService.write(board);
		return "";
	}

	@GetMapping("/board/list")
	public String boardList(Model model) {
		model.addAttribute("list", boardService.boardList());
		return "boardlist";
	}

	// 특정 게시글 페이지 (GET 방식 처리): localhost:8090/board/view?id=1
	@GetMapping("/board/view")
	public String boardView(Model model, Integer id) {
		model.addAttribute("board", boardService.boardView(id));
		return "boardview";
	}

	// 글 삭제 페이지: 바로 redirect->list
	@GetMapping("/board/delete")
	public String boardDelete(Integer id) {
		boardService.boardDelete(id);

		return "redirect:/board/list";
	}

	// 글 수정 페이지 라우터 id
	@GetMapping("/board/modify/{id}")
	public String boardModify(@PathVariable("id") Integer id, Model model) {

		model.addAttribute("board", boardService.boardView(id));
		return "boardmodify";
	}

	@PostMapping("board/update/{id}")
	public String boardUpdate(@PathVariable("id") Integer id, Board board) {
		Board boardTemp = boardService.boardView(id);
		boardTemp.setTitle(board.getTitle());
		boardTemp.setContent(board.getContent());

		boardService.write(boardTemp);

		return "redirect:/board/list";
	}

}
