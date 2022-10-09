package com.agile.board.dao;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.agile.board.entity.Card;

import reactor.core.publisher.Flux;

/**
 * Dao for card
 * @author manjirilakhote
 *
 */
public interface CardDao extends ReactiveMongoRepository<Card, ObjectId>{

	// Find all cards containing the given tag
	Flux<Card> findAllByTagsAndIsActive(String tags,boolean isActive);

	// Find all cards for the given columnId
	Flux<Card> findAllByColumnIdAndIsActive(ObjectId columnId, boolean isActive);

	//Find all cards whose createdOn is greater than given timestamp
	Flux<Card> findAllByCreatedOnGreaterThan(Date timestamp);
	
	//Find all cards whose createdOn is greater than or modifiedOn is greated than given timestamp
	@Query(value = "{'$or' :[{createdOn:{'$gt' : ?0}},{lastModifiedOn:{'$gt': ?0}}]}")
	Flux<Card> findAllByCreatedOnGreaterThanOrLastModifiedOnGreaterThan(Date timestamp);

}
