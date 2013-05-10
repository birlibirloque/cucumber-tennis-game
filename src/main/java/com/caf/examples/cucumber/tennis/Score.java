package com.caf.examples.cucumber.tennis;

public class Score {

	private PointsEnum scoreService = PointsEnum.love;
	private PointsEnum scoreRest = PointsEnum.love;

	private StateGame state = StateGame.NORMAL;

	public void winPoint(boolean service) {
		PointsEnum winner = service ? this.scoreService:this.scoreRest;
		PointsEnum loser  = service ? this.scoreRest:this.scoreService;
		PointsEnum newWinnerScore = calculateNewWinnerScore(winner, loser);
		this.scoreService = service ? newWinnerScore:loser;
		this.scoreRest    = service ? loser:newWinnerScore;
	}

	private PointsEnum calculateNewWinnerScore(PointsEnum winner, PointsEnum loser) {
		switch (this.state) {
		case NORMAL:
			winner = calculateNewWinnerScoreInNormalState(winner, loser);
			break;
		case DEUCE:
			winner = calculateNewWinnerScoreInDeuceState();
			break;
		case ADV:
			winner = calculateNewWinnerScoreInAdvantageState(loser);
			break;
		}
		return winner;
	}

	private PointsEnum calculateNewWinnerScoreInNormalState(PointsEnum winner,
			PointsEnum loser) {
		winner = winner.next();
		if (winner == PointsEnum.game) {
			this.state = StateGame.GAME;
		} else if ((winner == PointsEnum.forty) && (winner == loser)) {
			this.state = StateGame.DEUCE;
		}
		return winner;
	}

	private PointsEnum calculateNewWinnerScoreInDeuceState() {
		PointsEnum winner;
		this.state = StateGame.ADV;
		winner = PointsEnum.adv;
		return winner;
	}

	private PointsEnum calculateNewWinnerScoreInAdvantageState(PointsEnum loser) {
		PointsEnum winner;
		this.state = StateGame.GAME;
		winner = PointsEnum.game;
		if (loser == PointsEnum.adv) {
			this.state = StateGame.DEUCE;
			winner = PointsEnum.adv;
		}
		return winner;
	}

	public String getScore() {
		return correspondingCall();
	}

	private String correspondingCall() {
		String msg = "";

		switch (this.state) {
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
		case ADV:
			msg = "advantage ";
			if (this.scoreService == PointsEnum.adv)
				msg += "service";
			else
				msg += "rest";
			break;
		case GAME:
			msg = "game ";
			if (this.scoreService == PointsEnum.game) {
				if (this.scoreRest == PointsEnum.love) {
					msg += "love ";
				}
				msg += "service";
			} else {
				if (this.scoreService == PointsEnum.love) {
					msg += "love ";
				}
				msg += "rest. Break service";
			}
			break;
		}
		return msg;
	}
}
