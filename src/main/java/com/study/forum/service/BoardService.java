package com.study.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.forum.entity.Board;
import com.study.forum.repository.BoardRepository;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;

	public void write(Board board) {
		boardRepository.save(board);
	}
}
