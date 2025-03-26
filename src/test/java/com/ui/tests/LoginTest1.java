package com.ui.tests;

import com.utility.BrowserUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest1 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver wd = new ChromeDriver();

        BrowserUtility browserUtility = new BrowserUtility(wd);
        browserUtility.goToWebsite("http://www.automationpractice.pl/index.php?");
        browserUtility.maximizeWindow();

        By signInLinkLocator = By.xpath("//a[@title='Log in to your customer account']");//This is the locator i am gonna use
        browserUtility.clickOn(signInLinkLocator);

        By emailTextBoxLocator = By.xpath("//input[@id='email']");
        browserUtility.enterText(emailTextBoxLocator,"harsshal@gmail.com");

        By passwordTextBoxLocator = By.xpath("//input[@id='passwd']");
        browserUtility.enterText(passwordTextBoxLocator,"harsshal");

        By signInBtnLocator = By.xpath("//button[@id='SubmitLogin']");
        browserUtility.clickOn(signInBtnLocator);
        /****** Bad Practice ******/

        //hardcoding of the data
        //lot of elements at the same place
        //Duplicate lines of code
        //testdata is attached to the testscript
        //wd is not the correct way of creating the name of a variable
        //No Exception Handling
        //Synchronization is not there, we are not suppose to wd.findElement because it is not synchronized, we have to use explicit wait or fluent wait.
        //Assertions
        //Add Abstraction ==> You are not suppose to use the selenium methods directly in your testscripts so u need to create Custom Methods/ Wrapper Methods and use them in test scripts.

        //Challenges Faced in an Automation Framework
        /*** The framework was already present and there was hardcoding, duplicacy in code, naming conventions was not done correctly,
         * all the data is attached to the testscripts, exception Handling was not done correctly, there was an issue in synchronization, Assertion was kind of missing in my testscripts and
         abstraction too was missing. */
    }
}
