package com.utility;

import com.constants.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Creating the wrapper methods to use methods in entire script.
 * Abstraction is created*/
public class BrowserUtility {

    private WebDriver driver; //Heap Memory: non static variables created in the class is instance variabe

    //getter
    public WebDriver getDriver() {
        return driver;
    }

    public BrowserUtility(WebDriver driver) {
        this.driver = driver;
    }

    //Constructer for getting a browsername
    public BrowserUtility(String browserName){
        if(browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else{
            System.err.println("Invalid Browser name,.....please enter chrome or firefox!!!!");
        }
    }

    public BrowserUtility(Browser browserName){
        if(browserName == Browser.CHROME){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName == Browser.FIREFOX) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName == Browser.EDGE) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else{
            System.err.println("Invalid Browser name,.....please enter chrome or firefox!!!!");
        }
    }
    public void goToWebsite(String url){
        driver.get(url);
    }

    public void maximizeWindow(){
        driver.manage().window().maximize();
    }

    public void clickOn(By locator){
        WebElement element = driver.findElement(locator); // Finding The actual element.
        element.click();
    }

    public void enterText(By locator, String text){
        WebElement element = driver.findElement(locator);
        element.sendKeys(text);
    }

    public String getVisibleText(By locator){
        WebElement element = driver.findElement(locator);
       return element.getText();
    }
}
