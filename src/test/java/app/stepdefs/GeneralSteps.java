package app.stepdefs;

import app.pages.Scores;
import io.cucumber.java.en.When;
import utils.DriverFactory;


public class GeneralSteps extends DriverFactory {

    private final Scores scores;

    public GeneralSteps() {
        scores = new Scores(driver);
    }


    @When("I tap on favorites")
    public void iTapOnFavorites() {

        scores.waitForScorePage();
        scores.tapFavorites();
    }

}
