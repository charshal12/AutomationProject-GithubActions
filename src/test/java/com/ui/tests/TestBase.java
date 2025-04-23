package com.ui.tests;

import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import static com.constants.Browser.CHROME;

public class TestBase {
    //All Test classes will have parent as TestBase class

    protected HomePage homePage;
    Logger logger = LoggerUtility.getLogger(this.getClass());
    private boolean isLambdaTest = true;
    private boolean isHeadless = true;

    @BeforeMethod(description="Load the homepage of the website")
    public void setUp(ITestResult result){        //launching the browser
        WebDriver lambdaDriver;
        if(isLambdaTest){
            lambdaDriver = LambdaTestUtility.initializeLambdaTestSession("chrome",result.getMethod().getMethodName());
            homePage = new HomePage(lambdaDriver);
        }
        else
        {
            //Running the test on local machine!!!
            logger.info("Homepage");
            homePage = new HomePage(CHROME, isHeadless);
        }
    }

    public BrowserUtility getInstance(){
        return homePage;
    }

    @AfterMethod(description = "Tear down the browser")
    public void tearDown(){
        if(isLambdaTest){
            LambdaTestUtility.quitSession();
        }else {
            homePage.getDriver().quit();
        }
    }
}
