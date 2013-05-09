package com.caf.examples.cucumber.tennis;

public class Player {

	private String name;
	private boolean isServing;
	
	public void setName(String player) { 
		this.name = player;
	}

	public String getName() {
		return this.name;
	}

	public void setService() {
	  this.isServing = true;
	}

	public boolean isServing() {
		return this.isServing;
	}

}
