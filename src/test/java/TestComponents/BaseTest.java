package TestComponents;

import Config.GlobalConsts;

import Driver.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import Driver.DriverFactory;
import java.util.concurrent.TimeUnit;

public class BaseTest{

 public  WebDriver driver;

 Properties browser;

 public BaseTest()
 {

  browser = new Properties();
  File propFile = new File(GlobalConsts.PROPERTIES_PATH);

  try {
   FileInputStream file = new FileInputStream(propFile);
   browser.load(file);
  }catch(Throwable e) {
   e.printStackTrace();
  }
 }

 public WebDriver getDriver() {
  return driver;
 }

 public  WebDriver initializeDriver() throws IOException {

  String browserName = System.getProperty("browser")!=null ? System.getProperty("browser"):browser.getProperty("browser");
  String url = browser.getProperty("url");

  if(browserName.contains("chrome")) {

   WebDriverManager.chromedriver().setup();
   ChromeOptions options = new ChromeOptions();

   if(browserName.contains("headless"))
   {
    options.addArguments("headless");
   }
   options.addArguments("--remote-allow-origins=*");

   driver = new ChromeDriver(options);

  }
  else if(browserName.contains("edge"))
  {
   WebDriverManager.edgedriver().setup();
   EdgeOptions options = new EdgeOptions();


   if(browserName.contains("headless"))
   {
    options.addArguments("headless");
   }
   options.addArguments("--remote-allow-origins=*");

   driver = new EdgeDriver(options);

  }
  else if(browserName.contains("firefox"))
  {
   WebDriverManager.firefoxdriver().setup();
   FirefoxOptions options = new FirefoxOptions();
   if(browserName.contains("headless"))
   {
    options.addArguments("headless");
   }
   options.addArguments("--remote-allow-origins=*");

   driver = new FirefoxDriver(options);

  }

  driver.manage().window().maximize();
  driver.manage().deleteAllCookies();
  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(GlobalConsts.PAGE_LOUD_TIME));
  driver.get(url);
  return driver;

 }



 @BeforeMethod(alwaysRun = true)
 public void setUp() throws IOException
 {
  initializeDriver();
 }
 @AfterMethod(alwaysRun = true)
 public void tearDown()
 {
   driver.quit();
 }

}
