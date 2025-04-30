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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Creating the wrapper methods to use methods in entire script.
 * Abstraction is created*/
public class BrowserUtility {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    //Heap Memory: non static variables created in the class is instance variabe
    //Made Threadlocal variable to make it threadsafe
    private Logger logger = LoggerUtility.getLogger(this.getClass());

    private Wait<WebDriver> wait;

    private JavascriptExecutor js;

    //getter
    public WebDriver getDriver() {
        return driver.get();
    }

    public BrowserUtility(WebDriver driver) {
        super();
        this.driver.set(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30L));
        js = (JavascriptExecutor) driver;
    }


    //Constructer for getting a browsername
    public BrowserUtility(String browserName){
        logger.info("Launching Browser for " +browserName);
        if(browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());
            wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
            js = (JavascriptExecutor) driver.get();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver());
            wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
            js = (JavascriptExecutor) driver.get();
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
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
                js = (JavascriptExecutor) driver.get();
            }else {

                driver.set(new ChromeDriver());
               // driver.get().manage().window().maximize();
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
              //  js = (JavascriptExecutor) driver.get();
            }

        } else if (browserName == Browser.FIREFOX) {
            WebDriverManager.firefoxdriver().setup();
            if(isHeadless){
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless=new"); //launch the browser in headless options
                firefoxOptions.addArguments("--window-size=1920,1080");
                firefoxOptions.addArguments("disable-gpu");
                driver.set(new FirefoxDriver(firefoxOptions));
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
                js = (JavascriptExecutor) driver.get();
            }else{

                driver.set(new FirefoxDriver());
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
                js = (JavascriptExecutor) driver.get();
            }

        } else if (browserName == Browser.EDGE) {
            if(isHeadless){
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--headless=new");
                edgeOptions.addArguments("disable-gpu");
                driver.set(new EdgeDriver(edgeOptions));
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
                js = (JavascriptExecutor) driver.get();
            }
            else {
                WebDriverManager.edgedriver().setup();
                driver.set(new EdgeDriver());
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
                js = (JavascriptExecutor) driver.get();
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
//        WebElement element = driver.get().findElement(locator); // Finding The actual element.
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        logger.info("Element Found and now performing click");
        element.click();
    }

    public void clickOn(WebElement element){
        logger.info("Element Found and now performing click");
        element.click();
    }

    public void clickOnCheckBox(By locator){
        logger.info("Finding Element with the locator " + locator);
//        WebElement element = driver.get().findElement(locator); // Finding The actual element.
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        logger.info("Element Found and now performing click");
        element.click();
    }

    public void enterText(By locator, String text){
        logger.info("Finding Element with the locator " + locator);
//        WebElement element = driver.get().findElement(locator);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        logger.info("Element Found and now Enter the text " + text);
        element.sendKeys(text);
    }

    public List<String> getAllVisibleText(By locator){
        logger.info("Finding All Elements with the locator " + locator);
        List<WebElement> elementList = driver.get().findElements(locator);
        logger.info("Element Found and now printing the list in elements: ");

        List<String> visibleTextList = new ArrayList<String>();

        for(WebElement element : elementList) {
            System.out.println(getVisibleText(element));
            visibleTextList.add(getVisibleText(element));
        }
            return visibleTextList;
        }

    public List<WebElement> getAllElements(By locator){
        logger.info("Finding All Elements with the locator " + locator);
        List<WebElement> elementList = driver.get().findElements(locator);
        logger.info("Element Found and now printing the list in elements: ");
        return elementList;
    }

    public void enterSpecialKey(By locator, Keys keyToEnter){
        logger.info("Finding Element with the locator " + locator);
        /*WebElement element = driver.get().findElement(locator);*/
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        logger.info("Element Found and now enter the special key " + keyToEnter);
        element.sendKeys(keyToEnter);
    }

    public String getVisibleText(By locator){
        logger.info("Finding Element with the locator " + locator);
        /*WebElement element = driver.get().findElement(locator);*/
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        logger.info("Element Found and now returning the value "+element.getText());
       return element.getText();
    }

    public String getVisibleText(WebElement element){
        logger.info("Return the visible Text" + element.getText());
        return element.getText();
    }

    public String takeScreenShot(String name){
        TakesScreenshot screenshot = (TakesScreenshot) driver.get();
        File screenShotData =screenshot.getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-YYYY_HH-mm-ss");
        String timeStamp = format.format(date);
        String path ="./screenshots/" + name + " - " + timeStamp + ".png";
        File screenShotFile = new File(path);
        try {
            FileUtils.copyFile(screenShotData,screenShotFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return path;
    }

    public void waitForElement(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void selectFromDropdown(By locator, String optionToSelect){
        logger.info("Finding All Elements with the locator " + locator);

        WebElement element = driver.get().findElement(locator);
        Select select = new Select(element);
        logger.info("Selecting the option  " + optionToSelect);
        select.selectByVisibleText(optionToSelect);

    }

    public void clearText(By locator){
        logger.info("Finding Element with the locator " + locator);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        //WebElement element = driver.get().findElement(locator);
        logger.info("Element Found and Clearing Textbox field");
        element.clear();
    }

    public void scrollToTheEndOFPage(){
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }
}
