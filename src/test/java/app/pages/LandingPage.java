package app.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LandingPage extends BasePage {

    @AndroidFindBy(id = "com.fivemobile.thescore:id/btn_primary")
    WebElement getStartedID;

    public LandingPage(final AppiumDriver driver) {
        super(driver);
    }

    public boolean isGetStartedDisplayed(){
        return isDisplayed(getStartedID);
    }
}
