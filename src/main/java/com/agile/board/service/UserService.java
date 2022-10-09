package com.agile.board.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.agile.board.dao.UserDao;
import com.agile.board.dao.impl.UserDaoImpl;
import com.agile.board.entity.BoardVisit;
import com.agile.board.entity.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Class to service all the user related operations
 * @author manjirilakhote
 *
 */
@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	UserDaoImpl userDaoImpl;
	
	//Create a user
	public Mono<User> createUser(String name) throws Exception{
		if(StringUtils.hasLength(name)) {
			User user = new User(name);
			return userDao.save(user);
		}
		throw new Exception("name is null or empty");
	}

	// Get the time user last visited the given board
	public Flux<Map> getLastVisitedTimeForBoard(ObjectId userId, ObjectId boardId) {
		return userDaoImpl.getLastVisitedTimeForBoard(userId,boardId);
	}

	// Update whenever user visits the board
	public Mono<User> updateUserBoardVisit(ObjectId userId, ObjectId boardId) throws Exception {
		if(userId!=null && boardId!=null) {
			return userDao.findById(userId).flatMap(user->{
				List<BoardVisit> boardVisit = user.getBoards();
				AtomicBoolean flag = new AtomicBoolean(false);
				boardVisit.forEach(val->{
					if(boardId.equals(val.getBoardId())) {
							val.setLastVisitedOn(new Date());
							flag.set(true);
					}
				});
				if (!flag.get()) 
					boardVisit.add(new BoardVisit(boardId,new Date()));
				
				user.setBoards(boardVisit);
				return userDao.save(user);
			});
		}
		throw new Exception("name is null or empty");
	}

}
