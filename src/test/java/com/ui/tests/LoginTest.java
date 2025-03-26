package com.ui.tests;

import static com.constants.Browser.*;
import com.ui.pages.HomePage;
import static org.testng.Assert.*;
import com.ui.pojos.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest {
    HomePage homePage;

    @BeforeMethod(description="Load the homepage of the website")
    public void setUp(){        //launching the browser
        homePage = new HomePage(CHROME);
    }


    @Test(description="Verifies with the valid user is able to login in website", groups = {"e2e","sanity"},
            dataProviderClass = com.ui.dataProviders.LoginDataProviders.class, dataProvider = "LoginTestDataProvider")
    public void loginJSONTest(User user) {
            /*String userName = homePage.goToLoginPage()
             .doLoginWith("harsshal@gmail.com","harsshal")
             .getUserName(); ===> directly putting everyting in assertEquals
             */

        assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(),
                "Harshal c");
    }


    @Test(description="Verifies with the valid user is able to login in website", groups = {"e2e","sanity"},
            dataProviderClass = com.ui.dataProviders.LoginDataProviders.class, dataProvider = "LoginTestCSVDataProvider")
    public void loginCSVTest(User user) {
            assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(),
                    "Harshal c");
    }


    @Test(description="Verifies with the valid user is able to login in website", groups = {"e2e","sanity"},
            dataProviderClass = com.ui.dataProviders.LoginDataProviders.class, dataProvider = "LoginTestExcelDataProvider",
            retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
    public void loginExcelTest(User user) {
        assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(),
                "Harshal c");
    }
}
