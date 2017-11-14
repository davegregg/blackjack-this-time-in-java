package com.theironyard.blackjack.models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Card {
	
	TWOOFSPADE, THREEOFSPADE, FOUROFSPADE, FIVEOFSPADE, SIXOFSPADE, SEVENOFSPADE, EIGHTOFSPADE, NINEOFSPADE, TENOFSPADE, JACKOFSPADE, QUEENOFSPADE, KINGOFSPADE, ACEOFSPADE, 
	TWOOFHEART, THREEOFHEART, FOUROFHEART, FIVEOFHEART, SIXOFHEART, SEVENOFHEART, EIGHTOFHEART, NINEOFHEART, TENOFHEART, JACKOFHEART, QUEENOFHEART, KINGOFHEART, ACEOFHEART, 
	TWOOFDIAMOND, THREEOFDIAMOND, FOUROFDIAMOND, FIVEOFDIAMOND, SIXOFDIAMOND, SEVENOFDIAMOND, EIGHTOFDIAMOND, NINEOFDIAMOND, TENOFDIAMOND, JACKOFDIAMOND, QUEENOFDIAMOND, KINGOFDIAMOND, ACEOFDIAMOND, 
	TWOOFCLUB, THREEOFCLUB, FOUROFCLUB, FIVEOFCLUB, SIXOFCLUB, SEVENOFCLUB, EIGHTOFCLUB, NINEOFCLUB, TENOFCLUB, JACKOFCLUB, QUEENOFCLUB, KINGOFCLUB, ACEOFCLUB;
	
	private final Suit suit;
	private final Rank rank;
	private final String unicodeSymbol;
	
	Card() {
		suit = Suit.valueOf(findTrait("suit"));
		rank = Rank.valueOf(findTrait("rank"));
		
		unicodeSymbol = findUnicodeSymbol();
	}
	
	private String findTrait(String captureGroup) {
		Matcher matcher = Pattern.compile("(?<rank>[A-Z]+)" + "OF" + "(?<suit>[A-Z]+)")
				 				 .matcher(name());
		matcher.find();
		return matcher.group(captureGroup);
	}
	
	private String findUnicodeSymbol() {
		int codePoint = suit.getUnicodeRange() + rank.getUnicodePosition();
		return String.valueOf(Character.toChars(codePoint));
	}
	
	public Rank getRank() {
		return rank;
	}
	
	public Suit getSuit() {
		return suit;
	}
	
	public Integer getValue() {
		return rank.getValue();
	}
	
	public String toString() {
		return unicodeSymbol;
	}
	
}
