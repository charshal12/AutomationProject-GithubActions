package com.ui.pages;
import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Page Object Design Pattern
public final class HomePage extends BrowserUtility {
    protected HomePage homePage;
    Logger logger = LoggerUtility.getLogger(this.getClass());
    //Locator
    private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[@title='Log in to your customer account']");

    //Constructor of Child class
    public HomePage(Browser browserName, boolean isHeadless) {
        super(browserName, isHeadless);
        goToWebsite(JSONUtility.readJSON(QA).getUrl());
    }

    public HomePage(WebDriver driver) {
        super(driver);
        goToWebsite(JSONUtility.readJSON(QA).getUrl());
    }

    //Page Functions ---> In Page Object Model, void returntype cannot be present.
    public LoginPage goToLoginPage() {
        logger.info("Trying to perform the click to go to sign in page");
        clickOn(SIGN_IN_LINK_LOCATOR);
        LoginPage loginPage = new LoginPage(getDriver());
        return loginPage;
    }

}