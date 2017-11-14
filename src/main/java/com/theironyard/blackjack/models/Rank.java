package com.theironyard.blackjack.models;

public enum Rank {

	TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, 
	TEN, JACK, QUEEN, KING, ACE;
	
	private final Integer value;
	private final Integer unicodePosition;
	
	Rank() {
		value = findValue();
		unicodePosition = findUnicodePosition();
	}
	
	private final Integer findValue() {
		switch(name()) {
			case "TWO":   return 2;
			case "THREE": return 3;
			case "FOUR":  return 4;
			case "FIVE":  return 5;
			case "SIX":   return 6;
			case "SEVEN": return 7;
			case "EIGHT": return 8;
			case "NINE":  return 9;
			case "TEN": 
			case "JACK": 
			case "QUEEN": 
			case "KING":
				          return 10;
			case "ACE":   return 11;
			default:      return 0;
		}
	}
	
	public Integer getValue() {
		return value;
	}
	
	// REFERENCE: http://www.unicode.org/charts/PDF/U1F0A0.pdf
	private final Integer findUnicodePosition() {
		if (value < 10) return value;
		switch (name()) {
			case "TEN":   return 0xA;
			case "JACK":  return 0xB;
			case "QUEEN": return 0xD;
			case "KING":  return 0xE;
			case "ACE":   return 0x1;
			default:      return 0;
		}
	}
	
	public Integer getUnicodePosition() {
		return unicodePosition;
	}
	
}
