package com.agile.board.entity;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * Card entity
 * @author manjirilakhote
 *
 */

@Document("card")
@Data
public class Card extends CommonEntity{

	public Card(String name, ObjectId columnId, int sequence, ObjectId createdBy) {
		super();
		this.setName(name);
		this.setColumnId(columnId);
		this.setSequence(sequence);
		this.setCreatedBy(createdBy);
	}
	public Card(String name, ObjectId columnId, int sequence, ObjectId createdBy, List<String> tags) {
		super();
		this.setName(name);
		this.setColumnId(columnId);
		this.setSequence(sequence);
		this.setCreatedBy(createdBy);
		this.tags.addAll(tags);
	}
	public Card() {}
	
	private ObjectId columnId;
	@Indexed
	private List<String> tags = new ArrayList<>();
	private int sequence;
	//All the users working on the card
	private ObjectId[] users;
}
