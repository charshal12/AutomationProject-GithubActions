package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShippingPage extends BrowserUtility {
    private static final By PROCEED_TO_CHECKOUT_BTN_ON_SHIPPING_PAGE_LOCATOR = By.xpath("//button[@name='processCarrier']");
    private static final By TERMS_AND_SERVICE_CHECKBOX_LOCATOR = By.xpath("//div[@id='uniform-cgv']");
    public ShippingPage(WebDriver driver) {
        super(driver);
    }

    public PaymentPage goToPaymentPage(){
        clickOnCheckBox(TERMS_AND_SERVICE_CHECKBOX_LOCATOR);
        clickOn(PROCEED_TO_CHECKOUT_BTN_ON_SHIPPING_PAGE_LOCATOR);
        return new PaymentPage(getDriver());
    }
}
