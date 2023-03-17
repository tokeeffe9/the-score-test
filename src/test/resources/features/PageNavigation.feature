@navigation
Feature: Verify the different flow of navigation through the application

  Background:
    Given I login with timthescore@gmail.com and scoretest details
    And I dismiss all pop-ups

  @favoriteTeam
  Scenario Outline: Verify user is on the correct team page
    And I tap on favorites
    When I tap <favorite option> on favorites page
    Then I am on the <specific page> page
    Examples:
      | favorite option | specific page     |
      | LIV             | Liverpool         |
      | DOR             | Borussia Dortmund |

  @squad
  Scenario Outline: Verify user can get to the squad page for the team selected
    And I tap on favorites
    And I tap <favorite option> on favorites page
    When I tap on Squad
    Then I see the following <players> listed
    Examples:
      | favorite option | players                                            |
      | LIV             | Alisson, Caoimhin Kelleher, Trent Alexander-Arnold |
      | LIV             | Alexander Meyer                                    |

  @backNavigation
  Scenario: Verify when I go to a team from favorites and tap back that I will land on my favorites
    And I tap on favorites
    And I tap LIV on favorites page
    When I tap the back navigation
    Then I see my favorites on the favorites page
      | Add |
      | UCL |
      | ENG |
      | DOR |
      | LIV |

