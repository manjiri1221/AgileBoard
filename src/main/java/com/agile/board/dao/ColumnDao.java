package com.agile.board.dao;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.agile.board.entity.Column;
/**
 * Dao for column
 * @author manjirilakhote
 *
 */
public interface ColumnDao extends ReactiveMongoRepository<Column, ObjectId>{}
