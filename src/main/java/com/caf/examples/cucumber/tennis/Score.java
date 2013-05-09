package com.caf.examples.cucumber.tennis;

public class Score {
	
	private PointsEnum scoreService = PointsEnum.love;
	private PointsEnum scoreRest    = PointsEnum.love;
	
	private StateGame state = StateGame.NORMAL;
	
	public String getScore() {			
		return correspondingCall();		
	}

	public void serviceWinPoint(){
		switch (this.state){
		  case NORMAL:
			if (this.scoreService == PointsEnum.forty)
				this.state = StateGame.GAME_S;				
			else if ((this.scoreRest == PointsEnum.forty) &&
					 (this.scoreService == PointsEnum.therty)) {
				this.scoreService = this.scoreService.next();
				this.state = StateGame.DEUCE;				
			}
			else
				this.scoreService = this.scoreService.next();
			break;
		  case DEUCE:
			this.state = StateGame.ADV_S;
			break;
		  case ADV_S:
			 this.state = StateGame.GAME_S;
			 break;
		  case ADV_R:
			 this.state = StateGame.DEUCE;
			 break;
		}
	}	
	
	public void restWinPoint(){
		switch (this.state){
		  case NORMAL:
			if (this.scoreRest == PointsEnum.forty)
				this.state = StateGame.GAME_R;				
			else if ((this.scoreService == PointsEnum.forty) &&
					 (this.scoreRest == PointsEnum.therty)) {
				this.scoreRest = this.scoreRest.next();
				this.state = StateGame.DEUCE;				
			}
			else
				this.scoreRest = this.scoreRest.next();
			break;
		  case DEUCE:
			this.state = StateGame.ADV_R;
			break;
		  case ADV_S:
			 this.state = StateGame.DEUCE;
			 break;
		  case ADV_R:
			 this.state = StateGame.GAME_R;
			 break;
		}
	}
	
	private String correspondingCall(){
		String msg = "";
		
		switch (this.state){
		  case NORMAL:
			if (this.scoreService.equals(this.scoreRest))
			  msg = this.scoreService + "-all";
			else if (this.scoreService == PointsEnum.love)
			  msg = "love-" + this.scoreRest;
			else if (this.scoreRest == PointsEnum.love)
			  msg = this.scoreService + "-love";
			else 
			  msg = this.scoreService + "-" + this.scoreRest;
			break;
		  case DEUCE:
			msg = "deuce";
			break;
		  case ADV_S:
			msg = "advantage service";
			break;
		  case ADV_R:
			msg = "advantage rest";
			break;
		  case GAME_S:
			if (this.scoreRest == PointsEnum.love)
			  msg = "game love service";
			else
			  msg = "game service";
			break;
		  case GAME_R:
  		    if (this.scoreService == PointsEnum.love)
			  msg = "game love rest.";
			else
			  msg = "game rest.";
  		    msg += " Break service";
			break;
		}
		return msg;
	}
}
