package app.stepdefs;

import app.pages.Landing;
import app.pages.modals.CCPA;
import app.pages.modals.LocationModal;
import app.pages.modals.TheScoreBetModal;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import lombok.extern.slf4j.Slf4j;
import utils.ConfigReader;
import utils.DriverFactory;

@Slf4j
public class LoginSteps extends DriverFactory {

    private final Landing landing;
    private final TheScoreBetModal theScoreBetModal;
    private final LocationModal locationModal;
    private final CCPA ccpa;

    public LoginSteps() {

        landing = new Landing(driver);
        theScoreBetModal = new TheScoreBetModal(driver);
        locationModal = new LocationModal(driver);
        ccpa = new CCPA(driver);
    }

    @Given("^I login with (.*) and (.*) details$")
    public void iLoginWithUsernameAndPasswordDetails(String email, String password) {

        landing.tapLandingLogIn();

        //Added this as I noticed saucelabs emulators will get CCPA after the first tap
        Boolean local = ConfigReader.getBooleanProperty("local");
        if (!local){
            ccpa.tapAcceptCCPA();
            landing.tapLandingLogIn();
        }

        landing.enterLoginInformation(email, password);
        landing.tapLogInButton();
    }

    @And("I dismiss all pop-ups")
    public void iDismissAllPopUps() {

        //Had to use a do while loop along with try catch as I found while testing that the pop ups were not consistent.
        //This is not my favorite approach but if I've time I'll come back to it
        //Added logs here as I would look at this to see what happens most often and improve on the issue
        boolean locationModalClicked = false;
        boolean betModalClicked = false;
        int limit = 0;
        do {
            if (!locationModalClicked) {
                try {
                    locationModal.tapMaybeLater();
                    locationModalClicked = true;
                } catch (Exception e) {
                    log.info("Was not able to find location modal. Run:" + limit);
                }
            }
            if (!betModalClicked) {
                try {
                    theScoreBetModal.tapDismiss();
                    betModalClicked = true;
                } catch (Exception e) {
                    log.info("Was not able to find Bet modal. Run:" + limit);
                }
            }
            limit++;
        } while ((!betModalClicked || !locationModalClicked) && limit <= 3);
    }
}
