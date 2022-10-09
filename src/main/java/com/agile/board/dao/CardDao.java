package com.agile.board.dao;

import java.util.Date;

import org.bson.types.ObjectId;
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

	//Find all cards whose createdOn is greated than given timestamp
	Flux<Card> findAllByCreatedOnGreaterThan(Date timestamp);

}
