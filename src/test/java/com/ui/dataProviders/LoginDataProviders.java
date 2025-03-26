package com.ui.dataProviders;

import com.google.gson.Gson;
import com.ui.pojos.TestData;
import com.ui.pojos.User;
import com.utility.CSVReaderUtility;
import com.utility.ExcelReaderUtility;
import org.testng.annotations.DataProvider;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class LoginDataProviders {

    @DataProvider(name="LoginTestDataProvider")
    public Iterator<Object[]> loginDataProvider(){

        //Reading the JSON File with the help of GSON
        Gson gson = new Gson();
        File testDataFile = new File(System.getProperty("user.dir")+"/testData/loginData.json");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(testDataFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        TestData data = gson.fromJson(fileReader, TestData.class); //Converting JSON object to Java Object : deserialization


       //We are trying to retrieve the data from the TestData which we got from JSON
        //becsuse we were having JSON array, we have stored it inside an arraylist and we are attaching it to
        //our dataToReturn arraylist which is of <Object[]> type.
        List<Object[]> dataToReturn = new ArrayList<Object[]>();
        for(User user : data.getData()){
            dataToReturn.add(new Object[] {user}); // whatever the testdata is there in user is getting added to dataToReturn
        }
        return dataToReturn.iterator(); //and we are returning thr iterator
    }


    @DataProvider(name = "LoginTestCSVDataProvider")
    public Iterator<User> loginCSVDataProvider(){
       return CSVReaderUtility.readCSVFile("loginData.csv");
    }


    @DataProvider(name = "LoginTestExcelDataProvider")
    public Iterator<User> loginExcelDataProvider(){
        return ExcelReaderUtility.readExcelFile("loginData.xlsx");
    }

}
