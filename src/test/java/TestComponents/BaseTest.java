package TestComponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeMethod;
import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


public class BaseTest {
 public WebDriver driver;
 Properties broswer;

 public BaseTest()
 {
  broswer = new Properties();
  File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\GlobalData.properties");

  try {
   FileInputStream fille = new FileInputStream(propFile);
   broswer.load(fille);
  }catch(Throwable e) {
   e.printStackTrace();
  }
 }
 public  WebDriver initializeDriver() throws IOException {

  String browserName = broswer.getProperty("browser");
  String url = broswer.getProperty("url");

  if(browserName.equalsIgnoreCase("chrome")) {
   WebDriverManager.chromedriver().setup();
   driver = new ChromeDriver();

  }
  else if(browserName.equalsIgnoreCase("edge"))
  {
   WebDriverManager.edgedriver().setup();
   driver = new EdgeDriver();

  }
  else if(browserName.equalsIgnoreCase("firefox"))
  {
   WebDriverManager.firefoxdriver().setup();
   driver = new FirefoxDriver();

  }
  else if(browserName.equalsIgnoreCase("safari"))
  {
   WebDriverManager.safaridriver().setup();
   driver = new SafariDriver();
  }

  driver.manage().window().maximize();
  driver.manage().deleteAllCookies();
  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
  driver.get(url);
  return driver;
 }


 @BeforeMethod
 public void setUp() throws IOException {
  initializeDriver();
 }
}
