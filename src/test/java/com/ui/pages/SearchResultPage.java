package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class SearchResultPage extends BrowserUtility {
private static final By PRODUCT_LISTING_TITLE_LOCATOR = By.xpath("//div[@id='center_column']//span[@class='lighter']");
private static final By ALL_PRODUCT_LISTS_NAME = By.xpath("//h5[@itemprop='name']/a");
private static final By INVALID_PRODUCT_ERROR = By.xpath("//div[@id='center_column']//p");
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public String getSearchResultTitle(){
        return getVisibleText(PRODUCT_LISTING_TITLE_LOCATOR);
    }

    public boolean isSearchTermPresentInProductList(String searchTerm){
        List<String> keywords = Arrays.asList(searchTerm.toLowerCase().split(" "));
        List<String> productNamesList = getAllVisibleText(ALL_PRODUCT_LISTS_NAME);

        boolean result = productNamesList.stream()
                .anyMatch(name -> (keywords.stream().anyMatch(name.toLowerCase()::contains)));
        return result;
    }

    public String SearchResultPageForInvalidProduct(String productName){
        waitForElement(INVALID_PRODUCT_ERROR);
        String result = getVisibleText(INVALID_PRODUCT_ERROR);
        return result;
    }


}
