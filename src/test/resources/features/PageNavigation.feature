@regression @navigation
Feature: Verify the different flow of navigation to a team, player or league is correct

  Background:
    Given I login with timthescore@gmail.com and scoretest details
    And I dismiss all pop-ups

  Scenario Outline: Verify user is on the correct league, team, player page
    When I tap on favorites
    And I tap <favorite option> on favorites page
    Then I am on the <specific page> page
    Examples:
      | favorite option | specific page |
      | LIV             | Liverpool     |

