package agile.board;


import static org.junit.jupiter.api.Assertions.assertTrue;

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
	public void createUserTest() {
		String name = "user1";
		User user = userService.createUser(name).block();
		assertTrue(user!=null && name.equals(user.getName()));
	}

}
