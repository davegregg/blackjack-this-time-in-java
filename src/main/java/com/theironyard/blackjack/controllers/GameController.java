package com.theironyard.blackjack.controllers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;

import com.theironyard.blackjack.models.Dealer;
import com.theironyard.blackjack.models.Player;
import com.theironyard.blackjack.services.Rules;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GameController {
	
	private ModelAndView page;
	private Player player;
	private Dealer dealer;
	private Rules rules;
	private String message;
	
	private static final String DISABLED = "disabled";
	private static final String ENABLED = "";
	
	public GameController() {
		page = new ModelAndView("index");
		player = new Player("Player");
		dealer = new Dealer();
		rules = new Rules(player, dealer);
		message = "";
		
		setupTable();
		setupPage();
	}
	
	private void setupTable() {
		dealer.deal(player, 2);
		dealer.deal(dealer, 2);
	}

	private void setupPage() {
		page.addObject("title", "Blackjack");
		page.addObject("player", player);
		page.addObject("dealer", dealer);
	}
	
	@RequestMapping("/")
	public ModelAndView launch(HttpServletRequest request, Boolean onDeal, String playerName) {
		switch(request.getMethod()) {
			
			case "POST": 
				postRequestRouter(onDeal, playerName);
				page.addObject("playerDetailsFormState", DISABLED);
				break;
				
			case "GET": 
				page.addObject("playerDetailsFormState", ENABLED);
				break;
				
		}
		
		processRules();
		page.addObject("message", message);
		
		return page;
	}
	
	private void processRules() {
		if (rules.busted() != null) message = rules.busted().getName() + " busted!";
		if (rules.blackjack() != null) message = rules.blackjack().getName() + " got BLACKJACK!";
	}

	private void postRequestRouter(Boolean onDeal, String playerName) {
		
		if (onDeal != null) {
			dealer.deal(player);
		}
		
		if (playerName != null && playerName.length() > 0) {
			player.setName(sanitizeString(playerName));
		}
		
	}
	
	private String sanitizeString(String input) {
		Matcher safeCharacters = Pattern.compile("[\\w\\-.(),' ]")
				   					    						.matcher(input);
		String naivelySanitized = "";
		while (safeCharacters.find()) naivelySanitized += safeCharacters.group();
		
		return naivelySanitized;
	}
}
