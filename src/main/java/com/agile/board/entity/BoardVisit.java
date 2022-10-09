package com.agile.board.entity;

import java.util.Date;

import org.bson.types.ObjectId;

import lombok.Data;

@Data
public class BoardVisit {

	private ObjectId boardId;
	private Date lastVisitedOn;
	
	public BoardVisit(ObjectId boardId,Date lastVisitedOn){
		this.boardId = boardId;
		this.lastVisitedOn = lastVisitedOn;
	}
}
