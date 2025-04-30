package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BrowserUtility {
    private static final By PAYMENT_BY_WIRE_BTN_LOCATOR = By.xpath("//a[@title='Pay by bank wire']");
    private static final By CONFIRM_PAYMENT_BTN_LOCATOR = By.xpath("//p[@class='cart_navigation clearfix']//button");
    private static final By ALERT_SUCCESS_MESSAGE = By.xpath("//p[@class='alert alert-success']");
    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public String makePaymentByWire(){
        clickOn(PAYMENT_BY_WIRE_BTN_LOCATOR);
        clickOn(CONFIRM_PAYMENT_BTN_LOCATOR);
        return getVisibleText(ALERT_SUCCESS_MESSAGE);
    }

}
