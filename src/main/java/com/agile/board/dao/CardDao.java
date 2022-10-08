package com.agile.board.dao;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.agile.board.entity.Card;

/**
 * Dao for card
 * @author manjirilakhote
 *
 */
public interface CardDao extends ReactiveMongoRepository<Card, ObjectId>{

}
