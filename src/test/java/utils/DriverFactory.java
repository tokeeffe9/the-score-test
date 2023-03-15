package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    protected static AppiumDriver driver;
    public AppiumDriver getDriver() throws MalformedURLException {

        MutableCapabilities capabilities = new MutableCapabilities();
        MutableCapabilities sauceOptions = new MutableCapabilities();

        //Setting up capabilities
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:deviceName", "Android GoogleAPI Emulator");
        capabilities.setCapability("appium:deviceOrientation", "portrait");
        capabilities.setCapability("appium:platformVersion", "12.0");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:app", "storage:filename=theScore_23.3.0_apkcombo.com.apk");

        //Setting up sauceOptions
        sauceOptions.setCapability("build", "appium-build-score-test");
        sauceOptions.setCapability("name", "Score-test");
        sauceOptions.setCapability("username", System.getenv("SAUCE_USERNAME"));
        sauceOptions.setCapability("accessKey", System.getenv("SAUCE_ACCESS_KEY"));
        capabilities.setCapability("sauce:options", sauceOptions);

        driver = new AndroidDriver(new URL("https://ondemand.saucelabs.com:443/wd/hub/"), capabilities);

        //Setting the driver so that we can report results
        return driver;
    }

    public void destroyDriver() {
        driver.quit();
    }
}
