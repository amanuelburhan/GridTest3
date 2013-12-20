@SashimiLogin

Feature: Login to Sashimi
    
    Scenario: I am on the Sashimi page and I log in. 
  	Given I am on the homepage
  	And I enter in my login credentials "selenium001" and "password"
  	Then I should be logged in