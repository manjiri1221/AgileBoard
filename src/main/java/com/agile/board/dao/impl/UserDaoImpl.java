package com.agile.board.dao.impl;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.UnwindOperation;
import org.springframework.data.mongodb.core.query.Criteria;

import com.agile.board.entity.User;
import com.agile.board.model.BoardVisit;

import reactor.core.publisher.Flux;

/**
 * Separate Dao for User which can be used to implement mongo functionalities using mongo template
 * @author manjirilakhote
 *
 */
@Configuration
public class UserDaoImpl{
	
	@Autowired
    ReactiveMongoTemplate template;
	
	// Method to get the details when the user last visited a board by using aggregation.
	public Flux<BoardVisit> getLastVisitedTimeForBoard(ObjectId userId, ObjectId boardId) {
		{
			
			MatchOperation matchUserId = Aggregation.match(Criteria.where("_id").is(userId));
			UnwindOperation unwindBoards = Aggregation.unwind("$boards");
			MatchOperation matchBoardId = Aggregation.match(Criteria.where("boards.boardId").is(boardId));
			
			Aggregation agg = Aggregation.newAggregation(matchUserId, unwindBoards, matchBoardId)
					.withOptions(Aggregation.newAggregationOptions().allowDiskUse(true).build());
			return template.aggregate(agg, User.class, BoardVisit.class);
			
		}
	}

}
