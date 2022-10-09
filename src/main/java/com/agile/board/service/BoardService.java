package com.agile.board.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.agile.board.dao.BoardDao;
import com.agile.board.entity.Board;

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
	
	public Mono<Board> createBoard( String name, ObjectId createdBy) throws Exception {
		if(StringUtils.hasLength(name) && createdBy!=null) {
			Board board = new Board(name,createdBy);
			return boardDao.save(board);
		}
		throw new Exception("Name or createdBy is null or empty");
	}

}
