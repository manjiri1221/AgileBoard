package com.agile.board.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.agile.board.dao.CardDao;
import com.agile.board.entity.Card;

import reactor.core.publisher.Flux;
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
	
	@Autowired
	UserService userService;

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

	//Q2. Build a search service to list all cards containing a tag
	public Flux<Card> listCardsWithATag(String tag) throws Exception {
		if(StringUtils.hasLength(tag)) {
			return cardDao.findAllByTagsAndIsActive(tag,true);
		}
		throw new Exception("tag is null or empty");
	}

	//Q3 Build a search service to list all cards in a column
	public Flux<Card> listCardsInAColumn(ObjectId columnId) throws Exception {
		if(columnId!=null) {
			return cardDao.findAllByColumnIdAndIsActive(columnId,true);
		}
		throw new Exception("columnId is null");
	}
	
	//Q4 Build a service to list all cards created after a given timestamp
	public Flux<Card> listCardsCreatedAfterTimestamp(Date timestamp) throws Exception {
		if(timestamp!=null) {
			return cardDao.findAllByCreatedOnGreaterThan(timestamp);
		}
		throw new Exception("timestamp is null");
		
	}

	//Q5 Build a service to lists all the cards which should be highlighted for a user
	public Flux<Card> listCardsToHighlightToUser(ObjectId userId, ObjectId boardId) throws Exception {
		if(userId!=null && boardId!=null) {
			return userService.getLastVisitedTimeForBoard(userId,boardId).flatMap(boardVisit->{
				 return listCardCreatedOrLastModifiedAfterLastVisitedTime(( boardVisit.getLastVisitedOn()));
			});
			
		}
		throw new Exception("userId or boardId is null");
	}

	private Flux<Card> listCardCreatedOrLastModifiedAfterLastVisitedTime(Date lastVisitedOn) {
		return cardDao.findAllByCreatedOnGreaterThanOrLastModifiedOnGreaterThan(lastVisitedOn);
		
	}
	

}
