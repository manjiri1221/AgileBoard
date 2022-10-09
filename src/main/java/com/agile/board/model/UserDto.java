package com.agile.board.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
/**
 * Model for User.
 * @author manjirilakhote
 *
 */
@Data
public class UserDto extends CommonDto{
	List<BoardVisitDto> boards = new ArrayList<BoardVisitDto>();
}
