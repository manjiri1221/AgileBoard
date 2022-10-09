package com.agile.board.model;

import java.util.Date;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
/**
 * Model for details of user's visit on board
 * @author manjirilakhote
 *
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BoardVisit {

	private ObjectId boardId;
	private Date lastVisitedOn;
	
	public BoardVisit(ObjectId boardId,Date lastVisitedOn){
		this.boardId = boardId;
		this.lastVisitedOn = lastVisitedOn;
	}
}
