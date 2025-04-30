package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BrowserUtility {
    private static final By PROCEED_TO_CHECKOUT_BTN_LOCATOR_SHOPPING_CART = By.xpath("//p[@class='cart_navigation clearfix']/a[@title='Proceed to checkout']");

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public ConfirmAddressPage goToConfirmAddressPage(){
//        scrollToTheEndOFPage();
//        waitForElement(PROCEED_TO_CHECKOUT_BTN_LOCATOR_SHOPPING_CART);
        clickOn(PROCEED_TO_CHECKOUT_BTN_LOCATOR_SHOPPING_CART);
        return new ConfirmAddressPage(getDriver());
    }


}
