package com.utility;

import com.github.javafaker.Faker;
import com.ui.pojos.AddressPOJO;

import java.util.Locale;

public class FakerAddressUtility {

    public static void main(String[] args) {
        getFakeAddress();
    }
    public static AddressPOJO getFakeAddress(){
        Faker faker = new Faker(Locale.US);

        AddressPOJO  addressPOJO =
                new AddressPOJO(faker.company().name(),faker.address().buildingNumber(),faker.address().streetAddress()
                        ,faker.address().city(),
                faker.number().digits(5),faker.phoneNumber().cellPhone(),faker.phoneNumber().cellPhone(),
                "Address ALias","Office Address",faker.address().state());

        return addressPOJO;

    }
}
