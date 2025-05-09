# Automation Test Project with GitHub Actions

[![CI/CD](https://github.com/charshal12/AutomationProject-GithubActions/actions/workflows/main.yml/badge.svg)](https://github.com/charshal12/AutomationProject-GithubActions/actions/workflows/main.yml)

## 📋 Overview

This project is an automated testing framework for e-commerce website UI verification and validation. It implements a hybrid framework approach combining data-driven testing with OOPs concepts and design patterns including Page Object Model and Singleton pattern, following Test-Driven Development (TDD) practices.

## 🛠️ Technology Stack

- **Programming Language:** Java
- **Testing Framework:** TestNG
- **Automation Tool:** Selenium WebDriver
- **Build Tool:** Maven
- **Logging:** Log4j
- **CI/CD:** GitHub Actions
- **Design Pattern:** Page Object Model, Singleton
- **Approach:** Hybrid Framework, TDD

## 📁 Project Structure

```
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
```

## ✨ Features

- **Hybrid Framework:** Combines data-driven and keyword-driven approaches
- **Page Object Model:** Separation of page elements and test logic
- **Singleton Pattern:** Single instance for WebDriver and configuration
- **TDD Approach:** Test cases written before implementation
- **Cross-Browser Testing:** Support for multiple browsers
- **Parallel Test Execution:** Utilizing TestNG parallel capabilities
- **Reporting:** Detailed HTML and logging reports
- **CI/CD Integration:** Automated test execution via GitHub Actions
- **Screenshot Capture:** On test failure

## 🚀 Getting Started

### Prerequisites

- Java JDK 8 or higher
- Maven 3.8.x or higher
- Git

### Installation

1. Clone the repository:
   ```
   git clone https://github.com/charshal12/AutomationProject-GithubActions.git
   ```

2. Navigate to the project directory:
   ```
   cd AutomationProject-GithubActions
   ```

3. Install dependencies:
   ```
   mvn clean install
   ```

### Running Tests

Execute all tests:
```
mvn test
```

Execute specific test suite:
```
mvn test -Dsuite=testng.xml
```

## 📊 Reports

After test execution, reports can be found at:
- TestNG HTML Report: `test-output/index.html`
- Log files: `logs/`

## 🔄 CI/CD Pipeline

This project uses GitHub Actions for continuous integration and testing. The workflow is defined in `.github/workflows/main.yml`. Tests are automatically executed on:

- Push to main branch
- Pull requests to main branch

## 📝 Dependencies

Major dependencies include:

```xml
<!-- From pom.xml -->
<dependencies>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
    </dependency>
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
    </dependency>
    <dependency>
        <groupId>io.github.bonigarcia</groupId>
        <artifactId>webdrivermanager</artifactId>
    </dependency>
    <dependency>
        <groupId>org.apache.logging.log4j</groupId>
        <artifactId>log4j-core</artifactId>
    </dependency>
    <!-- Other dependencies as specified in pom.xml -->
</dependencies>
```

## 📚 Documentation

- **Design Patterns Used:**
  - **Page Object Model:** Each page is represented as a class with elements and actions
  - **Singleton Pattern:** Used for WebDriver and configuration management

- **Framework Architecture:**
  - **Base Package:** Contains base test class and WebDriver initialization
  - **Pages Package:** Page classes with elements and actions
  - **Utils Package:** Helper classes, data providers, and utilities
  - **Tests Package:** Test classes implementing test scenarios

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 📞 Contact

Project Maintainer: [Charshal](https://github.com/charshal12)

---

*This README was generated for the AutomationProject-GithubActions repository.*
