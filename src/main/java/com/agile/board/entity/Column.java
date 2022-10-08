package com.agile.board.entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;

/**
 * Entity/Model for Column
 * @author manjirilakhote
 *
 */
@Data
@Document("column")
public class Column extends CommonEntity{
	
	public Column(String name, ObjectId boardId, int sequence, ObjectId createdBy) {
		super(name,createdBy);
		this.setName(name);
		this.setBoardId(boardId);
		this.setSequence(sequence);
		this.setCreatedBy(createdBy);
	}
	@NonNull
	private ObjectId boardId;
	// Determines the position of column on the board, can be autoIncremented or taken as input from frontend.
	private int sequence;
}
