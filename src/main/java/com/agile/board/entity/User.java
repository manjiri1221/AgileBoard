package com.agile.board.entity;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Entity/Model for User
 * @author manjirilakhote
 *
 */

@Document("user")
public class User extends CommonEntity{
	public User(String name) {
		super();
		this.setName(name);
	}
	public User() {}
	
}
