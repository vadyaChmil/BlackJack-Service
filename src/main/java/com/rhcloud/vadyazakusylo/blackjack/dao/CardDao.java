package com.rhcloud.vadyazakusylo.blackjack.dao;

import java.util.List;

import com.rhcloud.vadyazakusylo.blackjack.entity.Card;

public interface CardDao {

	List<Card> getCardDeck();

	Card getCard();

	void clearCardDeck();

}
