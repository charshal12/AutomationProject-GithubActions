package com.ui.tests;

import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;

import static com.constants.Browser.CHROME;

public class TestBase {
    //All Test classes will have parent as TestBase class

    protected HomePage homePage;
    Logger logger = LoggerUtility.getLogger(this.getClass());

    @BeforeMethod(description="Load the homepage of the website")
    public void setUp(){        //launching the browser
        logger.info("Homepage");
        homePage = new HomePage(CHROME);
    }

    public BrowserUtility getInstance(){
        return homePage;
    }
}
