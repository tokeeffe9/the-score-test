package app.pages.modals;

import app.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class CCPA extends BasePage {

    @AndroidFindBy(id = "com.fivemobile.thescore:id/accept_button")
    protected WebElement acceptID;


    public CCPA(AppiumDriver driver) {
        super(driver);
    }

    public void tapAcceptCCPA() {

        //Adding this in case the device is not in a CCPA region.
        try {
            waitUntilVisible(acceptID);
            waitUntilClickable(acceptID).click();
        }catch (Exception e){
            System.out.println("No CCPA modal was shown");
        }
    }
}