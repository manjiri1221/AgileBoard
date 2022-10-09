package com.agile.board.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.agile.board.model.BoardDto;
import com.agile.board.service.BoardService;

import reactor.core.publisher.Flux;

/**
 * Rest Controller for Board related operation
 * @author manjirilakhote
 *
 */
@RestController
@RequestMapping("/api/agile-board/boards")
public class BoardController {
	
	
	@Autowired
	private BoardService boardService;
	
	//output the board as a JSON message
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public Flux<BoardDto> listABoardWithColumnsAndCards(@RequestParam String boardId) {
		return boardService.listABoardWithColumnsAndCards(new ObjectId(boardId));
	}
		

}
