package app.stepdefs;

import app.pages.Favorites;
import io.cucumber.java.en.And;
import utils.DriverFactory;

public class FavoriteSteps extends DriverFactory {


    private final Favorites favorites;

    public FavoriteSteps() {
        favorites = new Favorites(driver);
    }


    @And("^I tap (.*) on favorites page$")
    public void iTapFavoriteOptionOnFavoritesPage(String favoriteName) {
        favorites.tapOnSpecificFavorite(favoriteName);
    }
}
