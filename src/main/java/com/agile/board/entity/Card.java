package com.agile.board.entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * Card model/entity
 * @author manjirilakhote
 *
 */

@Document("card")
@Data
public class Card extends CommonEntity{

	public Card(String name, ObjectId columnId, int sequence, ObjectId createdBy) {
		super(name, createdBy);
		this.setName(name);
		this.setColumnId(columnId);
		this.setSequence(sequence);
		this.setCreatedBy(createdBy);
	}
	private ObjectId columnId;
	private String[] tags;
	private int sequence;
	private ObjectId[] users;
}
