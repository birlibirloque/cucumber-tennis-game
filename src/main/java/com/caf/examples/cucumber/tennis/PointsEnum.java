package com.caf.examples.cucumber.tennis;

public enum PointsEnum {
  love,  
  fifteen, 
  therty,
  forty,
  deuce,
  adv,
  game;  
 
  public PointsEnum next() {
      return values()[(ordinal() + 1) % values().length];
  }

}
