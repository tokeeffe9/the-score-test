package app.pages.modals;

import app.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class TheScoreBetModal extends BasePage {
    @AndroidFindBy(id = "com.fivemobile.thescore:id/dismiss_modal")
    protected WebElement dismissElement;

    public TheScoreBetModal(AppiumDriver driver) {
        super(driver);
    }

    public void tapDismiss() {
        waitUntilVisible(dismissElement).click();
    }

}
