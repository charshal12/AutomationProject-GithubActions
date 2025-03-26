package com.ui.pages;
import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtility;

import com.utility.JSONUtility;
import org.openqa.selenium.By;

import java.util.Properties;


//Page Object Design Pattern
public final class HomePage extends BrowserUtility {

    //Locator
    private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[@title='Log in to your customer account']");

    //Constructor of Child class
    public HomePage(Browser browserName) {
        super(browserName);
        goToWebsite(JSONUtility.readJSON(QA).getUrl());
    }

    //Page Functions ---> In Page Object Model, void returntype cannot be present.
    public LoginPage goToLoginPage(){
        clickOn(SIGN_IN_LINK_LOCATOR);

        LoginPage loginPage = new LoginPage(getDriver());
        return loginPage;
    }
}
