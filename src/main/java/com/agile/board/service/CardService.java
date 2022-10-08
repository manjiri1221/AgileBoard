package com.agile.board.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agile.board.dao.CardDao;
import com.agile.board.entity.Card;

import reactor.core.publisher.Mono;

/**
 * Service class for card operations
 * @author manjirilakhote
 *
 */
@Service
public class CardService {
	
	@Autowired
	CardDao cardDao;

	public Mono<Card> createCard(String name, ObjectId columnId, int sequence, ObjectId createdBy) {
		Card card = new Card(name,columnId,sequence,createdBy);
		return cardDao.save(card);
	}
	
	

}
