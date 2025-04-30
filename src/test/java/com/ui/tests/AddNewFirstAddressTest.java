package com.ui.tests;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojos.AddressPOJO;
import com.utility.FakerAddressUtility;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewFirstAddressTest extends TestBase {

    private MyAccountPage myAccountPage;
    private AddressPOJO addressPOJO;

    @BeforeMethod(description = "Valid first time user logs into the application")
    public void setup(){
        myAccountPage = homePage.goToLoginPage().doLoginWith("rr@gmail.com","rr12345");
        addressPOJO = FakerAddressUtility.getFakeAddress();
    }

    @Test
    public void addNewAddress(){
       String newAddress = myAccountPage.goToAddAddressPage().saveAddress(addressPOJO);
        Assert.assertEquals(newAddress, "MY ADDRESS"+addressPOJO.getAddressAlias().toUpperCase());

    }
}
