package app.stepdefs;

import app.pages.Favorites;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import utils.DriverFactory;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FavoriteSteps extends DriverFactory {


    private final Favorites favorites;

    public FavoriteSteps() {
        favorites = new Favorites(driver);
    }

    @And("^I tap (.*) on favorites page$")
    public void iTapFavoriteOptionOnFavoritesPage(String favoriteName) {
        favorites.tapOnSpecificFavorite(favoriteName);
    }

    @Then("I see my favorites on the favorites page")
    public void iSeeMyFavoritesOnTheFavoritesPage(List<String> expectedFavorites) {

        assertEquals(expectedFavorites, favorites.getAllFavorites());
    }
}
