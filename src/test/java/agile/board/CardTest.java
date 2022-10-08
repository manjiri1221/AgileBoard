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
import com.agile.board.entity.Card;
import com.agile.board.service.CardService;
/**
 * Test class for Column
 * @author manjirilakhote
 *
 */
@DataMongoTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes=Application.class)
public class CardTest {

	@Autowired
	CardService cardService;
	
	@Test
	public void createCardInColumnTest() {
		
		String name = "card1";
		ObjectId columnId = new ObjectId("6341420bc0920229d1ba2bab");
		ObjectId createdBy = new ObjectId("6341420bc0920229d1ba2bab");
		int sequence = 1;
		Card card = cardService.createCard(name,columnId,sequence,createdBy).block();
		assertTrue(name.equals(card.getName()));
	}

}
