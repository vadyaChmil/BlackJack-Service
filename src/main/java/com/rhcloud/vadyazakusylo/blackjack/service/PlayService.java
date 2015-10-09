package com.rhcloud.vadyazakusylo.blackjack.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rhcloud.vadyazakusylo.blackjack.dao.CardDao;
import com.rhcloud.vadyazakusylo.blackjack.entity.Card;

@Component
@Path("/play")
public class PlayService {

	@Autowired
	CardDao cardDao;

	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
		String output = "Jersey say : " + msg;
		return Response.status(200).entity(output).build();
	}

	@GET
	@Path("/deal")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Card> getTwoCard() {
		Card newCard1 = cardDao.getCardDeck().get(0);
		Card newCard2 = cardDao.getCardDeck().get(1);
		List<Card> list = new ArrayList<Card>();
		list.add(newCard1);
		list.add(newCard2);
		return list;
	}

	@GET
	@Path("/hit")
	@Produces(MediaType.APPLICATION_JSON)
	public Card getOneCard() {
		Card newCard = cardDao.getCardDeck().get(0);
		return newCard;
	}

	// @GET
	// @Path("/deal")
	// @GET
	// @Path("/insurance")
	// @GET
	// @Path("/hit")
	// @GET
	// @Path("/stand")
	// @GET
	// @Path("/split")
}