package com.agile.board.controller;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.agile.board.entity.Card;
import com.agile.board.model.CardDto;
import com.agile.board.service.CardService;

import reactor.core.publisher.Flux;

/**
 * Rest Controller for Cards related operations
 * @author manjirilakhote
 *
 */
@RestController
@RequestMapping("/api/agile-board/cards")
public class CardController {
	
	@Autowired
	private CardService cardService;
	
	//Build a search service to list all cards containing a tag
	
	@RequestMapping(value="/list/tag/{tag}",method = RequestMethod.GET)
	public Flux<Card> listCardsWithATag(@PathVariable String tag) throws Exception {
		return cardService.listCardsWithATag(tag);
	}
	
	//Build a search service to list all cards in a column
	
	@RequestMapping(value = "/list/column/{columnId}", method = RequestMethod.GET)	
	public Flux<CardDto> listCardsInAColumn(@PathVariable String columnId) throws Exception {
		return cardService.listCardsInAColumn(new ObjectId(columnId));
	}
	
	//Build a service to list all cards created after a given timestamp
	
	@RequestMapping(value = "/list/timestamp/{timestamp}", method = RequestMethod.GET)
	public Flux<Card> listCardsCreatedAfterTimestamp(@PathVariable long timestamp) throws Exception {
		return cardService.listCardsCreatedAfterTimestamp(new Date(timestamp));
	}
	
	//Build a service to lists all the cards which should be highlighted for a user
	
	@RequestMapping(value ="/list/user/{userId}/board/{boardId}")
	public Flux<Card> listCardsToHighlightToUser(@PathVariable String userId, @PathVariable String boardId) throws Exception {
		return cardService.listCardsToHighlightToUser(new ObjectId(userId), new ObjectId(boardId));
	}
		
			
		

}
