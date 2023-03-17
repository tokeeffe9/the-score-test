package app.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Team extends Menu {

    @AndroidFindBy(id = "com.fivemobile.thescore:id/team_name")
    protected WebElement teamNameID;

    @AndroidFindBy(accessibility = "Squad")
    protected WebElement squadMenuAccessibility;

    @AndroidFindBy(accessibility = "News")
    protected WebElement newsMenuAccessibility;

    @AndroidFindBy(id = "com.fivemobile.thescore:id/txt_player_name")
    protected List<WebElement> squadPlayerNameID;

    @AndroidFindBy(accessibility = "Navigate up")
    protected WebElement navigateBackAccessibility;


    public Team(final AppiumDriver driver) {
        super(driver);
    }

    public String getTeamName() {

        return waitUntilVisible(teamNameID).getText();
    }

    public void tapSquadOnTab() {

        swipeIntoViewHorizontal("com.fivemobile.thescore:id/tabLayout", "Squad");
        waitUntilVisible(squadMenuAccessibility).click();
    }

    public boolean isPlayerNamePresent(String playerName) {
        waitUntilElementsAreVisible(squadPlayerNameID);
        return squadPlayerNameID.stream().anyMatch
                (player -> player.getText().equalsIgnoreCase(playerName));
    }

    public void tapNavigateBack(){

        waitUntilVisible(newsMenuAccessibility);
        waitUntilClickable(navigateBackAccessibility).click();
    }

}
