package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = "app.stepdefs",
        features = "src/test/resources",
        monochrome = true
)

public class RunCucumberTest {
}