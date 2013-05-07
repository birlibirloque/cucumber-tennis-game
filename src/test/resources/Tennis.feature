#languaje: en

Feature: Tennis Game
	Description

Background:
	Given a new tennis match between "Nadal" and "Federer" 

Scenario: Check players
	When I request who are playing the match
	Then I see the players are "Nadal vs Federer"

Scenario: Initial score to "love-all"
	When I request how is the score
	Then I see the score is "love-all"

Scenario: Play to "15-love"
	When "Nadal" win the point
	And I request how is the score
	Then I see the score is "15-love"

Scenario: Play to "love-15"
	When "Federer" win the point
	And I request how is the score
	Then I see the score is "love-15"

Scenario: Play to "15-all"
	When sequence winner points are "Nadal, Federer"
	And I request how is the score
	Then I see the score is "15-all"
	
Scenario: Play to "30-love"
	When sequence winner points are "Nadal, Nadal"
	And I request how is the score
	Then I see the score is "30-love"

Scenario: Play to "love-30"
	When sequence winner points are "Federer, Federer"
	And I request how is the score
	Then I see the score is "love-30"

Scenario: Play to "30-15"
	When sequence winner points are "Nadal, Federer, Nadal"
	And I request how is the score
	Then I see the score is "30-15"
	
Scenario: Play to "15-30"
	When sequence winner points are "Nadal, Federer, Federer"
	And I request how is the score
	Then I see the score is "15-30"
	
Scenario: Play to "30-all"
	When sequence winner points are "Nadal, Federer, Federer, Nadal"
	And I request how is the score
	Then I see the score is "30-all"
	
Scenario: Play "40-30"
	When sequence winner points are "Nadal, Federer, Federer, Nadal, Nadal"
	And I request how is the score
	Then I see the score is "40-30"
	
Scenario: Play to "game Nadal"
	When sequence winner points are "Nadal, Federer, Federer, Nadal, Nadal, Nadal"
	And I request how is the score
	Then I see the score is "game Nadal"
	
Scenario: Play to "game Federer"
	When sequence winner points are "Nadal, Federer, Federer, Nadal, Federer, Federer"
	And I request how is the score
	Then I see the score is "game Federer"
	
Scenario: Play to "deuce"
	When sequence winner points are "Nadal, Federer, Federer, Nadal, Nadal, Federer"
	And I request how is the score
	Then I see the score is "deuce"

Scenario: Play to "deuce"
	When sequence winner points are "Nadal, Federer, Federer, Nadal, Nadal, Federer, Nadal, Federer, Nadal, Federer, Nadal, Federer"
	And I request how is the score
	Then I see the score is "deuce"

Scenario: Play to "advantage Nadal"
	When sequence winner points are "Nadal, Federer, Federer, Nadal, Nadal, Federer, Nadal"
	And I request how is the score
	Then I see the score is "advantage Nadal"

Scenario: Play to "advantage Federer"
	When sequence winner points are "Nadal, Federer, Federer, Nadal, Nadal, Federer, Federer"
	And I request how is the score
	Then I see the score is "advantage Federer"
