package com.ui.tests;

import com.ui.pages.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ com.ui.listeners.TestListener.class})
public class SearchProductTest extends TestBase{

    private MyAccountPage myAccountPage;
    private static final String SEARCH_TERM ="Printed Summer Dress";
    private static final String INVALID_SEARCH_TERM ="Mens Wallet";

        @BeforeMethod(description = "Valid user logs into the application")
        public void setup(){
            myAccountPage = homePage.goToLoginPage().doLoginWith("harsshal@gmail.com","harsshal");
        }

        @Test(description = "Verify if the logged in user is able to search for a product and correct products are displayed",
                groups = {"e2e", "smoke", "sanity"})
        public void verifyProductSearchTest(){
            boolean actualResult = myAccountPage.searchForAProduct(SEARCH_TERM)
                                    .isSearchTermPresentInProductList(SEARCH_TERM);
            Assert.assertEquals(actualResult,true);
        }

    @Test(description = "Verify if the logged in user is getting error on searching for a invalid product",
            groups = {"e2e", "smoke", "sanity"})
        public void verifyInvalidProductTest(){
           String actualResult = myAccountPage.searchForAProduct(INVALID_SEARCH_TERM)
                   .SearchResultPageForInvalidProduct(INVALID_SEARCH_TERM);
           Assert.assertEquals(actualResult,"No results were found for your search \"" +INVALID_SEARCH_TERM + "\"");
        }


}
