package com.agile.board.dao;

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

}
