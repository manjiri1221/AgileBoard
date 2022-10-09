package com.agile.board.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * Entity for User
 * @author manjirilakhote
 *
 */

@Document("user")
@Data
public class User extends CommonEntity{
	public User(String name) {
		super();
		this.setName(name);
	}
	List<BoardVisit> boards = new ArrayList();
	
	public User() {}
	
}
