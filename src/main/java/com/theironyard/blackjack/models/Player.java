package com.theironyard.blackjack.models;

public class Player {

	private String name;
	private Hand hand;
	
	public Player(String name) {
		this.name = name;
		hand = new Hand();
	}
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public Hand addToHand(Card card) {
		return hand.add(card);
	}
	
	public Hand getHand() {
		return hand;
	}
	
	public void clearHand() {
		hand = new Hand();
	}

}
