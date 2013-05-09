package com.caf.examples.cucumber.tennis;

public class TennisGame {

	private Player player1 = new Player();
	private Player player2 = new Player();
	private Score score = new Score();	
	
	public TennisGame(String player1, String player2) {
		this.player1.setName(player1);
		this.player2.setName(player2);		
	}

	public String whoArePlaying() {
		return this.player1.getName() + " vs " + this.player2.getName();
	}

	public String howIsScore() {
		return this.score.getScore();
	}

	public void setWinnerRace(String player) {
		if (isServing(player))
		  this.score.serviceWinPoint();
		else
		  this.score.restWinPoint();
	}

	private boolean isServing(String player) {
		boolean ret = false;
		if (this.player1.getName().equals(player)) 
		  ret = this.player1.isServing();
		else
		  ret = this.player2.isServing();
		return ret;
	}

	public void setService(String player) {
	    if (this.player1.getName().equals(player))
		  this.player1.setService();
	    else
	      this.player2.setService();		
	}

}
