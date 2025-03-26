package com.utility;

import com.ui.pojos.User;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReaderUtility {
    public static Iterator<User> readExcelFile(String filename) {

        File xlsFile = new File(System.getProperty("user.dir")+"//testData//"+filename);
        XSSFSheet xssfSheet;
        Iterator<Row> rowIterator;
        List<User> userList = null;
        Row row;
        Cell emailAddressCell;
        Cell passwordCell;
        User user;


        //xlsx file
        XSSFWorkbook xssfWorkbook = null;
        try {
            xssfWorkbook = new XSSFWorkbook(xlsFile);
            xssfSheet = xssfWorkbook.getSheet("LoginTestData");
            rowIterator = xssfSheet.iterator();
            userList = new ArrayList<User>();
            rowIterator.next(); // Skipping the Column Name

            while (rowIterator.hasNext()) {
                row = rowIterator.next();
                emailAddressCell = row.getCell(0);
                passwordCell = row.getCell(1);
                user = new User(emailAddressCell.toString(), passwordCell.toString());
                userList.add(user);
            }
            xssfWorkbook.close();

        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
        return userList.iterator();
    }
}
