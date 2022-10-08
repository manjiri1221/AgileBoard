package com.agile.board.entity;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import com.mongodb.lang.NonNull;

import lombok.Data;

/**
 * Class containing common fields & audit fields
 * @author manjirilakhote
 *
 */
@Data
public class CommonEntity {
	
	@Id
	private ObjectId id;
	@CreatedDate
	private Date createdOn;
	@LastModifiedDate
	private Date lastModifiedOn;
	private boolean isActive = true;
	@NonNull
	private String name;
	private ObjectId createdBy;

}
