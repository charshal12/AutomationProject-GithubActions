package com.ui.runner;

import org.testng.TestNG;

import java.util.Collections;

public class TestRunner {
    public static void main(String[] args) {
        TestNG testng = new TestNG();
        // Path to your testng.xml file, relative to jar working directory or absolute path
        testng.setTestSuites(Collections.singletonList("D:\\Study\\Interview\\workspace\\Mission1\\AutomationProject\\testNG_execution.xml"));
        testng.run();
    }
}
