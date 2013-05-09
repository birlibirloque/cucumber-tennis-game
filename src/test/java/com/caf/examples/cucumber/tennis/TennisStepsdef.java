package com.caf.examples.cucumber.tennis;

import static org.junit.Assert.*;

import java.util.List;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TennisStepsdef {

	private TennisGame tennisGame;
	private String players;
	private String score;
	
	@Given("^a new tennis match between \"([^\"]*)\" and \"([^\"]*)\"$")
	public void a_new_tennis_match_between (String player1, String player2) {
		tennisGame = new TennisGame (player1, player2);
	}

	@When("^I request who are playing the match$")
	public void I_request_who_are_playing_the_match() {
		players = tennisGame.whoArePlaying ();
	}

	@Then("^I see the players are \"([^\"]*)\"$")
	public void I_see_the_playing_are(String expectedPlayers) {
		assertEquals(expectedPlayers, players);
	}
	
	@When("^I request how is the score$")
	public void I_request_how_is_the_score() {
		score = tennisGame.howIsScore();
	}

	@When("^\"([^\"]*)\" is serving$")
	public void is_serving(String player) {	    
		tennisGame.setService(player);
	}
	
	@When("^\"([^\"]*)\" win the point$")
	public void win_the_point(String player) {		
		tennisGame.setWinnerRace(player);
	}
	
	@Then("^I see the score is \"([^\"]*)\"$")
	public void I_see_the_score_is(String expectedScore) {
		assertEquals(expectedScore, score);
	}

	@When("^sequence winner points are \"(.+)\"$")
	public void sequence_winner_points_are(List<String> winnersPoint) {
		for ( String player : winnersPoint) {
			tennisGame.setWinnerRace(player);			
		}
	}
}
