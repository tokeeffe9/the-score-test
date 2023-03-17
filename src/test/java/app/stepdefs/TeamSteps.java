package app.stepdefs;

import app.pages.Team;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.DriverFactory;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TeamSteps extends DriverFactory {


    private final Team team;

    public TeamSteps() {
        team = new Team(driver);
    }

    @Then("^I am on the (.*) page$")
    public void iAmOnTheSpecificPage(String specificPage) {
        assertEquals("I am on the incorrect page",
                specificPage, team.getTeamName());
    }

    @And("I tap on Squad")
    public void iTapOnSquad() {
        team.tapSquadOnTab();
    }

    @Then("^I see the following (.*) listed$")
    public void iSeeTheFollowingPlayersListed(String playersString) {
        List<String> playersNames = Arrays.asList(playersString.split(", "));
        playersNames.forEach(playerName ->
                assertTrue(playerName + " is not present in squad", team.isPlayerNamePresent(playerName)));
    }

    @When("I tap the back navigation")
    public void iTapTheBackNavigation() {
        team.tapNavigateBack();
    }
}
