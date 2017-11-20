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
	
	/**
	 * Removes last `count` cards from the deck and adds the card to the given Player's hand.
	 * @param		Player		player to be dealt the cards
	 * @param   int				number of cards to be dealt
	 */
	public void deal(Player player, int count) {
		while (count > 0) {			
			player.addToHand(deck.draw());
			count -= 1;
		}
	}
	
}
