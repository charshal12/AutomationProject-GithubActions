package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class LoginPage extends BrowserUtility {
    private static final By EMAIL_TEXT_BOX_LOCATOR = By.xpath("//input[@id='email']");
    private static final By PASSWORD_TEXT_BOX_LOCATOR = By.xpath("//input[@id='passwd']");
    private static final By SUBMIT_BTN_LOCATOR = By.xpath("//button[@id='SubmitLogin']");
    private static final By ERROR_MESSAGE_LOCATOR = By.xpath("//div[@class=\"alert alert-danger\"]/ol/li");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MyAccountPage doLoginWith(String emailAddress, String password) {
        enterText(EMAIL_TEXT_BOX_LOCATOR,emailAddress);
        enterText(PASSWORD_TEXT_BOX_LOCATOR,password);
        clickOn(SUBMIT_BTN_LOCATOR);

        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        return myAccountPage;
    }

    public LoginPage doLoginWithInvalidCredentials(String emailAddress, String password) {
        enterText(EMAIL_TEXT_BOX_LOCATOR, emailAddress);
        enterText(PASSWORD_TEXT_BOX_LOCATOR, password);
        clickOn(SUBMIT_BTN_LOCATOR);

        LoginPage loginPage = new LoginPage(getDriver());
        return loginPage;
    }

    public String getErrorMessage(){
        return getVisibleText(ERROR_MESSAGE_LOCATOR);
    }
}
