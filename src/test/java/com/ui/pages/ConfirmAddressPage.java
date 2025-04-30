package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmAddressPage extends BrowserUtility {
    private static final By PROCEED_TO_CHECKOUT_BTN_CONFIRM_ADDRESS_LOCATOR = By.xpath("//button[@name='processAddress']");
    public ConfirmAddressPage(WebDriver driver) {
        super(driver);
    }

    public ShippingPage goToShippingPage(){
        clickOn(PROCEED_TO_CHECKOUT_BTN_CONFIRM_ADDRESS_LOCATOR);
        return new ShippingPage(getDriver());
    }
}
