package com.utility;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojos.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CSVReaderUtility {
    public static Iterator<User> readCSVFile(String fileName) {
        FileReader fileReader = null; //never declare a variable in try-catch
        CSVReader csvReader;
        String[] line =null;
        User userData;
        List<User> userList = new ArrayList<User>();

        File csvFile = new File(System.getProperty("user.dir") + "/testData/" +fileName);
        try {
            fileReader = new FileReader(csvFile);
            csvReader = new CSVReader(fileReader);
            csvReader.readNext(); //Names of Column or RowNo1
            /* data = csvReader.readNext();            //TestData --> Starts from RowNo2*/


            while((line = csvReader.readNext()) != null){
                userData = new User(line[0], line[1]);
                userList.add(userData);
            }

          /*  for (User user: userList){
                System.out.println(user);
            }*/
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        }
        return userList.iterator();
    }

}
