package com.ui.pages;

import com.ui.pojos.AddressPOJO;
import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

public class AddressPage extends BrowserUtility {
    private static final By COMPANY_TEXTBOX_LOCATOR = By.id("company");
    private static final By ADDRESS1_TEXTBOX_LOCATOR= By.id("address1");
    private static final By ADDRESS2_TEXTBOX_LOCATOR= By.id("address2");
    private static final By CITY_TEXTBOX_LOCATOR= By.id("city");
    private static final By POSTCODE_TEXTBOX_LOCATOR= By.id("postcode");
    private static final By HOME_PHONE_TEXTBOX_LOCATOR= By.id("phone");
    private static final By MOBILE_PHONE_TEXTBOX_LOCATOR= By.id("phone_mobile");
    private static final By ADDITIONAL_INFO_TEXTAREA_LOCATOR= By.id("other");
    private static final By ADDRESS_TITLE_TEXTBOX_LOCATOR= By.id("alias");
    private static final By SAVE_ADDRESS_BTN_LOCATOR= By.id("submitAddress");
    private static final By STATE_DROPDOWN_LOCATOR = By.id("id_state");
    private static final By ADDRESS_HEADING = By.tagName("h3");


    public AddressPage(WebDriver driver) {
        super(driver);
    }

    public String saveAddress(AddressPOJO addressPOJO){
        enterText(COMPANY_TEXTBOX_LOCATOR, addressPOJO.getCompany());
        enterText(ADDRESS1_TEXTBOX_LOCATOR, addressPOJO.getAddress1());
        enterText(ADDRESS2_TEXTBOX_LOCATOR, addressPOJO.getAddress2());
        enterText(CITY_TEXTBOX_LOCATOR, addressPOJO.getCity());
        enterText(POSTCODE_TEXTBOX_LOCATOR, addressPOJO.getPostCode());
        enterText(HOME_PHONE_TEXTBOX_LOCATOR, addressPOJO.getHomePhoneNumber());
        enterText(MOBILE_PHONE_TEXTBOX_LOCATOR, addressPOJO.getMobileNumber());
        clearText(ADDITIONAL_INFO_TEXTAREA_LOCATOR);
        enterText(ADDITIONAL_INFO_TEXTAREA_LOCATOR, addressPOJO.getOtherInformation());
        enterText(ADDRESS_TITLE_TEXTBOX_LOCATOR,addressPOJO.getAddressAlias());
        selectFromDropdown(STATE_DROPDOWN_LOCATOR,addressPOJO.getState());
        clickOn(SAVE_ADDRESS_BTN_LOCATOR);
        //waitForElement(ADDRESS_HEADING);
        String newAddress = getVisibleText(ADDRESS_HEADING);
        return newAddress;
    }
}
