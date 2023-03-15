package app.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.DriverFactory;

import java.net.MalformedURLException;

public class StartingSteps {

    @Before
    public void setUp(Scenario scenario) throws MalformedURLException {

        new DriverFactory().getDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        new DriverFactory().destroyDriver();
    }
}