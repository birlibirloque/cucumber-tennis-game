package com.caf.examples.cucumber.tennis;

public class TennisGame {

	private String player1;
	private String player2;
	private Score score = new Score();
	
	public TennisGame(String player1, String player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	public String whoArePlaying() {
		return player1 + " vs " + player2;
	}

	public String howIsScore() {
		return this.score.getScore();
	}

	public void setWinnerRace(String player) {
		this.score.playerWinPoint(player);		
	}

}
