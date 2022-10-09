package agile.board;



import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

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
	
	//Create a basic card.
	
	@Test
	public void createCardInColumnTest() throws Exception {
		
		String name = "card1";
		ObjectId columnId = new ObjectId("6341420bc0920229d1ba2bab");
		ObjectId createdBy = new ObjectId("6341420bc0920229d1ba2bab");
		int sequence = 1;
		Card card = cardService.createCard(name,columnId,sequence,createdBy).block();
		assertTrue(name.equals(card.getName()));
	}
	
	// Test with null name, it should throw an exception
	
	@Test(expected = Exception.class)
	public void createCardWithNullNameTest() throws Exception {
		
		String name = null;
		ObjectId columnId = new ObjectId("6341420bc0920229d1ba2bab");
		int sequence = 1;
		ObjectId createdBy = new ObjectId("6341420bc0920229d1ba2bab");
		cardService.createCard(name,columnId,sequence,createdBy).block();
		
	}
	
	// Test with empty name, it should throw an exception
	
	@Test(expected = Exception.class)
	public void createCardWithEmptyNameTest() throws Exception {
		
		String name = "";
		ObjectId columnId = new ObjectId("6341420bc0920229d1ba2bab");
		int sequence = 1;
		ObjectId createdBy = new ObjectId("6341420bc0920229d1ba2bab");
		cardService.createCard(name,columnId,sequence,createdBy).block();
		
	}
	
	// Test with null column, it should throw an exception
	
	@Test(expected = Exception.class)
	public void createCardWithoutColumnTest() throws Exception {
		
		String name = "card1";
		int sequence = 1;
		ObjectId createdBy = new ObjectId("6341420bc0920229d1ba2bab");
		cardService.createCard(name,null,sequence,createdBy).block();
		
	}
	
	// Test with null createdBy, it should throw an exception
	
	@Test(expected = Exception.class)
	public void createCardWithoutCreatedByTest() throws Exception {
		
		String name = "card1";
		int sequence = 1;
		ObjectId columnId = new ObjectId("6341420bc0920229d1ba2bab");
		cardService.createCard(name,columnId,sequence,null).block();
		
	}
	
	// Test with null createdBy and null column, it should throw an exception
	
	@Test(expected = Exception.class)
	public void createCardWithoutCreatedByAndColumnTest() throws Exception {
		
		String name = "card1";
		int sequence = 1;
		cardService.createCard(name,null,sequence,null).block();
		
	}
	
	// Test with null createdBy and null name, it should throw an exception
	
	@Test(expected = Exception.class)
	public void createCardWithoutCreatedByAndNameTest() throws Exception {
		
		int sequence = 1;
		ObjectId columnId = new ObjectId("6341420bc0920229d1ba2bab");
		cardService.createCard(null,columnId,sequence,null).block();
		
	}
	
	// Test with null column and null name, it should throw an exception
	
	@Test(expected = Exception.class)
	public void createCardWithoutColumnAndNameTest() throws Exception {
		
		int sequence = 1;
		ObjectId createdBy = new ObjectId("6341420bc0920229d1ba2bab");
		cardService.createCard(null,null,sequence,createdBy).block();
		
	}
	
	// Test with null column, null createdBy and null name, it should throw an exception
	
	@Test(expected = Exception.class)
	public void createCardWithoutColumnAndNameAndCreatedByTest() throws Exception {
		
		int sequence = 1;
		cardService.createCard(null,null,sequence,null).block();
		
	}
	
	//Create a card with tags
	
	@Test
	public void createCardWithTagsInColumnTest() throws Exception {
		
		String name = "card1";
		ObjectId columnId = new ObjectId("6341420bc0920229d1ba2bab");
		ObjectId createdBy = new ObjectId("6341420bc0920229d1ba2bab");
		List<String> tags = new ArrayList();
		tags.add("one");
		tags.add("green");
		tags.add("square");
		int sequence = 1;
		Card card = cardService.createCard(name,columnId,sequence,createdBy,tags).block();
		assertTrue(name.equals(card.getName()));
	}
	

	//Update a card with tag
	
	@Test
	public void updateCardWithTagTest() throws Exception {
		
		ObjectId cardId = new ObjectId("63421ecc9e21c74c1f5c934f");
		String tag = "circle";
		Card card = cardService.updateTagInCard(cardId,tag).block();
		assertTrue(card.getTags().contains(tag));
	}
	
	
	//Q2 Build a search service to list all cards containing a tag
	
	@Test
	public void listCardsWithATagTest() throws Exception {
		
		String tag = "circle";
		List<Card> cards = cardService.listCardsWithATag(tag).collectList().block();
		cards.forEach(card->{
			assertTrue(card.getTags().contains(tag));
		});	

	}
	
	
	

}
