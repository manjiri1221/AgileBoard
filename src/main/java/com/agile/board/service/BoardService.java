package com.agile.board.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.agile.board.dao.BoardDao;
import com.agile.board.dao.impl.BoardDaoImpl;
import com.agile.board.entity.Board;
import com.agile.board.model.BoardDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service class for board operations
 * @author manjirilakhote
 *
 */
@Service
public class BoardService {

	@Autowired
	BoardDao boardDao;
	
	@Autowired
	BoardDaoImpl boardDaoImpl;
	
	@Autowired
	ColumnService columnService;
	
	// Create an empty board
	public Mono<Board> createBoard( String name, ObjectId createdBy) throws Exception {
		if(StringUtils.hasLength(name) && createdBy!=null) {
			Board board = new Board(name,createdBy);
			return boardDao.save(board);
		}
		throw new Exception("Name or createdBy is null or empty");
	}

	//List the board with columns and cards and users
	public Flux<BoardDto> listABoardWithColumnsAndCards(ObjectId boardId) {
		return boardDaoImpl.getBoardDetails(boardId).flatMap(boardDto->{
			return columnService.getColumnsForABoard(boardDto.getId()).collectList().map(list->{
				boardDto.setColumns(list);
				return boardDto;
			});
		});
		
	}

}
