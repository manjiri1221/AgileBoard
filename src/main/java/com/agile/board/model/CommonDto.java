package com.agile.board.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;

import lombok.Data;
/**
 * Common Model
 * @author manjirilakhote
 *
 */
@Data
public class CommonDto {

	private ObjectId id;
	private Date createdOn;
	private Date lastModifiedOn;
	private boolean isActive = true;
	private String name;
	private List<UserDto> createdBy=new ArrayList<>();

}
