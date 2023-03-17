package app.pages.modals;

import app.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LocationModal extends BasePage {

    @AndroidFindBy(id = "com.fivemobile.thescore:id/btn_disallow")
    protected WebElement laterID;

    public LocationModal(AppiumDriver driver) {
        super(driver);
    }

    public void tapMaybeLater() {
        waitUntilVisible(laterID).click();
    }

}
