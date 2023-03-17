package app.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {

    private final AppiumDriver driver;

    protected BasePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    protected AppiumDriver getDriver() {
        return driver;
    }

    private WebDriverWait driverWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.getIntProperty("driver.wait.timeout")));
    }

    protected WebElement waitUntilVisible(WebElement element) {
        return driverWait().until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement waitUntilClickable(WebElement element) {
        return driverWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    protected List<WebElement> waitUntilElementsAreVisible(List<WebElement> elements) {
        return driverWait().until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    protected void tapSpecificPartOfTextElement(WebElement element, String substringToClick) {

        String fullText = element.getText();

        //Get the start and end index of the string you need
        int startIndex = fullText.indexOf(substringToClick);
        int endIndex = startIndex + substringToClick.length();

        //Gets the co-ordinates
        int startX = element.getLocation().getX() + element.getSize().getWidth() * startIndex / fullText.length();
        int endX = element.getLocation().getX() + element.getSize().getWidth() * endIndex / fullText.length();
        int centerY = element.getLocation().getY() + element.getSize().getHeight() / 2;

        //Gets the center of those co-ordinates based on the X and taps
        TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
        touchAction.tap(PointOption.point(startX + (endX - startX) / 2, centerY)).release().perform();
    }

    protected void swipeIntoViewHorizontal(String recycleContainer, String elementText) {
        driver.findElement(MobileBy
                .AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"" + recycleContainer + "\")).setAsHorizontalList().scrollIntoView("
                        + "new UiSelector().text(\"" + elementText + "\"));"));
    }

}
