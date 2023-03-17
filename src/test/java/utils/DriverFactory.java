package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.MutableCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    private static final String LOCAL_APK_PATH = System.getProperty("user.home") + "/Desktop/" + System.getProperty("app.file.name");

    public static final String DEVICE_NAME = System.getProperty("device.name");

    public static final String ANDROID_VERSION = System.getProperty("android.version");

    public static final String APP_FILE_NAME = System.getProperty("app.file.name");

    protected static AppiumDriver driver;

    public AppiumDriver getDriver() throws MalformedURLException {

        Boolean local = ConfigReader.getBooleanProperty("local");

        MutableCapabilities androidCapabilities = new MutableCapabilities();

        androidCapabilities.setCapability("platformName", "Android");
        androidCapabilities.setCapability("appium:platformVersion", ANDROID_VERSION);
        androidCapabilities.setCapability("appium:deviceName", DEVICE_NAME);
        androidCapabilities.setCapability("appium:deviceOrientation", "portrait");
        androidCapabilities.setCapability("appium:automationName", "UiAutomator2");
        androidCapabilities.setCapability("autoDismissAlerts", true);

        if (local) {
            androidCapabilities.setCapability("appium:app", LOCAL_APK_PATH);

            driver = new AndroidDriver(new URL(ConfigReader.getProperty("local.appium.server")), androidCapabilities);
        } else {
            androidCapabilities.setCapability("appium:app", "storage:filename=" + APP_FILE_NAME);

            //Setting up specific capabilities when using SauceLabs
            MutableCapabilities sauceLabsOptions = new MutableCapabilities();

            sauceLabsOptions.setCapability("build", "appium-build-score-test");
            sauceLabsOptions.setCapability("name", "Score-test");
            sauceLabsOptions.setCapability("username", System.getenv("SAUCE_USERNAME"));
            sauceLabsOptions.setCapability("accessKey", System.getenv("SAUCE_ACCESS_KEY"));
            androidCapabilities.setCapability("sauce:options", sauceLabsOptions);
            driver = new AndroidDriver(new URL("https://ondemand.us-west-1.saucelabs.com/wd/hub"), androidCapabilities);
        }
        return driver;
    }

    public void destroyDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}