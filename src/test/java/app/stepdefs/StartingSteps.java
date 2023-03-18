package app.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.extern.slf4j.Slf4j;
import utils.ConfigReader;
import utils.DriverFactory;

import java.net.MalformedURLException;

@Slf4j
public class StartingSteps {

    @Before
    public void setUp() throws MalformedURLException {

        log.info("Driver setup");
        ConfigReader.loadConfig();
        new DriverFactory().getDriver();
    }

    @After
    public void tearDown() {

        new DriverFactory().destroyDriver();
        log.info("Driver destroyed");
    }
}
