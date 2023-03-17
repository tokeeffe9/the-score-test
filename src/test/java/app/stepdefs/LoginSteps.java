package app.stepdefs;

import app.pages.Landing;
import app.pages.modals.LocationModal;
import app.pages.modals.TheScoreBetModal;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import utils.DriverFactory;

public class LoginSteps extends DriverFactory {

    private final Landing landing;
    private final TheScoreBetModal theScoreBetModal;
    private final LocationModal locationModal;

    public LoginSteps() {

        landing = new Landing(driver);
        theScoreBetModal = new TheScoreBetModal(driver);
        locationModal = new LocationModal(driver);
    }

    @Given("^I login with (.*) and (.*) details$")
    public void iLoginWithUsernameAndPasswordDetails(String email, String password) {

        landing.tapLandingLogIn();
        landing.enterLoginInformation(email, password);
        landing.tapLogInButton();
    }

    @And("I dismiss all pop-ups")
    public void iDismissAllPopUps() {

        //Had to use a do while loop along with try catch as I found while testing that the pop ups were not consistent.
        //This is not my favorite approach but if I've time I'll come back to it
        boolean locationModalClicked = false;
        boolean betModalClicked = false;
        int limit = 0;
        do {
            if (!locationModalClicked) {
                try {
                    locationModal.tapMaybeLater();
                    locationModalClicked = true;
                } catch (Exception ignored) {
                }
            }
            if (!betModalClicked) {
                try {
                    theScoreBetModal.tapDismiss();
                    betModalClicked = true;
                } catch (Exception ignored) {
                }
            }
            limit++;
        } while ((!betModalClicked || !locationModalClicked) && limit <= 3);
    }
}
