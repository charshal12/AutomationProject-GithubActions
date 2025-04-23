package com.ui.tests;

import static org.testng.Assert.*;
import com.ui.pojos.User;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({com.ui.listeners.TestListener.class})
public class LoginTest extends TestBase{
    Logger logger = LoggerUtility.getLogger(this.getClass());

/*
    @Test(description="Verifies with the valid user is able to login in website", groups = {"e2e","sanity"},
            dataProviderClass = com.ui.dataProviders.LoginDataProviders.class, dataProvider = "LoginTestDataProvider")
    public void loginJSONTest(User user) {
            */
/*String userName = homePage.goToLoginPage()
             .doLoginWith("harsshal@gmail.com","harsshal")
             .getUserName(); ===> directly putting everyting in assertEquals
             *//*


        assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(),
                "Harshal c");
    }
*/

    @Test(description="Verifies with the valid user is able to login in website", groups = {"e2e","sanity"},
            dataProviderClass = com.ui.dataProviders.LoginDataProviders.class, dataProvider = "LoginTestCSVDataProvider")
    public void loginCSVTest(User user) {
            assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(),
                    "Harshal c");
    }


/*
    @Test(description="Verifies with the valid user is able to login in website", groups = {"e2e","sanity"},
            dataProviderClass = com.ui.dataProviders.LoginDataProviders.class, dataProvider = "LoginTestExcelDataProvider",
            retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
    public void loginExcelTest(User user) {
        assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(),
                "Harshal c");
    }

 */
}
