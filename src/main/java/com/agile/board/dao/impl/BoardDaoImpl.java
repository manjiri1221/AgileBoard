package com.agile.board.dao.impl;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;

import com.agile.board.entity.Board;
import com.agile.board.model.BoardDto;

import reactor.core.publisher.Flux;

/**
 * Separate Dao for Board which can be used to implement mongo functionalities using mongo template
 * @author manjirilakhote
 *
 */
@Configuration
public class BoardDaoImpl {
	@Autowired
    ReactiveMongoTemplate template;
	
	// Aggregation query to board details along with user details
	public Flux<BoardDto> getBoardDetails(ObjectId boardId) {
		
		MatchOperation matchBoardId = Aggregation.match(Criteria.where("_id").is(boardId));
		LookupOperation lookupCreatedBy = Aggregation.lookup("user", "createdBy", "_id", "createdBy");
		
		Aggregation agg = Aggregation.newAggregation(matchBoardId, lookupCreatedBy)
				.withOptions(Aggregation.newAggregationOptions().allowDiskUse(true).build());
		return template.aggregate(agg, Board.class, BoardDto.class);
			
	}

}
