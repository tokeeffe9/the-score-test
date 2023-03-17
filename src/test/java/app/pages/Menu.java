package app.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class Menu extends BasePage {

    @AndroidFindBy(accessibility = "Favorites")
    protected WebElement favoritesAccessibility;

    public Menu(final AppiumDriver driver) {
        super(driver);
    }

    public void tapFavorites() {

        waitUntilVisible(favoritesAccessibility);
        waitUntilClickable(favoritesAccessibility).click();
    }

}
