package com.ui.tests;

import static com.constants.Size.*;
import com.ui.pages.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductCheckoutTest extends TestBase{

    private static final String SEARCH_TERM="Printed Summer Dress";
    private SearchResultPage searchResultPage;

    @BeforeMethod(description = "User logs into the application and searches for the product")
    public void setup(){
    searchResultPage = homePage.goToLoginPage().doLoginWith("harsshal@gmail.com","harsshal").searchForAProduct(SEARCH_TERM);

    }

    @Test(description="Verify if the logged in user is able to buy a dress.", groups = {"e2e","sanity","smoke"})
    public void checkoutTest(){
        String result = searchResultPage.clickOnTheProductAtIndex(1).changeSize(L).addProductToCart()
                .proceedToCheckout().goToConfirmAddressPage().goToShippingPage().goToPaymentPage().makePaymentByWire();
        Assert.assertTrue(result.contains("complete"));
    }
}
