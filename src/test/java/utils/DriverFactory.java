package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.MutableCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    private static final String LOCAL_APK_PATH = System.getProperty("user.home") + "/Desktop/theScore_23.3.0_apkcombo.com.apk";
    private static final String LOCAL_APPIUM_SERVER_URL = "http://127.0.0.1:4723/wd/hub/";

    protected static AppiumDriver driver;

    public AppiumDriver getDriver() throws MalformedURLException {

        Boolean local = Boolean.parseBoolean(ConfigReader.getProperty("local"));

        MutableCapabilities androidCapabilities = new MutableCapabilities();

        androidCapabilities.setCapability("platformName", "Android");
        androidCapabilities.setCapability("appium:deviceOrientation", "portrait");
        androidCapabilities.setCapability("appium:platformVersion", "12.0");

        if (local) {

            androidCapabilities.setCapability("appium:deviceName", "pixel_6");
            androidCapabilities.setCapability("appium:app", LOCAL_APK_PATH);

            driver = new AndroidDriver(new URL(LOCAL_APPIUM_SERVER_URL), androidCapabilities);

        } else {
            //Setting up capabilities
            androidCapabilities.setCapability("appium:deviceName", "Android GoogleAPI Emulator");
            androidCapabilities.setCapability("appium:automationName", "UiAutomator2");
            androidCapabilities.setCapability("appium:app", "storage:filename=theScore_23.3.0_apkcombo.com.apk");

            //Setting up sauceLabsOptions
            MutableCapabilities sauceLabsOptions = new MutableCapabilities();

            sauceLabsOptions.setCapability("build", "appium-build-score-test");
            sauceLabsOptions.setCapability("name", "Score-test");
            sauceLabsOptions.setCapability("username", System.getenv("SAUCE_USERNAME"));
            sauceLabsOptions.setCapability("accessKey", System.getenv("SAUCE_ACCESS_KEY"));
            androidCapabilities.setCapability("sauce:options", sauceLabsOptions);

            driver = new AndroidDriver(new URL("https://ondemand.saucelabs.com:443/wd/hub/"), androidCapabilities);
        }

        return driver;
    }

    public void destroyDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}