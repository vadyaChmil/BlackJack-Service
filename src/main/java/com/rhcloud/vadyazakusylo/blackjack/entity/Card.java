package com.rhcloud.vadyazakusylo.blackjack.entity;

public class Card {
	private String rang;
	private String suit;

	public Card(String rang, String suit) {
		this.rang = rang;
		this.suit = suit;
	}

	public String getRang() {
		return rang;
	}

	public void setRang(String rang) {
		this.rang = rang;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

}