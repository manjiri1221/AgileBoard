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
	public void createColumnInBoardTest() {
		
		String name = "column1";
		ObjectId boardId = new ObjectId("6341420bc0920229d1ba2bab");
		ObjectId createdBy = new ObjectId("6341420bc0920229d1ba2bab");
		int sequence = 1;
		Column column = columnService.createColumn(name,boardId,sequence,createdBy).block();
		assertTrue(name.equals(column.getName()));
	}

}
