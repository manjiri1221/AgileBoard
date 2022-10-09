package com.agile.board.dao.impl;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;

import com.agile.board.entity.Card;
import com.agile.board.model.CardDto;

import reactor.core.publisher.Flux;

/**
 * Separate Dao for Card which can be used to implement mongo functionalities using mongo template
 * @author manjirilakhote
 *
 */
@Configuration
public class CardDaoImpl {
	
	@Autowired
    ReactiveMongoTemplate template;
	
	// Aggregation query to card details along with user details
	public Flux<CardDto> getCardDetailsForAColumn(ObjectId columnId) {
		
		MatchOperation matchBoardId = Aggregation.match(Criteria.where("columnId").is(columnId));
		LookupOperation lookupCreatedBy = Aggregation.lookup("user", "createdBy", "_id", "createdBy");
		LookupOperation lookupUsers = Aggregation.lookup("user", "users", "_id", "users");
		
		Aggregation agg = Aggregation.newAggregation(matchBoardId, lookupCreatedBy,lookupUsers)
				.withOptions(Aggregation.newAggregationOptions().allowDiskUse(true).build());
		return template.aggregate(agg, Card.class, CardDto.class);
			
	}

}
