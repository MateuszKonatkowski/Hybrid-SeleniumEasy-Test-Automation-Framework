package TestComponents;



import Driver.BrowserFactory;


import Util.LoggerUtil;
import org.openqa.selenium.WebDriver;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.io.IOException;


public class BaseTest{

 public static  WebDriver driver;



 @BeforeMethod(alwaysRun = true)
 public void setUp() throws IOException
 {
  driver=BrowserFactory.initializeDriver();
  LoggerUtil.info("Initializing driver");
 }


 @AfterMethod(alwaysRun = true)
 public void tearDown()
 {
  if (driver != null) {
   try {
    driver.quit();
   } catch (Exception e) {
    System.err.println("Błąd podczas zamykania WebDriver: " + e.getMessage());
    LoggerUtil.error("Driver doesnt exist");
   }
  }
  LoggerUtil.info("Driver tear down");
 }
}
