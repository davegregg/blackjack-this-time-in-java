package com.theironyard.blackjack.models;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Deck {
	private List<Card> deck = new LinkedList<>();
	
	public Deck() {
		for(Card card : Card.values()) deck.add(card);
		Collections.shuffle(deck);
	}
	
	public List<Card> getCards() {
		return deck;
	}
	
	public List<Card> shuffle() {
		Collections.shuffle(deck);
		return deck;
	}
	
	public Card draw() {
		return deck.remove(deck.size() - 1);
	}

}
