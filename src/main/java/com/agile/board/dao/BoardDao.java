package com.agile.board.dao;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.agile.board.entity.Board;
/**
 * Dao for Board operations
 * @author manjirilakhote
 *
 */
public interface BoardDao extends ReactiveMongoRepository<Board, ObjectId>{

}
