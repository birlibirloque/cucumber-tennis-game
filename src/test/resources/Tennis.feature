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

Scenario: Play to "fifteen-love"
	When "Nadal" win the point
	And I request how is the score
	Then I see the score is "fifteen-love"

Scenario: Play to "love-fifteen"
	When "Federer" win the point
	And I request how is the score
	Then I see the score is "love-fifteen"

Scenario: Play to "fifteen-all"
	When sequence winner points are "Nadal, Federer"
	And I request how is the score
	Then I see the score is "fifteen-all"
	
Scenario: Play to "therty-love"
	When sequence winner points are "Nadal, Nadal"
	And I request how is the score
	Then I see the score is "therty-love"

Scenario: Play to "love-therty"
	When sequence winner points are "Federer, Federer"
	And I request how is the score
	Then I see the score is "love-therty"

Scenario: Play to "therty-fifteen"
	When sequence winner points are "Nadal, Federer, Nadal"
	And I request how is the score
	Then I see the score is "therty-fifteen"
	
Scenario: Play to "fifteen-therty"
	When sequence winner points are "Nadal, Federer, Federer"
	And I request how is the score
	Then I see the score is "fifteen-therty"
	
Scenario: Play to "therty-all"
	When sequence winner points are "Nadal, Federer, Federer, Nadal"
	And I request how is the score
	Then I see the score is "therty-all"
	
Scenario: Play "forty-therty"
	When sequence winner points are "Nadal, Federer, Federer, Nadal, Nadal"
	And I request how is the score
	Then I see the score is "forty-therty"
	
Scenario: Play to "game Nadal"
	When sequence winner points are "Nadal, Federer, Federer, Nadal, Nadal, Nadal"
	And I request how is the score
	Then I see the score is "game Nadal"

Scenario: Play to "game love Nadal"
	When sequence winner points are "Nadal, Nadal, Nadal, Nadal"
	And I request how is the score
	Then I see the score is "game love"
	
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
