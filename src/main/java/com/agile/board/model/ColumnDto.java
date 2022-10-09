package com.agile.board.model;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import lombok.Data;
/**
 * Model for Column
 * @author manjirilakhote
 *
 */
@Data
public class ColumnDto extends CommonDto {
	private ObjectId boardId;
	private int sequence;
	private List<CardDto> cards = new ArrayList<>();
}
