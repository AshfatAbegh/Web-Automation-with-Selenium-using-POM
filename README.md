# Web Automation with Selenium Using POM

A comprehensive Java-based web automation testing framework using Selenium WebDriver and the Page Object Model (POM) design pattern for building robust, maintainable, and scalable test automation solutions.

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Project Structure](#project-structure)
- [Usage](#usage)
- [Page Object Model Pattern](#page-object-model-pattern)
- [Configuration](#configuration)
- [Running Tests](#running-tests)
- [Best Practices](#best-practices)
- [Contributing](#contributing)
- [License](#license)

## 🎯 Overview

This project demonstrates a professional-grade web automation testing framework built with:
- **Selenium WebDriver** for browser automation
- **Page Object Model (POM)** for maintainable test code
- **Java** for implementation
- **TestNG** for test execution
- **Maven** for dependency management
- Designed for scalability and reusability

The framework is ideal for automating web application testing, regression testing, and end-to-end testing scenarios.

## ✨ Features

- ✅ **Page Object Model Architecture** - Separates test logic from UI element interactions
- ✅ **Cross-browser Support** - Chrome, Firefox, Safari, Edge
- ✅ **TestNG Integration** - Powerful test execution and reporting
- ✅ **Maven Build System** - Easy dependency management
- ✅ **Reusable Components** - Base classes and common utilities
- ✅ **Robust Element Handling** - Built-in wait strategies and element locators
- ✅ **Modular Test Structure** - Easy to understand and maintain
- ✅ **Scalable Framework** - Add new test cases and pages effortlessly
- ✅ **Error Handling** - Comprehensive exception handling and logging

## 📦 Prerequisites

Before you begin, ensure you have the following installed:

- **Java Development Kit (JDK)** 11 or higher
- **Maven** 3.6 or higher (for dependency management)
- **Git** (for version control)
- **Browser Drivers**:
  - ChromeDriver (for Chrome)
  - GeckoDriver (for Firefox)
  - Or use WebDriverManager for automatic driver management

## 🚀 Installation

### 1. Clone the Repository

```bash
git clone https://github.com/AshfatAbegh/Web-Automation-with-Selenium-Using-POM.git
cd Web-Automation-with-Selenium-Using-POM
```

### 2. Install Dependencies

If using Maven, run:

```bash
mvn clean install
```

### 3. Configure WebDriver

Update your configuration file or environment variables to specify:
- Browser type
- WebDriver executable path
- Base URL for testing

## 📁 Project Structure

```
Web-Automation-with-Selenium-Using-POM/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── pages/              # Page Object classes
│   │   │   ├── base/               # Base classes and utilities
│   │   │   ├── utils/              # Helper utilities
│   │   │   └── config/             # Configuration management
│   │   └── resources/
│   │       └── config.properties   # Configuration file
│   │
│   └── test/
│       ├── java/
│       │   └── tests/              # TestNG test case classes
│       └── resources/
│           └── testng.xml          # TestNG configuration
│
├── pom.xml                         # Maven configuration
├── README.md                       # This file
└── .gitignore                      # Git ignore rules
```

## 📖 Usage

### Basic Test Example with TestNG

```java
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.DashboardPage;

public class LoginTest {
    private WebDriver driver;
    
    @BeforeMethod
    public void setUp() {
        // Initialize driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    @Test
    public void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        
        loginPage.navigateTo("https://example.com/login");
        loginPage.enterUsername("user@example.com");
        loginPage.enterPassword("password123");
        loginPage.clickLoginButton();
        
        DashboardPage dashboardPage = new DashboardPage(driver);
        assert dashboardPage.isDisplayed() : "Dashboard not displayed";
    }
    
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
```

## 🏗️ Page Object Model Pattern

### What is POM?

The Page Object Model is a design pattern that:
- Represents each web page/component as a separate class
- Encapsulates page elements and interactions
- Reduces code duplication
- Improves maintainability and readability
- Makes tests more stable and easier to update

### Example Page Object

```java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    
    // Locators
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.xpath("//button[@type='submit']");
    private By errorMessage = By.className("error");
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    
    // Page Methods
    public void navigateTo(String url) {
        driver.navigate().to(url);
    }
    
    public void enterUsername(String username) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        element.clear();
        element.sendKeys(username);
    }
    
    public void enterPassword(String password) {
        WebElement element = driver.findElement(passwordField);
        element.clear();
        element.sendKeys(password);
    }
    
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
    
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
```

## ⚙️ Configuration

Create a `config.properties` file in `src/main/resources/`:

```properties
# Browser Configuration
browser=chrome
browser.headless=false

# Application URLs
app.base.url=https://example.com

# Timeouts (in seconds)
implicit.wait=10
explicit.wait=15
page.load.timeout=20

# WebDriver paths (if not using WebDriverManager)
webdriver.chrome.driver=/path/to/chromedriver
webdriver.firefox.driver=/path/to/geckodriver
```

### testng.xml Configuration

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="Web Automation Suite" parallel="tests" thread-count="1">
    <test name="Login Tests">
        <classes>
            <class name="tests.LoginTest"/>
            <class name="tests.RegistrationTest"/>
        </classes>
    </test>
</suite>
```

## 🧪 Running Tests

### Run All Tests

```bash
mvn test
```

### Run Specific Test Class

```bash
mvn test -Dtest=LoginTest
```

### Run Specific Test Method

```bash
mvn test -Dtest=LoginTest#testSuccessfulLogin
```

### Run Tests Using TestNG XML

```bash
mvn test -DsuiteXmlFile=testng.xml
```

### Generate Test Report

```bash
mvn test surefire-report:report
```

### Run Tests in Headless Mode

```bash
mvn test -Dbrowser.headless=true
```

## 💡 Best Practices

1. **One Page, One Class** - Each page should have its own Page Object class
2. **Descriptive Method Names** - Use clear, action-oriented method names
3. **Encapsulation** - Keep locators private; expose only page actions
4. **No Assertions in Pages** - Assertions belong in test classes only
5. **Reusable Methods** - Create utility methods for common actions
6. **Wait Strategies** - Use explicit waits instead of Thread.sleep()
7. **Error Handling** - Implement proper exception handling
8. **Logging** - Add meaningful log statements for debugging
9. **Data-Driven Testing** - Parameterize tests with test data
10. **Parallel Execution** - Run tests in parallel for faster execution

## 🔗 Dependencies

Key dependencies in your `pom.xml`:

```xml
<!-- Selenium WebDriver -->
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.x.x</version>
</dependency>

<!-- TestNG -->
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.x.x</version>
</dependency>

<!-- WebDriverManager -->
<dependency>
    <groupId>io.github.bonigarcia</groupId>
    <artifactId>webdrivermanager</artifactId>
    <version>5.x.x</version>
</dependency>

<!-- SLF4J & Log4j for Logging -->
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-api</artifactId>
    <version>2.x.x</version>
</dependency>
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-core</artifactId>
    <version>2.x.x</version>
</dependency>
```

## 📝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is open source and available for educational and professional use.

## 📧 Contact

For questions or suggestions, please reach out to:
- GitHub: [@AshfatAbegh](https://github.com/AshfatAbegh)

## 🔗 Resources

- [Selenium Documentation](https://www.selenium.dev/documentation/)
- [Page Object Model Guide](https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/)
- [TestNG Documentation](https://testng.org/doc/)
- [Java with Selenium](https://www.selenium.dev/documentation/webdriver/getting_started/first_script/)
- [Maven Documentation](https://maven.apache.org/guides/)

---

**Happy Testing! 🎉**
