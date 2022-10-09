package com.agile.board.dao;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.agile.board.entity.User;

/**
 * Dao for managing user operations
 * @author manjirilakhote
 *
 */
public interface UserDao extends ReactiveMongoRepository<User, ObjectId>{}
