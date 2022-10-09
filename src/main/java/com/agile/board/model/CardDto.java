package com.agile.board.model;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import lombok.Data;
/**
 * Model for Card
 * @author manjirilakhote
 *
 */
@Data
public class CardDto extends CommonDto{
	
	private String columnId;
	private List<String> tags = new ArrayList<>();
	private int sequence;
	private List<UserDto> users;

}
