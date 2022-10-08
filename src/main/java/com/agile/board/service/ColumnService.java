package com.agile.board.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agile.board.dao.ColumnDao;
import com.agile.board.entity.Column;

import reactor.core.publisher.Mono;

/**
 * Service class for column related operations
 * @author manjirilakhote
 *
 */
@Service
public class ColumnService {

	@Autowired
	ColumnDao columnDao;

	public Mono<Column> createColumn(String name, ObjectId boardId, int sequence, ObjectId createdBy) {
		Column column = new Column(name,boardId, sequence,createdBy);
		return columnDao.save(column);
	}
	
}
