package app.stepdefs;

import app.pages.LandingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.DriverFactory;

import static org.junit.Assert.assertEquals;

public class LoginSteps extends DriverFactory {

    private final LandingPage landingPage;

    public LoginSteps() {
        landingPage = new LandingPage(driver);
    }

    @Given("I open the Score application")
    public void iOpenTheScoreApplication() {
        //do nothing
    }

    @Then("I should see the home page")
    public void iShouldSeeSwagLabsLoginPage() {
        assertEquals(true, landingPage.isGetStartedDisplayed());
    }
}
