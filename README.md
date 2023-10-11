
   ![](https://i.imgur.com/Nz8roEU.gif)


# Hybrid-SeleniumEasy-Test-Automation-Framework By Mateusz Konatkowski

Welcome to my Hybrid-SeleniumEasy-Test-Automation-Framework, tailor-made for testing the SeleniumEasy website. This framework is a robust solution crafted to enhance the efficiency and effectiveness of web application testing on <a href="https://demo.seleniumeasy.com/" rel="nofollow">SeleniumEasy</a>

### contents
**[Key Features](#%EF%B8%8F-key-features)**

**[System Requirements](#%EF%B8%8F-system-requirements)**

**[Languages and Frameworks](#%EF%B8%8F-languages-and-frameworks)**

**[Test architecture](#%EF%B8%8F-test-architecture)**

**[Run Locally](#%EF%B8%8F-run-locally)**

**[Running Tests](#%EF%B8%8F-running-tests)**
 
 # ✳️ Key Features
 

#### 🟨 Modular Structure:
The framework follows a modular design, allowing you to organize your test cases efficiently.

#### 🟨 Configuration Management:
Easily configure test environments, browsers, and other settings using external properties files.

#### 🟨 Selenium WebDriver Integration:
The framework seamlessly integrates with Selenium WebDriver for easy web automation.

#### 🟨 TestNG Integration:
Harness the full capabilities of TestNG for test execution, parallelization, and reporting.

#### 🟨 Logging and Reporting:
Detailed logs and comprehensive test reports help you identify issues quickly.

#### 🟨 Page Object Model (POM):
Implement the POM design pattern for cleaner and more maintainable page object classes.

#### 🟨 Data-Driven Testing:
Execute tests with various excel test data sets to maximize test coverage.

#### 🟨 Continuous Integration:
Seamlessly integrate your tests with popular Github Actions for automated testing.

#### 🟨 Extensibility:
Extend the framework with custom utilities, listeners, and more to suit  your specific needs.


 # ✳️ System Requirements

#### - Install JDK(Preferably 17)

#### - Install Chrome Browser, Edge Browser, Firefox Browser

#### - Install Maven

#### - Run well on the Windows platform

#### - Use IntelliJ IDEA is the best choice

# ✳️ Languages and Frameworks

🟨 [Java 17](https://docs.oracle.com/en/java/javase/17/)

🟨 [Selenium 4](https://www.selenium.dev/documentation/)

🟨 [TestNG](https://testng.org/doc/documentation-main.html) 

🟨 [WebDriverManager 5](https://bonigarcia.dev/webdrivermanager/)

🟨 [Maven](https://maven.apache.org/guides/index.html)

🟨 [Log4j2](https://logging.apache.org/log4j/2.x/)

🟨 [Apache POI](https://poi.apache.org) 

🟨 [ExtentReports 5](https://www.extentreports.com/docs/versions/4/java/index.html)

🟨 [GitHub Actions](https://docs.github.com/en/actions)

# ✳️ Test architecture
🟨 [POM(PageObjectModel)](#-pompageobjectmodel)

🟨 [Reports](#-reports)

🟨 [ScreenShots](#-screenShots)

🟨 [Config](#-config)

🟨 [Driver](#-driver) 

🟨 [Listeners](#-listeners) 

🟨 [PageFactory](#pagefactory) 

🟨 [Util](#-util)

🟨 [Resources](#-resources)

🟨 [Runner](#-runner) 

🟨 [TestComponents](#-testcomponents)

🟨 [TestData](#-TestData)


### 🟦 POM(PageObjectModel)

**The Page Object Model (POM) is a design pattern commonly used in test automation to enhance the maintainability and reusability of automated tests. It provides a structured way to represent the web pages of an application as objects in the test code.**

####  Benefits of POM:

#### 🟨 Modularity: 

POM divides the application into manageable, modular components, making it easier to create and maintain tests.

#### 🟨 Reduced Code Duplication:

 Reusable Page Objects reduce code duplication across test cases, leading to more efficient test development.

#### 🟨 Enhanced Collaboration:

 Testers and developers can collaborate effectively as they work with well-defined Page Objects.

#### 🟨 Scalability:

 POM scales well with growing test suites, ensuring maintainability as the project evolves.

#### 🟨 Improved Debugging:

 Isolating issues to specific Page Objects simplifies the debugging process.

**In summary, the Page Object Model (POM) is a design pattern that promotes a structured and maintainable approach to web test automation. By representing web pages as Page Objects, it enhances code readability, reusability, and maintainability while reducing code duplication.**

### 🟦 Reports

**The "[Reports](Reports)" folder is a dedicated directory within a test automation project that serves as a repository for various types of test reports. It plays a crucial role in documenting and tracking the results of automated tests. Within this folder, you'll  find two important types of files:**

#### 1. [logs.log](Reports/logs.log)

Log files, denoted with the ".log" extension, are text-based records of events, activities, and messages generated during the execution of automated tests. These logs provide valuable insights into the test execution process.

#### 2. [report.html](Reports/report.html)

The "report.html" file is a comprehensive and visually appealing test report generated by the ExtentReports framework. It serves as a vital component in test automation for documenting and presenting the results of automated test executions. Key features of the "report.html" file include:

#### 🟨 Test Execution Summary

**The report begins with a high-level summary of the test execution, providing essential details such as the total number of test cases `executed`, the number of `passed` and `failed` tests, and the overall pass percentage. This summary offers a quick overview of test suite health.**

#### 🟨 Detailed Test Case Results

**For each individual test case, the "report.html" file provides a detailed breakdown of results, including:**

- Test Case Description: A clear and concise description of the test case.

- Test Status: The status of the test case, indicating whether it `passed` or `failed`.

- Start and End Times: Timestamps indicating when the test case execution began and ended.

- Logs and Steps: A step-by-step account of the test case's actions and expected outcomes.

- Screenshots: If configured, the report includes screenshots captured during test execution, providing visual evidence of test behavior.

### 🟦 ScreenShots

**Folder "[ScreenShots](ScreenShots)" contains screenshots from various types of tests, including tests that have `passed` , been `skipped`, or `failed`. These screenshots are stored in a single shared folder, rather than separately for each type of test.**

### 🟦 Config

**The "[Config](src/main/java/Config)" folder contains the "GlobalConst.java" file and the "GlobalData.properties" file, which hold global settings and constants used in the application or project. Here is a brief description of the contents of this folder:**

#### 1. [GlobalConst.java](src/main/java/Config/GlobalConsts.java): 

The "GlobalConst.java" file is a Java class that contains global constants and variables used throughout the project or application. These constants  include items such as `file paths`, `waits time`, `browser config`, `IRetryAnalyzer count`.Storing these constants in one place makes it easier to manage and update them as needed.

#### 2. [GlobalData.properties](src/main/java/Config/GlobalData.properties):

 The "GlobalData.properties" file is a properties file that contains global configurations and data in a key-value format. It can include configuration parameters such as `environment settings`, `author name`, `tested page URL`. It serves as an external configuration file that can be easily edited without the need to modify the application's source code. This allows for changes in configuration to be made without the need for recompilation.

**The "[Config](src/main/java/Config)" folder is used to centralize global settings and data, making it easier to manage and ensuring consistency throughout the project.**


### 🟦 Driver

**The "[Driver](src/main/java/Driver)" folder contains [BrowserFactory](src/main/java/Driver/BrowserFactory.java) class is responsible for initializing and configuring web browsers for testing purposes. Here's a brief description of its main functions:**

#### 🟨 initializeDriver()

 This method initializes and configures a web browser based on the provided settings. It returns a WebDriver instance that will be used to perform operations in the browser.

```java
String browserName = System.getProperty("browser")!=null ? System.getProperty("browser"): `ConfigReaderUtil.getProperty("browser");
```

 This line of code reads the browser value (`browser`) from the system parameter (`if provided as a runtime argument`) or from the configuration file `ConfigReaderUtil.getProperty("browser")`.

#### 🟨 Initialization of Browsers:

`For Chrome:` The WebDriverManager tool is used to manage the Chrome driver. A ChromeDriver instance is created with specified options, such as headless mode, window maximization, etc.

`For Edge:` The WebDriverManager tool is used to manage the Edge driver. An EdgeDriver instance is created with appropriate options.

`For Firefox:` The WebDriverManager tool is used to manage the Firefox driver. A FirefoxDriver instance is created with specified options.

`Browser Options Configuration:`
For each browser, options such as headless mode, window maximization, disabling extensions, etc., can be configured based on test requirements.
```java

driver.manage().deleteAllCookies(): //Deletes all browser cookies to ensure a clean session.

driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(GlobalConsts.PAGE_LOUD_TIME)): //Sets the maximum wait time for page loading.

driver.get(url): //Opens the SeleniumEasy web page in the browser.
```

**This class allows for flexible management of different browsers and configuration options to tailor tests to project needs. It is useful to avoid code duplication and simplifies browser management in Selenium tests.**


### 🟦 Listeners


**The [Listener](src/main/java/Listeners/Listener.java) class, located in the "[Listeners](src/main/java/Listeners)" folder, is an implementation of TestNG Listeners responsible for monitoring and reporting on the execution of test cases. Here's a summary of its main functions:**


#### 🟨 Setup and Configuration:

The class initializes and configures essential tools and utilities for test monitoring, including `Extent Reports` for test reporting, `logger` for logging, and utilities for taking `screenshots`.

#### 🟨 Test Execution Start (onTestStart):

 When a test case starts, it creates an Extent Test instance associated with the `test method's name`, assigns an `author`, and `logs` the test start. If configured, it takes a `screenshot`.

#### 🟨 Test Execution Success (onTestSuccess):

 In case of a test success, it `logs` the test as `"PASS"` and captures a `screenshot` if configured.

#### 🟨 Test Execution Failure (onTestFailure):

 In the event of a test failure, it `logs` the test as `"FAIL"` records the failure details, and captures a `screenshot` if configured.

#### 🟨 Test Execution Skipped (onTestSkipped):

 When a test is skipped, it `logs` the test as `"SKIP"` and captures a `screenshot` if configured.

#### 🟨 Test Suite Start (onStart) and Finish (onFinish):

These methods provide information about the `start` and `finish` of the entire `test suite`, and they also `flush the extent reports`.

#### 🟨 Logging and Reporting:

The class makes use of `logger utilities` for detailed `logging` and `Extent Reports` for generating test reports.

**This class plays a vital role in monitoring and reporting on test executions, making it easier to identify test status and any issues during testing. It allows for the efficient capture of screenshots and logging of test results, contributing to better test management and reporting.**



###  🟦PageFactory

**The "[PageFactory](src/main/java/PageFactory)" directory serves as the foundation for organizing and structuring web page interactions in a Selenium-based test automation project. It provides a unified `BasePage` class containing `common methods` and elements shared across various page classes within the project. These page classes are further categorized into the `BasicPageFactory`, `IntermediatePageFactory`, and `AdvancedPageFactory` subdirectories, each housing page classes specifically tailored to their respective testing levels: `Basic`, `Intermediate`, and `Advanced`.**

#### 1. [BasePage.java](src/main/java/PageFactory/BasePage.java):
 The central class containing common methods for interacting with web elements, waiting for elements, and navigating between web pages. All page classes within the project extend this base class to ensure consistent and standardized interactions.

#### 2. [BasicPageFactory](src/main/java/PageFactory/BasicPageFactory):
 A directory specifically designed for page classes related to basic-level tests. These page classes inherit from BasePage and provide methods for handling elements on web pages relevant to basic test scenarios.

#### 3. [IntermediatePageFactory]():
 A directory dedicated to page classes related to intermediate-level tests. Similar to the BasicPageFactory, these page classes inherit from BasePage but cater to more complex test scenarios at the intermediate level.

#### 4. [AdvancedPageFactory]():
 This directory focuses on page classes related to advanced-level tests, offering extensive and specialized methods for handling web elements and navigating through web pages associated with advanced test cases.

 **The "[PageFactory](src/main/java/PageFactory)" directory, with its `BasePage` class and subdirectories, promotes code reusability, maintainability, and consistency across the test automation project. By centralizing `common methods` within `BasePage`, it ensures that interaction with web elements is uniform across all tests. The subdirectories segregate page classes based on test complexity, streamlining the structure and making it easier to locate relevant page classes for each test level.**

### 🟦 Util

**The "[Util](src/main/java/Util)" directory is a crucial component of a Selenium-based test automation project, housing utility classes that offer a range of functionalities to simplify the testing process, enhance reporting, and manage various aspects of test execution.**


#### 1. [ConfigReaderUtil](src/main/java/Util/ConfigReaderUtil.java):
The  purpose of the `ConfigReaderUtil` class is to read and provide access to configuration data stored in property files. By centralizing configuration management in one utility class, you can easily access and utilize environment-specific settings throughout your test scripts.
```java
// Access a specific configuration property
String browser = ConfigReaderUtil.getProperty("browser");

// Use the retrieved value in your test script
System.out.println("Selected browser: " + browser);

````
By using the `ConfigReaderUtil` class, you ensure a clean and organized way to manage configuration data, enhancing the maintainability and flexibility of your test automation framework

#### 2. [DateUtil](src/main/java/Util/DateUtil.java):
The  purpose of the `DateUtil` class is to provide a convenient way to retrieve the current date in a specific format. This utility is valuable for creating timestamps or unique identifiers in your test automation scenarios.
```java
// Get the current date in the specified format
String currentDateTime = DateUtil.getCurrentDate();

// Use the retrieved date and time in your test script
System.out.println("Current Date and Time: " + currentDateTime);

```
By using the `DateUtil class`, you can easily generate timestamps or unique identifiers to track and manage various aspects of your test executions, making your test automation framework more versatile and informative.

#### 3. [ExcelDataUtil](src/main/java/Util/ExcelDataUtil.java):
The purpose of the `ExcelDataUtil` class is to provide a method for fetching test data from Excel files. It allows you to use Excel sheets as a data source for your test cases. This can be especially useful for parameterized testing.

```java
// Obtain the test data for the current test method
Object[][] testData = ExcelDataUtil.getData(this.getClass().getMethod("testMethod"), "path/to/your/data.xlsx");

// Use the retrieved data in your test script
for (Object[] dataRow : testData) {
    String parameter1 = (String) dataRow[0];
    int parameter2 = Integer.parseInt((String) dataRow[1]);
    // Process the data as needed in your test method
}

```
By using the `ExcelDataUtil` class, you can separate test data from your test scripts, making your tests more maintainable and adaptable. This class allows you to conveniently store and access data in Excel files, which is a common practice in test automation.

#### 4. [ExtentReportUtil](src/main/java/Util/ExtentReportUtil.java):
The purpose of the `ExtentReportUtil` class is to provide a method for creating an ExtentReports object and configuring its properties. This class is used for generating HTML reports that document the results of automated tests.
```java
// Get the ExtentReports object for reporting
ExtentReports extent = ExtentReportUtil.getReportObject();

// Create test cases and log test steps using the extent object
ExtentTest test = extent.createTest("Your Test Name");
test.log(Status.INFO, "Test step details..."); // Add test step details

// Execute your test logic and record results

// After completing the test, flush the report to save it
extent.flush();

```
By using the `ExtentReportUtil` class, you can easily set up and configure ExtentReports for your test automation project, which allows you to generate organized and visually appealing HTML reports to document your test results. This is useful for test documentation and sharing results with stakeholders.
#### 5. [IRetryAnalyzerUtil](src/main/java/Util/IRetryAnalyzerUtil.java):
The  purpose of the `IRetryAnalyzerUtil` class is to define a mechanism for retrying failed test methods based on certain conditions. It allows you to specify the maximum number of retry attempts and whether retrying is enabled or disabled.
```java
@Test(retryAnalyzer = IRetryAnalyzerUtil.class)
public void yourTestMethod() {
    // Test logic...
}
```
By using the `IRetryAnalyzerUtil` class and applying the @Test annotation with the retryAnalyzer attribute, you can control the behavior of test method retries in your TestNG test suite. This is useful for handling intermittent test failures and ensuring the robustness of your test automation framework.


#### 6. [LoggerUtil](src/main/java/Util/LoggerUtil.java):
The  purpose of the `LoggerUtil` class is to centralize and simplify the logging process for your test automation framework. By using this class, you can log information, errors, warnings, and debug messages for different parts of your codebase, making it easier to troubleshoot and monitor test execution.
```java
LoggerUtil.info("This is an information message.");
LoggerUtil.error("This is an error message.");
LoggerUtil.warn("This is a warning message.");
LoggerUtil.debug("This is a debug message.");

```
By calling the appropriate method, you can `log` messages with different log levels. The log messages will be captured by the logger and can be configured to be saved in log files or displayed in the console, depending on your Log4j 2 configuration.

#### 7. [ScreenShotUtil](src/main/java/Util/ScreenShotUtil.java):
The purpose of the `ScreenShotUtil` class is to capture screenshots of the web application at specific points during test execution. Screenshots are useful for debugging, error analysis, and generating visual reports.
```java
String screenshotPath = ScreenShotUtil.captureScreenshot(driver, "TestStepName", "TestClass");

```
By calling this method at relevant points in your test cases, you can capture screenshots for different test steps or actions.

**The "[Util](src/main/java/Util)" directory's utility classes provide various functionalities that streamline common testing activities, reducing code duplication and promoting code reusability. These utilities enhance the overall efficiency, maintainability, and reliability of your test automation framework. Each utility class serves a specific purpose and can be easily integrated into  test scripts. This structure allows for better organization and keeps the core test scripts focused on test scenarios, while utilities handle various supportive tasks. The result is a clean, efficient, and maintainable test automation project.**


### 🟦 Resources

**The "[resources](src/main/resources)" folder in a Java project typically serves as a location for storing non-Java files that are essential for the application's configuration, data, or resources. In the context of the Log4j 2 logging framework, the "resources" folder is used to house the configuration file, such as "[log4j2.xml](src/main/resources/log4j2.xml). The "log4j2.xml" file is a configuration file for the Log4j 2 logging framework. It is used to define how log messages are generated, formatted, and where they are output. Here are the key components and purposes of "log4j2.xml":**

#### 🟨 Log Level:
 You can set the log level for different loggers, determining which log messages are captured (e.g., INFO, DEBUG, ERROR).

#### 🟨 Output Destinations:
 You can specify where log messages are sent, such as the console, log files, or other custom appenders.

#### 🟨 Log Message Format:
 You can define the format of log messages, including timestamp, log level, and more.

#### 🟨 Customization:
 You can tailor logging for specific parts of your application, enabling detailed logging for debugging and less verbose logging for production.

**In summary, the "[log4j2.xml](src/main/resources/log4j2.xml)" configuration file in the "[resources](src/main/resources)" folder is a critical component for managing and configuring the logging behavior of your Java application. It provides a structured and flexible way to capture and output log messages, helping you monitor and troubleshoot your application.**

### 🟦 Runner

**The "[runner](src/test/java/Runner)" folder contains multiple XML configuration files that are used for test execution in your automation framework. These XML files are designed to specify the test suites, tests, test classes, and other testing parameters. Below are descriptions of the XML files found in the "runner" folder:**

#### 1. [AdvancedTests.xml](src/test/java/Runner/AdvancedTests.xml):

This XML file is intended for configuring and executing advanced tests. It defines a test suite with a specified name and includes a listener class. Within the suite, one or more tests can be defined, and each test can include one or more packages or classes that contain the actual test methods. The test suite, as well as individual tests, can be customized with various parameters such as verbosity, thread count, and parallel execution.

#### 2. [BasicTests.xml](src/test/java/Runner/BasicTests.xml):
Similar to "AdvancedTests.xml," this XML file is meant for running basic tests. It follows a structure that allows you to define a test suite with a name and a listener class. Inside the suite, you can specify individual tests, packages, or classes containing your basic test cases. You can further configure test execution settings.

#### 3. [IntermediateTests.xml](src/test/java/Runner/IntermediateTests.xml):

Just like the previous XML files, "IntermediateTests.xml" is used to configure and run intermediate-level tests. It defines a test suite, includes a listener class, and allows you to specify tests, packages, or classes for test execution. The XML provides flexibility in setting parameters for test execution.
#### 4. [RegressionTests.xml](src/test/java/Runner/RegressionTests.xml):

This XML file is designed for running regression tests. It follows the same structural pattern as the other XML files, enabling you to define a test suite for regression testing, add a listener class for event handling, and configure various test execution settings.

#### 5. [SmokeTests.xml](src/test/java/Runner/SmokeTests.xml):

"SmokeTests.xml" is used for configuring and executing smoke tests. The structure is the same as the other XML files, providing a means to define a test suite, include a listener class, and specify tests, packages, or classes for smoke testing. The XML allows you to set various parameters for the execution of smoke tests.

**In summary, the "[runner](src/test/java/Runner)" folder contains a collection of XML configuration files, each tailored for a specific type of testing (e.g., basic, advanced, intermediate, regression, smoke). These XML files provide the necessary information to execute test suites, which in turn run various test classes and cases with specific configurations.**


### 🟦 TestComponents

**The "[TestComponents](src/test/java/TestComponents)" folder contains BasePage class and subfolders, such as "`AdvancedTests,`" "`BasicTests,`" and "`IntermediateTests,`" which organize the test classes used for various levels of testing within your test automation framework. Below is an overview of the "TestComponents" folder structure and its purpose:**

#### 1. [BasePage.java](src/test/java/TestComponents/BaseTest.java)
The "BaseTest" class acts as the base class for your test classes. It provides common setup and teardown operations to ensure that each test class starts with a consistent environment and cleans up resources after test execution.

#### 2. [AdvancedTests]():
The "AdvancedTests" folder is dedicated to storing test classes specifically designed for advanced testing scenarios. Advanced tests often involve more complex functionalities and might include a variety of test cases, possibly covering edge cases and intricate scenarios.

#### 3. [BasicTests](src/test/java/TestComponents/BasicTests):

The "BasicTests" folder is meant for housing test classes that are focused on fundamental testing scenarios. These tests are typically straightforward and serve as foundational tests for your application or system.

#### 4. [IntermediateTests]():

The "IntermediateTests" folder is where you store test classes for intermediate-level testing. These tests are more complex than basic tests but not as advanced as those in the "AdvancedTests" folder. Intermediate tests may cover a wide range of test cases, including typical usage scenarios.

**Each of these folders, "[AdvancedTests]()," "[BasicTests](src/test/java/TestComponents/BasicTests)," and "[IntermediateTests]()," will contain various test classes that are relevant to the respective level of testing. The organization into separate folders simplifies test management, test execution, and test reporting for different testing phases within your automation framework.**

### 🟦 TestData

**The "[TestData](src/test/java/TestData)" folder contains data files required for running the test cases within the test automation framework. It's a crucial part of the framework for data-driven testing, allowing you to use different sets of data to validate the behavior of your application under various conditions. Below are descriptions of the Excel files found in the "TestData" folder**

#### 1. [AdvancedTestsData]():

The "AdvancedTestsData" folder contains Excel files that store data required for running advanced-level tests. These data files include test input, expected results, or other relevant data specific to advanced test cases.

#### 2. [BasicData](src/test/java/TestData/BasicTestsData):

The "BasicData" folder holds Excel files that contain data for basic test scenarios. This data may include inputs, expected outcomes, or any other data essential for testing the core functionalities of the application.

#### 3. [IntermediateData]():

The "IntermediateData" folder stores Excel files with data for intermediate-level tests. These data files provide input values, expected results, or other relevant data specific to test scenarios of moderate complexity.

**By structuring your test data in this way, your automated test suite gains flexibility, reusability, and improved organization when dealing with data-driven tests of different complexity levels.**

### 🟦 pom.xml

**The "[pom.xml](pom.xml)" file is an essential configuration file in a Maven-based Java project. It serves as the blueprint for the project's organization, dependencies, and build instructions. Below is a comprehensive explanation of its key sections and elements:**

#### 🟨Project Metadata:

`<groupId>`, `<artifactId>`, and `<version>`: These elements define the core identity of the project.

`<groupId>` specifies the project's group or organization.

`<artifactId>` defines the project's unique name.

`<version>` indicates the project's version number. Together, these details create a unique identifier for the project.

#### 🟨 Project Properties:

`<properties>`: This section allows the definition of project-specific properties and configurations, such as the source and target Java versions and the character encoding used in the project.

#### 🟨 Project Dependencies:

`<dependencies>`: This section lists the external libraries and dependencies required for the project. Each `<dependency`> element specifies a particular library, including its `<groupId>`, `<artifactId>`, and `<version>`. 

#### 🟨 Maven Profiles:

`<profiles>`: This section defines different profiles or build configurations for the project. Profiles allow you to customize the build process for specific scenarios.

`Regression`, `Smoke`, and other profiles: Each profile is associated with a specific type of test suite, like "[Regression](src/test/java/Runner/RegressionTests.xml)" or "[Smoke](src/test/java/Runner/SmokeTests.xml)".Within each profile, the maven-surefire-plugin is configured to execute tests based on a corresponding TestNG XML file.

**In summary, the "[pom.xml](pom.xml)" file is the cornerstone of a Maven project. It manages project metadata, dependencies, properties, and build profiles. The project's dependencies are crucial libraries like Selenium, TestNG, and Extent Reports, while profiles allow for different test configurations. Overall, this file plays a pivotal role in automating Selenium tests effectively and consistently.**

# ✳️ Run Locally

Clone the project

```bash
  git clone https://github.com/MateuszKonatkowski/Hybrid-SeleniumEasy-Test-Automation-Framework.git
```

Go to the project directory

```bash
  cd Hybrid-SeleniumEasy-Test-Automation-Framework
```

Start the tests

```bash
  mvn test clean
```




 # ✳️ Running Tests

To run Regression tests, run the following command

```bash
  mvn test -PRegression
```
To run Smoke tests, run the following command

```bash
  mvn test -PSmoke
```
To run  tests on Edge browser, run the following command

```bash
  mvn test -Dbrowser=edge
```
To run Smoke tests on Chrome browser with Headless mode, run the following command

```bash
  mvn test -PSmoke -Dbrowser=chromeheadless
```


## Autho

[Mateusz Konatkowski](https://www.linkedin.com/in/mateusz-konatkowski/)







