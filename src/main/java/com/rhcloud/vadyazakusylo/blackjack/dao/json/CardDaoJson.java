package com.rhcloud.vadyazakusylo.blackjack.dao.json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.rhcloud.vadyazakusylo.blackjack.dao.CardDao;
import com.rhcloud.vadyazakusylo.blackjack.entity.Card;

public class CardDaoJson implements CardDao {

	private List<Card> cardDeck = null;
	final private String resource = "file/card_deck.json";

	@Override
	public List<Card> getCardDeck() {
		if (cardDeck != null) {
			return cardDeck;
		}
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(resource).getFile());

		cardDeck = new ArrayList<>();
		try {
			JSONParser jsonParser = new JSONParser();
			JSONArray cardDesk = (JSONArray) jsonParser.parse(new FileReader(file));
			
			@SuppressWarnings("unchecked")
			Iterator<JSONObject> iterator = cardDesk.iterator();
			while (iterator.hasNext()) {
				JSONObject jsonCard = iterator.next();
				String rang = (String) jsonCard.get("rang");
				String suit = (String) jsonCard.get("suit");
				cardDeck.add(new Card(rang, suit));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return cardDeck;
	}

	@Override
	public Card getCard() {
		int indexRandomCard = (int) (1 + Math.random() * cardDeck.size());
		Card randomCard = cardDeck.get(indexRandomCard);
		cardDeck.remove(indexRandomCard);
		return randomCard;
	}

	@Override
	public void clearCardDeck() {
		cardDeck = null;
	}

}