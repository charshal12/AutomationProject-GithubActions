package com.utility;

import com.constants.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Creating the wrapper methods to use methods in entire script.
 * Abstraction is created*/
public class BrowserUtility {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    //Heap Memory: non static variables created in the class is instance variabe
    //Made Threadlocal variable to make it threadsafe
    Logger logger = LoggerUtility.getLogger(this.getClass());
    //getter
    public WebDriver getDriver() {
        return driver.get();
    }

    public BrowserUtility(WebDriver driver) {
        super();
        this.driver.set(driver);
    }

    //Constructer for getting a browsername
    public BrowserUtility(String browserName){
        logger.info("Launching Browser for " +browserName);
        if(browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver());
        }
        else{
            logger.error("Launching Browser for " +browserName);
            System.err.println("Invalid Browser name,.....please enter chrome or firefox!!!!");
        }
    }

    /*public BrowserUtility(Browser browserName){
        logger.info("Launching Browser for " +browserName);
        if(browserName == Browser.CHROME){
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());
        } else if (browserName == Browser.FIREFOX) {
            WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver());
        } else if (browserName == Browser.EDGE) {
            WebDriverManager.edgedriver().setup();
            driver.set(new EdgeDriver());
        }
        else{
            System.err.println("Invalid Browser name,.....please enter chrome or firefox!!!!");
        }
    }*/

    public BrowserUtility(Browser browserName, boolean isHeadless){
        logger.info("Launching Browser for " + browserName);
        if(browserName == Browser.CHROME) {
            WebDriverManager.chromedriver().setup();
            if(isHeadless) {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless"); //launch the browser in headless options
                chromeOptions.addArguments("--window-size=1920,1080");
                driver.set(new ChromeDriver(chromeOptions));
            }else {

                driver.set(new ChromeDriver());
            }

        } else if (browserName == Browser.FIREFOX) {
            WebDriverManager.firefoxdriver().setup();
            if(isHeadless){
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless=new"); //launch the browser in headless options
                firefoxOptions.addArguments("--window-size=1920,1080");
                firefoxOptions.addArguments("disable-gpu");
                driver.set(new FirefoxDriver(firefoxOptions));
            }else{

                driver.set(new FirefoxDriver());
            }

        } else if (browserName == Browser.EDGE) {
            if(isHeadless){
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--headless=new");
                edgeOptions.addArguments("disable-gpu");
                driver.set(new EdgeDriver(edgeOptions));
            }
            else {
                WebDriverManager.edgedriver().setup();
                driver.set(new EdgeDriver());
            }
        }
        else{
            System.err.println("Invalid Browser name,.....please enter chrome or firefox!!!!");
        }
    }

    public void goToWebsite(String url){
        logger.info("Visiting the website :" + url);
        driver.get().get(url);
    }

    public void maximizeWindow(){
        logger.info("Maximizing the browser window.");
        driver.get().manage().window().maximize();
    }

    public void clickOn(By locator){
        logger.info("Finding Element with the locator " + locator);
        WebElement element = driver.get().findElement(locator); // Finding The actual element.
        logger.info("Element Found and now performing click");
        element.click();
    }

    public void enterText(By locator, String text){
        logger.info("Finding Element with the locator " + locator);
        WebElement element = driver.get().findElement(locator);
        logger.info("Element Found and now Enter the text " + text);
        element.sendKeys(text);
    }

    public String getVisibleText(By locator){
        logger.info("Finding Element with the locator " + locator);
        WebElement element = driver.get().findElement(locator);
        logger.info("Element Found and now returning the value "+element.getText());
       return element.getText();
    }

    public String takeScreenShot(String name){
        TakesScreenshot screenshot = (TakesScreenshot) driver.get();
        File screenShotData =screenshot.getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-YYYY_HH-mm-ss");
        String timeStamp = format.format(date);
        String path = ".//screenshots//+"+name+" -"+timeStamp+".png";
        File screenShotFile = new File(path);
        try {
            FileUtils.copyFile(screenShotData,screenShotFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return path;
    }
}
