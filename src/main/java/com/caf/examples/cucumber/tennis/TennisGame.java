package com.caf.examples.cucumber.tennis;

public class TennisGame {

	private String player1;
	private String player2;

	private String correspondingCall [][] = {
			{"love-all", "love-15", "love-30", "love-40",    "game",       "error"},
			{"15-love",  "15-all",  "15-30",   "15-40",      "game",       "error"},
			{"30-love",  "30-15",   "30-all",  "30-40",      "game",       "error"},
			{"40-love",  "40-15",   "40-30",   "deuce",      "advantage",  "game" },
			{"game",     "game",    "game",    "advantage",  "deuce",      "error"},
			{"error",    "error",   "error",   "game ",      "error",      "error"}
			};

	int score1;
	int score2;
	
	public TennisGame(String player1, String player2) {
		this.player1 = player1;
		this.player2 = player2;
		this.score1  = 0;
		this.score2  = 0;
	}

	public String whoArePlaying() {
		return player1 + " vs " + player2;
	}

	public String howIsScore() {
		String score = this.correspondingCall[score1][score2];
		if ((score == "game") || (score == "advantage"))  {
			if (score1 > score2){
				score += " " + player1;
			}
			else {
				score += " " + player2;				
			}
		}
		return score;
	}

	public void setWinnerRace(String player) {
		if (player == player1) {
			score1 += 1;		
		}
		else if (player == player2) {
			score2 += 1;					
		}
		if ((score1 == 4) && (score2 == 4)) {
			score1 = 3;
			score2 = 3;
		}
	}

}
