package Driver;

import Config.GlobalConsts;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class DriverFactory {

    public static WebDriver driver;
     public static Properties browser;


    public DriverFactory()
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

    @Test
    public void test()
    {
        System.out.println(browser.getProperty("browser"));
    }


}
