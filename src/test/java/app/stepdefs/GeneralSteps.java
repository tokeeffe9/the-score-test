package app.stepdefs;

import app.pages.Menu;
import app.pages.Team;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.DriverFactory;

import static org.junit.Assert.assertEquals;

public class GeneralSteps extends DriverFactory {

    private final Menu menu;
    private final Team team;


    public GeneralSteps() {

        menu = new Menu(driver);
        team = new Team(driver);
    }


    @When("I tap on favorites")
    public void iTapOnFavorites() {
        menu.tapFavorites();
    }

    @Then("^I am on the (.*) page$")
    public void iAmOnTheSpecificPage(String specificPage) {
        assertEquals("I am on the incorrect page",
                specificPage, team.getTeamName());
    }
}
