package com.theironyard.blackjack.models;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	
	List<Card> cards = new ArrayList<>();
	
	public Integer total() {
		Integer total = 0;
		for (Card card : cards) total += card.getValue();
		
		return total;
	}
	
	public Hand add(Card card) {
		cards.add(card);
		return this;
	}
	
	public void clear() {
		cards.clear();
	}
	
	public List<Card> getCards() {
		return cards;
	}
	
}
