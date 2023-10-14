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
 public void tearDown() {
  // driver.quit();
   LoggerUtil.info("Driver tear down");
 }
}
