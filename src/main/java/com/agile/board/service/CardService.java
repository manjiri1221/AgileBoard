package com.agile.board.service;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

	public Mono<Card> createCard(String name, ObjectId columnId, int sequence, ObjectId createdBy) throws Exception {
		if(StringUtils.hasLength(name) && columnId!=null && createdBy!=null) {
			Card card = new Card(name,columnId,sequence,createdBy);
			return cardDao.save(card);
		}
		throw new Exception("Name or columnId or createdBy is null or empty");
	}
	
	public Mono<Card> createCard(String name, ObjectId columnId, int sequence, ObjectId createdBy, List<String> tags) throws Exception {
		if(StringUtils.hasLength(name) && columnId!=null && createdBy!=null && tags!=null & !tags.isEmpty()) {
			Card card = new Card(name,columnId,sequence,createdBy,tags);
			return cardDao.save(card);
		}
		throw new Exception("Name or columnId or createdBy or tags is null or empty");
	}

	public Mono<Card> updateTagInCard(ObjectId cardId, String tag) throws Exception {
		if(cardId!=null && StringUtils.hasLength(tag)) {
			 return cardDao.findById(cardId).flatMap(card->{
				 List<String> tags = card.getTags();
				 if(tags==null)
					 tags = new ArrayList();
				 tags.add(tag);
				 card.setTags(tags);
				 return cardDao.save(card);
			 });
		}
		throw new Exception("cardId or tag is null or empty");
	}
	

}
