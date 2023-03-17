package app.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class Favorites extends Menu {

    @AndroidFindBy(id = "com.fivemobile.thescore:id/label")
    protected List<WebElement> favoritesLabels;

    public Favorites(final AppiumDriver driver) {
        super(driver);
    }

    public void tapOnSpecificFavorite(String favoriteName) {

        waitUntilElementsAreVisible(favoritesLabels);
        waitUntilClickable(favoritesLabels.get(0));
        favoritesLabels.stream().filter
                        (label -> label.getText().equalsIgnoreCase(favoriteName))
                .findFirst().ifPresent(WebElement::click);
    }

    public List<String> getAllFavorites(){

        waitUntilElementsAreVisible(favoritesLabels);
        return favoritesLabels.stream().map(WebElement::getText).collect(Collectors.toList());
    }

}
