package com.theironyard.blackjack.models;

public enum Suit {
	
	SPADE, HEART, DIAMOND, CLUB;
	
	private final Integer unicodeRange;
	
	Suit() {
		unicodeRange = findUnicodeRange();
	}

	// REFERENCE: http://www.unicode.org/charts/PDF/U1F0A0.pdf
	private final Integer findUnicodeRange() {
		switch (name()) {
			case "SPADE":   return 0x1F0A0;
			case "HEART":   return 0x1F0B0;
			case "DIAMOND": return 0x1F0C0;
			case "CLUB":    return 0x1F0D0;
			default: 	    return 0;
		}
	}
	
	public Integer getUnicodeRange() {
		return unicodeRange;
	}
	
}
