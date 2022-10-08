package com.agile.board.entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * Entity/Model for Board
 * @author manjirilakhote
 *
 */
@Document("board")
public class Board extends CommonEntity{

	public Board(String name, ObjectId userId) {
		super(name);
		this.setName(name);
		this.setCreatedBy(userId);
	}

}
