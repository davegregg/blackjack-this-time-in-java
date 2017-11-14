package com.theironyard.blackjack.models;

public class Dealer extends Player {

	private Deck deck;
	
	public Dealer() {
		super("Dealer");
		deck = new Deck();
	}
	
	public void deal(Player player) {
		player.addToHand(deck.draw());
	}
	
	public void deal(Player player, int count) {
		while (count > 0) {			
			player.addToHand(deck.draw());
			count -= 1;
		}
	}
	
}
