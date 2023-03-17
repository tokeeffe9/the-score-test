package app.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Favorites extends Menu {

    @AndroidFindBy(id = "com.fivemobile.thescore:id/label")
    protected List<WebElement> favoritesLabels;

    public Favorites(final AppiumDriver driver) {
        super(driver);
    }

    public void tapOnSpecificFavorite(String favoriteName) {

        waitUntilElementsAreVisible(favoritesLabels);
        favoritesLabels.stream().filter
                        (label -> label.getText().equalsIgnoreCase(favoriteName))
                .findFirst().ifPresent(WebElement::click);
    }

}
