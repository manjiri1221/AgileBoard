package agile.board;



import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;

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
	
	@Test
	public void createEmptyBoardTest() {
		
		String name = "board1";
		ObjectId userId = new ObjectId("6341420bc0920229d1ba2bab");
		Board board = boardService.createBoard(name,userId).block();
		assertTrue(name.equals(board.getName()));
		
	}

}
