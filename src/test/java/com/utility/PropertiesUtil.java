package com.utility;

import com.constants.Env;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
    //read properties file

    public static String readProperties(Env env, String propertyName) {
        System.out.println(System.getProperty("user.dir"));
        File propFile = new File(System.getProperty("user.dir")+"//config//" + env + ".properties");
        Properties properties = new Properties();

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(propFile);
            properties.load(fileReader);
        } catch (FileNotFoundException e) {
                                    e.printStackTrace();
        } catch (IOException e) {
                                    e.printStackTrace();
        }
        String value = properties.getProperty(propertyName.toUpperCase());
        return value;


    }
}
