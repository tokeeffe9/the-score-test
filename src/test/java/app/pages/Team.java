package app.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class Team extends Menu {

    @AndroidFindBy(id = "com.fivemobile.thescore:id/team_name")
    protected WebElement teamNameID;

    public Team(final AppiumDriver driver) {
        super(driver);
    }

    public String getTeamName() {

        return waitUntilVisible(teamNameID).getText();
    }

}
