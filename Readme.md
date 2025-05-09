# 🚀 Automation Test Project with GitHub Actions

<p align="center">
 <a href="https://github.com/charshal12/AutomationProject-GithubActions/blob/master/projectlogo/infrastructure.png" target="_blank">
  <img src="https://raw.githubusercontent.com/charshal12/AutomationProject-GithubActions/master/projectlogo/infrastructure.png" alt="Automation Project Logo" width="200" />
</a>

</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-17%2B-blue?logo=java" alt="Java" />
  <img src="https://img.shields.io/badge/Selenium-WebDriver-green?logo=selenium" alt="Selenium" />
  <img src="https://img.shields.io/badge/TestNG-Framework-yellow?logo=testng" alt="TestNG" />
  <img src="https://img.shields.io/badge/Maven-Build%20Tool-orange?logo=apache-maven" alt="Maven" />
  <img src="https://img.shields.io/github/downloads/charshal12/AutomationProject-GithubActions/total" alt="GitHub Actions" />
</p>

---

## 📖 Table of Contents

- [Project Overview](#-project-overview)
- [Motivation & Learning](#-motivation--learning)
- [Key Features](#-key-features)
- [Technology Stack](#-technology-stack)
- [Project Structure](#-project-structure)
- [How to Run](#-how-to-run)
- [Reports & Visuals](#-reports--visuals)
- [Architecture & Design](#-architecture--design)
- [Key Dependencies & Plugins](#-key-dependencies--plugins)
- [What I Learned](#-what-i-learned)
- [Contact](#-contact)

---

## 📋 Project Overview

**AutomationProject-GithubActions** is a scalable, hybrid UI automation framework for e-commerce sites.  
It leverages **Java**, **Selenium WebDriver**, **TestNG**, and integrates seamlessly with **GitHub Actions** for CI/CD.

### Why this project?

- Demonstrates advanced test automation design and real-world CI/CD integration.
- Built with maintainability, extensibility, and production readiness in mind.

---

## 🎯 Motivation & Learning

This project helped me:

- Deepen my expertise in automation frameworks and DevOps.
- Apply design patterns like **Page Object Model** and **Singleton** in a practical way.
- Implement TDD principles and professional software engineering practices.
- Fully automate test pipelines using **GitHub Actions**.

---

## ✨ Key Features

- 🚦 **Hybrid Framework**: Combines data-driven & keyword-driven approaches
- 🧩 **Page Object Model**: Clean code separation
- 🗝️ **Singleton Pattern**: Efficient resource management
- 🌐 **Cross-Browser Testing**: Easily switch browsers
- ⚡ **Parallel Execution**: Fast test runs with TestNG
- 📊 **Rich Reporting**: HTML reports, logs, screenshots on failure
- 🤖 **CI/CD Integration**: Automated GitHub Actions workflows
- 🔒 **Modular Design**: Add new pages, tests, and utilities with ease

---

## 🛠️ Technology Stack

| Technology         | Version        | Description                         |
|--------------------|----------------|-------------------------------------|
| Java               | 17+            | Programming Language                |
| Selenium WebDriver | Latest         | Browser Automation                  |
| TestNG             | Latest         | Testing Framework                   |
| Maven              | 3.8+           | Build & Dependency Management       |
| Log4j              | 2.x            | Logging Framework                   |
| GitHub Actions     | -              | CI/CD Pipeline                      |

---

## 📁 Project Structure

AutomationProject-GithubActions/
├── config/                     # Config files
├── logs/                       # Log files
├── screenshots/                # Failure screenshots
├── src/
│   ├── main/
│   │   ├── java/               # Source code
│   │   └── resources/          # Resources
│   └── test/
│       ├── java/
│       │   └── com/
│       │       ├── constants/
│       │       ├── ui/
│       │       │   ├── dataProviders/
│       │       │   ├── listeners/
│       │       │   ├── pages/
│       │       │   ├── pojos/
│       │       │   └── tests/
│       │       └── utility/
│       └── resources/
├── testData/
├── test-output/
├── pom.xml
├── testng.xml
└── .github/
    └── workflows/



## 🏃 How to Run

### 🔧 Prerequisites

- Java JDK 8 or higher (recommended: Java 17+)
- Maven 3.8.x or higher
- Git

### 🚀 Installation & Execution

```bash
git clone https://github.com/charshal12/AutomationProject-GithubActions.git
cd AutomationProject-GithubActions
mvn clean install

▶️ Run All Tests
mvn test

🧪 Run a Specific Suite
mvn test -DsuiteXmlFile=testng.xml

📊 Reports & Visuals

✅ Test Execution Screenshot
![Sample Test Execution](https://raw.githubusercontent.com/charshal12/AutomationProject-GithubActions/master/screenshots/+loginCSVTest%20-23-04-2025_21-47-59.png)

📄 HTML Report
[![Sample HTML Report](https://raw.githubusercontent.com/charshal12/AutomationProject-GithubActions/master/screenshots/report-screenshot.png)](https://github.com/charshal12/AutomationProject-GithubActions/blob/master/report.html)

🏗️ Architecture & Design

🧱 Design Patterns
Page Object Model: Encapsulates page structure and actions
Singleton: Manages WebDriver instance and configurations

🏛️ Framework Architecture
Base: Setup, base test classes
Pages: UI elements and actions
Utils: Helpers, data providers
Tests: Implementation of test scenarios

⚡ Parallel Execution
Configured via TestNG to speed up feedback.

🗝️ Key Dependencies & Plugins

📦 Core Dependencies
| Dependency       | Purpose            |
| ---------------- | ------------------ |
| selenium-java    | Browser automation |
| testng           | Testing framework  |
| webdrivermanager | Driver management  |
| log4j-core       | Logging            |

🔧 Maven Plugins
| Plugin                | Purpose               |
| --------------------- | --------------------- |
| maven-surefire-plugin | Executes TestNG tests |
| maven-compiler-plugin | Java version config   |

Example Snippet
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


🌱 What I Learned

Building maintainable, scalable hybrid automation frameworks
Integrating CI/CD with GitHub Actions
Speeding up tests with parallel execution
Enhancing test visibility through rich reports and debugging tools

📞 Contact

Project Maintainer: charshal12
For any inquiries, feel free to open an issue or contact via GitHub.

This project showcases robust test architecture, DevOps practices, and professional automation design.
Would you like this version saved as a downloadable `.md` file or automatically committed to your GitHub repo?

