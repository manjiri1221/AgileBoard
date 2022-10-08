package com.agile.board.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * Entity/Model for User
 * @author manjirilakhote
 *
 */
@Data
@Document("user")
public class User {
	public User(String name) {
		this.name = name;
	}
	
	@Id
	private ObjectId id;
	private String name;
	private boolean isActive=true;
}
