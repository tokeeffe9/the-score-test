package app.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class Scores extends Menu{

    @AndroidFindBy(accessibility = "Today")
    protected WebElement todayAccessibility;

    public Scores(AppiumDriver driver) {
        super(driver);
    }

    public void waitForScorePage(){
        waitUntilVisible(todayAccessibility);
    }


}
