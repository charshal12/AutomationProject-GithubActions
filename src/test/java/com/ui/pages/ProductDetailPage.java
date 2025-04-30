package com.ui.pages;

import com.constants.Size;
import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BrowserUtility {
    private static final By SIZE_DROP_DOWN_LOCATOR = By.id("group_1");
    private static final By ADD_TO_CART_BTN_LOCATOR = By.xpath("//button[@name='Submit']");
    private static final By PROCEED_TO_CHECKOUT_BTN_LOCATOR = By.xpath("//a[@title='Proceed to checkout']");


    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public ProductDetailPage changeSize(Size size){
        selectFromDropdown(SIZE_DROP_DOWN_LOCATOR,size.toString());
        return new ProductDetailPage(getDriver());
    }

    public ProductDetailPage addProductToCart(){
        //waitForElement(ADD_TO_CART_BTN_LOCATOR);
        clickOn(ADD_TO_CART_BTN_LOCATOR);
        return new ProductDetailPage(getDriver());
    }

    public ShoppingCartPage proceedToCheckout(){
        //waitForElement(PROCEED_TO_CHECKOUT_BTN_LOCATOR);
        clickOn(PROCEED_TO_CHECKOUT_BTN_LOCATOR);
        return new ShoppingCartPage(getDriver());
    }
}
