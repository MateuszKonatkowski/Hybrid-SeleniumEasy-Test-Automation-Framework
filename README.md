
# Hybrid-SeleniumEasy-Test-Automation-Framework By Mateusz Konatkowski

Welcome to my Hybrid-SeleniumEasy-Test-Automation-Framework, tailor-made for testing the SeleniumEasy website. This framework is a robust solution crafted to enhance the efficiency and effectiveness of web application testing on <a href="https://demo.seleniumeasy.com/" rel="nofollow">SeleniumEasy</a>
 
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


 ## ✳️ SYSTEM REQUIREMENTS

#### - Install JDK 

#### - Install Chrome Browser, Edge Browser, Firefox Browser

#### - Run well on the Windows platform

#### - Use IntelliJ IDEA is the best choice


 ## ✳️ Running Tests

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







