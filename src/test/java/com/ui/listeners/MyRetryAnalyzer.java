package com.ui.listeners;

import com.constants.Env;
import com.utility.JSONUtility;
import com.utility.PropertiesUtil;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer {

    /*old code : accessing with Properties file
    private static final int MAX_NUMBER_OF_ATTEMPTS = Integer.parseInt(PropertiesUtil.readProperties(Env.QA,"MAX_NUMBER_OF_ATTEMPTS"));*/

    /*accessing with JSON file*/
    private static final int MAX_NUMBER_OF_ATTEMPTS = JSONUtility.readJSON(Env.QA).getMAX_NUMBER_OF_ATTEMPTS();
    private static int current_attempt = 1;


    @Override
    public boolean retry(ITestResult result) {
        if(current_attempt <= MAX_NUMBER_OF_ATTEMPTS){
            current_attempt++;
            return true;
        }

        return false;
    }


}
