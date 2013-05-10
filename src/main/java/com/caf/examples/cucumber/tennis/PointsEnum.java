package com.caf.examples.cucumber.tennis;

public enum PointsEnum {
  love,  
  fifteen, 
  therty,
  forty,
  game,
  adv;
 
  public PointsEnum next() {
      return values()[(ordinal() + 1) % values().length];
  }

}
