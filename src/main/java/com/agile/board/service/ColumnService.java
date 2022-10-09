package com.agile.board.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.agile.board.dao.ColumnDao;
import com.agile.board.dao.impl.ColumnDaoImpl;
import com.agile.board.entity.Column;
import com.agile.board.model.ColumnDto;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service class for column related operations
 * @author manjirilakhote
 *
 */
@Service
@Slf4j
public class ColumnService {

	@Autowired
	ColumnDao columnDao;
	
	@Autowired
	ColumnDaoImpl columnDaoImpl;
	
	@Autowired
	CardService cardService;

	// Create Column in a board
	public Mono<Column> createColumn(String name, ObjectId boardId, int sequence, ObjectId createdBy) throws Exception {
		if(StringUtils.hasLength(name) & boardId!=null & createdBy!=null) {
			Column column = new Column(name,boardId, sequence,createdBy);
			return columnDao.save(column);
		}
		throw new Exception("Name or boardId or createdBy is null or empty");
	}

	//Get all the columns of the given board
	public Flux<ColumnDto> getColumnsForABoard(ObjectId boardId) {
		return columnDaoImpl.getColumnsForABoard(boardId).flatMap(columnDto->{
			try {
				return cardService.listCardsInAColumn(columnDto.getId()).collectList().map(list->{
					columnDto.setCards(list);
					return columnDto;
				});
			} catch (Exception e) {
				log.error("Error encountered while getting card details for column - {}",e);
			}
			return null;
			
		});
	}
	
}
