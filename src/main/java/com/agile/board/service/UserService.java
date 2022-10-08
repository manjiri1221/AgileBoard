package com.agile.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agile.board.dao.UserDao;
import com.agile.board.entity.User;

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
	
	public Mono<User> createUser(String name){
		User user = new User(name);
		return userDao.save(user);
		 
	}

}
