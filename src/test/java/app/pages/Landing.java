package app.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class Landing extends BasePage {

    @AndroidFindBy(id = "com.fivemobile.thescore:id/btn_primary")
    protected WebElement getStartedID;

    @AndroidFindBy(id = "com.fivemobile.thescore:id/txt_sign_in")
    protected WebElement landingLogInID;

    @AndroidFindBy(id = "com.fivemobile.thescore:id/email_input_edittext")
    protected WebElement emailTextboxID;

    @AndroidFindBy(id = "com.fivemobile.thescore:id/password_input_edittext")
    protected WebElement passwordTextboxID;

    @AndroidFindBy(id = "com.fivemobile.thescore:id/login_button")
    protected WebElement logInButtonID;

    public Landing(final AppiumDriver driver) {
        super(driver);
    }

    public void tapLandingLogIn() {

        waitUntilVisible(landingLogInID);
        tapSpecificPartOfTextElement(landingLogInID, "LOG IN");
    }

    public void enterLoginInformation(String email, String password) {

        waitUntilVisible(emailTextboxID).sendKeys(email);
        passwordTextboxID.sendKeys(password);
    }

    public void tapLogInButton() {
        logInButtonID.click();
    }

}
