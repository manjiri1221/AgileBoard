package agile.board;



import static org.junit.Assert.assertTrue;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.agile.board.Application;
import com.agile.board.entity.Column;
import com.agile.board.service.ColumnService;
/**
 * Test class for Column
 * @author manjirilakhote
 *
 */
@DataMongoTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes=Application.class)
public class ColumnTest {

	@Autowired
	ColumnService columnService;
	
	@Test
	public void createColumnInBoardTest() throws Exception {
		
		String name = "column1";
		ObjectId boardId = new ObjectId("6341420bc0920229d1ba2bab");
		ObjectId createdBy = new ObjectId("6341420bc0920229d1ba2bab");
		int sequence = 1;
		Column column = columnService.createColumn(name,boardId,sequence,createdBy).block();
		assertTrue(name.equals(column.getName()));
	}
	
	// Test with null name, it should throw an exception
	
	@Test(expected = Exception.class)
	public void createColumnWithNullNameInBoardTest() throws Exception {
		
		String name = null;
		ObjectId boardId = new ObjectId("6341420bc0920229d1ba2bab");
		ObjectId createdBy = new ObjectId("6341420bc0920229d1ba2bab");
		int sequence = 1;
		columnService.createColumn(name,boardId,sequence,createdBy).block();
		
	}
	
	// Test with empty name, it should throw an exception
	
	@Test(expected = Exception.class)
	public void createColumnWithEmptyNameInBoardTest() throws Exception {
		
		String name = "";
		ObjectId boardId = new ObjectId("6341420bc0920229d1ba2bab");
		ObjectId createdBy = new ObjectId("6341420bc0920229d1ba2bab");
		int sequence = 1;
		columnService.createColumn(name,boardId,sequence,createdBy).block();
		
	}
	
	// Test without board, it should throw an exception
	
	@Test(expected = Exception.class)
	public void createColumnWithoutBoardTest() throws Exception {
		
		String name = "column1";
		ObjectId createdBy = new ObjectId("6341420bc0920229d1ba2bab");
		int sequence = 1;
		columnService.createColumn(name,null,sequence,createdBy).block();
		
	}
	
	// Test without createdBy, it should throw an exception
	
	@Test(expected = Exception.class)
	public void createColumnWithoutCreatedByTest() throws Exception {
		
		String name = "column1";
		ObjectId boardId = new ObjectId("6341420bc0920229d1ba2bab");
		int sequence = 1;
		columnService.createColumn(name,boardId,sequence,null).block();
		
	}
	
	// Test without createdBy and without board, it should throw an exception
	
	@Test(expected = Exception.class)
	public void createColumnWithoutCreatedByAndBoardTest() throws Exception {
		
		String name = "column1";
		int sequence = 1;
		columnService.createColumn(name,null,sequence,null).block();
		
	}
	
	// Test without name, createdBy and without board, it should throw an exception
	
	@Test(expected = Exception.class)
	public void createColumnWithoutNameAndCreatedByAndBoardTest() throws Exception {
		
		int sequence = 1;
		columnService.createColumn(null,null,sequence,null).block();
		
	}
	
	// Test without name and without board, it should throw an exception
	
	@Test(expected = Exception.class)
	public void createColumnWithoutNameAndBoardTest() throws Exception {
		
		int sequence = 1;
		ObjectId createdBy = new ObjectId("6341420bc0920229d1ba2bab");
		columnService.createColumn(null,null,sequence,createdBy).block();
		
	}
	
	// Test without name and without createdBy, it should throw an exception
	
	@Test(expected = Exception.class)
	public void createColumnWithoutNameAndCreatedByTest() throws Exception {
		
		int sequence = 1;
		ObjectId boardId = new ObjectId("6341420bc0920229d1ba2bab");
		columnService.createColumn(null,boardId,sequence,null).block();
		
	}

}
