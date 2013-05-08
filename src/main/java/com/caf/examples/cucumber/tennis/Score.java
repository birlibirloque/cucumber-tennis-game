package com.caf.examples.cucumber.tennis;

public class Score {
	
	private PointsEnum scoreP1 = PointsEnum.love;
	private PointsEnum scoreP2 = PointsEnum.love;
	
	public String getScore() {
		return correspondingCall();
	}

	public void playerWinPoint(String player) {
		if (player.equals("Nadal")) 
			this.scoreP1 = addOnePoint(this.scoreP1, this.scoreP2);
		else
			this.scoreP2 = addOnePoint(this.scoreP2, this.scoreP1);
	}

	private PointsEnum addOnePoint(PointsEnum scoreA, PointsEnum scoreB) {
		if (scoreA == PointsEnum.deuce)
		  scoreA = PointsEnum.adv;
		else if ((scoreA == PointsEnum.adv) || (scoreA == PointsEnum.forty))
		  scoreA = PointsEnum.game;
		else if ((scoreA == PointsEnum.therty) && (scoreB == PointsEnum.forty)) {	
		  scoreA = PointsEnum.deuce;
      	  scoreB = PointsEnum.deuce;
		}
		else
		  scoreA = scoreA.next();
		
		return scoreA;
	}
	
	private String correspondingCall(){
		String msg = "";
		if (this.scoreP1.equals(this.scoreP2))
		  msg = this.scoreP1 + "-all";
		else if ((this.scoreP1.equals(PointsEnum.deuce)) ||
				 (this.scoreP2.equals(PointsEnum.deuce)))
		  msg = "deuce";
		else if ((this.scoreP1.equals(PointsEnum.game)) &&
				 (this.scoreP2.equals(PointsEnum.love)))
		  msg = "game love";
		else if ((this.scoreP2.equals(PointsEnum.game)) &&
				 (this.scoreP1.equals(PointsEnum.love)))
		  msg = "game love";
		else if ((this.scoreP1.equals(PointsEnum.game)) ||
				 (this.scoreP2.equals(PointsEnum.game)))
		  msg = "game";
		else 			
		  msg = this.scoreP1 + "-" + this.scoreP2;
		return msg;
	}
}
