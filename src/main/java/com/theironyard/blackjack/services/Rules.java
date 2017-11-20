package com.theironyard.blackjack.services;

import com.theironyard.blackjack.models.Dealer;
import com.theironyard.blackjack.models.Player;

public class Rules {
	
	private Player player;
	private Dealer dealer;
	
	public Rules(Player player, Dealer dealer) {
		this.player = player;
		this.dealer = dealer;
	}
	
	

	private Boolean playerBusted() { return player.getHand().total() > 21; }
	private Boolean dealerBusted() { return dealer.getHand().total() > 21; }
	
	/**
	 * Returns the Player who has Blackjack. If both Players have Blackjack, the user player will be returned.
	 * Otherwise returns null.
	 */
	public Player busted() {
		if (playerBusted()) return player;
		if (dealerBusted()) return dealer;
		return null;
	}
	
	
	
	private Boolean playerBlackjack() { return player.getHand().total() == 21; }
	private Boolean dealerBlackjack() { return dealer.getHand().total() == 21; }
	
	///<summary>
	///returns the respective Player object if the player or dealer gets a Blackjack, otherwise returns null
	///</summary>
	public Player blackjack() {
		if (playerBlackjack()) return player;
		if (dealerBlackjack()) return dealer;
		return null;
	}
	
	
}
