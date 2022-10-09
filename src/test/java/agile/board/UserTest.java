package agile.board;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.agile.board.Application;
import com.agile.board.entity.User;
import com.agile.board.service.UserService;
/**
 * Test class for user
 * @author manjirilakhote
 *
 */
@DataMongoTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes=Application.class)
public class UserTest {
	
	@Autowired
	UserService userService;

	@Test
	public void createUserTest() throws Exception {
		String name = "user1";
		User user = userService.createUser(name).block();
		assertTrue(user!=null && name.equals(user.getName()));
	}
	
	@Test(expected = Exception.class)
	public void createUserWithBlankNameTest() throws Exception {
		String name = "";
		userService.createUser(name).block();

	}
	
	@Test(expected = Exception.class)
	public void createUserWithNullNameTest() throws Exception {
		String name = null;
		userService.createUser(name).block();

	}
	
	@Test
	public void updateUserAfterBoardVisitTest() throws Exception {
		ObjectId userId = new ObjectId("634240646de61b2e5c212a02");
		ObjectId boardId = new ObjectId("6342042f86d8d564ddb1f819");
		User user = userService.updateUserBoardVisit(userId,boardId).block();
		assertTrue(user!=null && user.getBoards()!=null);
	}
}
