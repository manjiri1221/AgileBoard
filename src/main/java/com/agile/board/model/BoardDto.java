package com.agile.board.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
/**
 * Model for Board
 * @author manjirilakhote
 *
 */
@Data
public class BoardDto extends CommonDto{
	List<ColumnDto> columns = new ArrayList<>();
}
