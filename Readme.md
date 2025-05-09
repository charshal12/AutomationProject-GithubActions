🚀 Automation Test Project with GitHub Actions
<p align="center"> <!-- Custom Logo --> <img src="https://raw.githubusercontent.com/charshal12/AutomationProject-GithubActions/main/docs/logo.png" alt="Automation Project Logo" width="200" /> </p> <p align="center"> <img src="https://img.shields.io/badge/Java-17%2B-blue?logo=java" alt="Java" /> <img src="https://img.shields.io/badge/Selenium-WebDriver-green?logo=selenium" alt="Selenium" /> <img src="https://img.shields.io/badge/TestNG-Framework-yellow?logo=testng" alt="TestNG" /> <img src="https://img.shields.io/badge/Maven-Build%20Tool-orange?logo=apache-maven" alt="Maven" /> <img src="https://img.shields.io/badge/License-MIT-brightgreen" alt="MIT" /> </p>
📖 Table of Contents
Project Overview

Motivation & Learning

Key Features

Technology Stack

Project Structure

How to Run

Reports & Visuals

Architecture & Design

Key Dependencies & Plugins

What I Learned

Contributing

License

Contact

📋 Project Overview
AutomationProject-GithubActions is a scalable, hybrid UI automation framework for e-commerce sites.
It leverages Java, Selenium WebDriver, and TestNG, and is fully integrated with GitHub Actions for seamless CI/CD.

Why is this project special?

Demonstrates advanced test automation design, robust reporting, and real-world CI/CD integration.

Built to be maintainable, extensible, and production-ready.

🎯 Motivation & Learning
I built this project to:

Deepen my expertise in test automation frameworks and DevOps workflows.

Apply design patterns (Page Object Model, Singleton) in a real-world scenario.

Automate the entire testing pipeline using GitHub Actions.

Practice Test-Driven Development (TDD) and professional software engineering practices.

✨ Key Features
🚦 Hybrid Framework: Data-driven + keyword-driven for flexibility

🧩 Page Object Model: Clean code separation for maintainability

🗝️ Singleton Pattern: Efficient resource management

🌐 Cross-Browser Testing: Easily configurable

⚡ Parallel Execution: Fast feedback with TestNG

📊 Rich Reporting: HTML, logs, and screenshots on failure

🤖 CI/CD Integration: Automated test runs on every push/PR

🔒 Extensible & Modular: Easy to add new tests, pages, or utilities

🛠️ Technology Stack
Technology	Version/Details	Description
Java	17+	Programming Language
Selenium WebDriver	Latest	Browser Automation
TestNG	Latest	Testing Framework
Maven	3.8+	Build & Dependency Management
Log4j	2.x	Logging Framework
GitHub Actions	CI/CD Workflow	Continuous Integration/Delivery
📁 Project Structure
text
AutomationProject-GithubActions/
├── config/                     # Configuration files
├── logs/                       # Log files generated during test execution
├── screenshots/                # Screenshot captures for test failures
├── src/
│   ├── main/
│   │   ├── java/               # Main Java source code
│   │   └── resources/          # Main resources
│   └── test/
│       ├── java/
│       │   └── com/
│       │       ├── constants/  # Constants used across the project
│       │       ├── ui/
│       │       │   ├── dataProviders/  # TestNG data providers
│       │       │   ├── listeners/      # TestNG listeners
│       │       │   ├── pages/          # Page Object Model classes
│       │       │   ├── pojos/          # Plain Old Java Objects
│       │       │   └── tests/          # Test case implementations
│       │       └── utility/            # Utility and helper classes
│       └── resources/          # Test resources
├── testData/                   # Test data files
├── test-output/                # TestNG output reports
├── pom.xml                     # Maven project configuration
├── testng.xml                  # TestNG configuration
└── .github/
    └── workflows/              # GitHub Actions workflow definitions
🏃 How to Run
Prerequisites
Java JDK 8 or higher (recommended: Java 17+)

Maven 3.8.x or higher

Git

Installation & Execution
bash
git clone https://github.com/charshal12/AutomationProject-GithubActions.git
cd AutomationProject-GithubActions
mvn clean install
Run all tests:

bash
mvn test
Run a specific TestNG suite:

bash
mvn test -DsuiteXmlFile=testng.xml
📊 Reports & Visuals
Sample Test Execution Screenshot
<p align="center"> <img src="https://raw.githubusercontent.com/charshal12/AutomationProject-GithubActions/main/docs/sample-test-execution.png" alt="Sample Test Execution" width="700" /> </p>
Sample HTML Report Screenshot
<p align="center"> <img src="https://raw.githubusercontent.com/charshal12/AutomationProject-GithubActions/main/docs/sample-html-report.png" alt="Sample HTML Report" width="700" /> </p>
Sample GitHub Actions Workflow Run
<p align="center"> <img src="https://raw.githubusercontent.com/charshal12/AutomationProject-GithubActions/main/docs/github-actions-run.gif" alt="GitHub Actions Workflow Run" width="700" /> </p>
Add your own screenshots and GIFs inside the docs/ folder and update the URLs above.

🏗️ Architecture & Design
Design Patterns:

Page Object Model: Each web page represented as a class encapsulating elements and actions.

Singleton: Ensures a single instance of WebDriver and configuration management.

Framework Architecture:

Base Package: Contains base test classes and WebDriver setup.

Pages Package: Page classes encapsulating UI elements and actions.

Utils Package: Helper classes, data providers, and utilities.

Tests Package: Test classes implementing test scenarios.

Parallel Execution:

TestNG configuration enables parallel test execution for faster feedback cycles.

🗝️ Key Dependencies & Plugins
Core Dependencies
Dependency	Purpose
Selenium Java	Browser automation
TestNG	Test framework
WebDriverManager	Automatic driver management
Log4j	Logging
Essential Maven Plugins
Plugin	Purpose
Maven Surefire Plugin	Runs TestNG test suites
Maven Compiler Plugin	Java version configuration
Example Snippet
xml
<dependencies>
  <dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
  </dependency>
  <dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <scope>test</scope>
  </dependency>
  <dependency>
    <groupId>io.github.bonigarcia</groupId>
    <artifactId>webdrivermanager</artifactId>
  </dependency>
  <dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-core</artifactId>
  </dependency>
</dependencies>

<build>
  <plugins>
    <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-surefire-plugin</artifactId>
    </plugin>
    <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-compiler-plugin</artifactId>
    </plugin>
  </plugins>
</build>
🌱 What I Learned
Advanced Test Automation: Designing hybrid frameworks and applying design patterns for maintainable, scalable code.

CI/CD Integration: Automating testing pipelines with GitHub Actions for continuous feedback.

Parallel Execution: Leveraging TestNG’s parallelism to speed up test runs.

Debugging & Reporting: Implementing screenshot capture and rich HTML reports to facilitate quick issue resolution.

📞 Contact
Project Maintainer: Charshal

This project demonstrates my ability to build scalable, maintainable automation frameworks, integrate CI/CD pipelines, and apply software engineering best practices. Thank you for reviewing my work!
