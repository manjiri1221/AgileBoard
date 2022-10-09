package agile.board;



import static org.assertj.core.api.Assertions.catchException;
import static org.junit.Assert.assertTrue;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.agile.board.Application;
import com.agile.board.entity.Board;
import com.agile.board.service.BoardService;
/**
 * Test class for board
 * @author manjirilakhote
 *
 */
@DataMongoTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes=Application.class)
public class BoardTest {

	@Autowired
	BoardService boardService;
	
	// Test to create a board with given params
	@Test
	public void createEmptyBoardTest() throws Exception {
		
		String name = "board1";
		ObjectId createdBy = new ObjectId("6341420bc0920229d1ba2bab");
		Board board = boardService.createBoard(name,createdBy).block();
		assertTrue(name.equals(board.getName()));
		
	}
	// Test with null name, it should throw an exception
	
	@Test(expected = Exception.class)
	public void createBoardWithNullNameTest() throws Exception {
		
		String name = null;
		ObjectId userId = new ObjectId("6341420bc0920229d1ba2bab");
		boardService.createBoard(name,userId).block();
		
	}
	
	// Test with empty name, it should throw an exception
	
	@Test(expected = Exception.class)
	public void createBoardWithEmptyNameTest() throws Exception {
		
		String name = "";
		ObjectId userId = new ObjectId("6341420bc0920229d1ba2bab");
		boardService.createBoard(name,userId).block();
		
	}

}
