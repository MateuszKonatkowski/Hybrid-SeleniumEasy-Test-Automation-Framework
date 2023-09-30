package TestComponents;

import Config.GlobalConsts;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Brudnopis {
    WebDriver driver;



    public Brudnopis() throws IOException {
        config.load(new FileInputStream(propFile));
    }
    Properties config= new Properties();
    File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\Config\\Page\\Brudnopis.properties");
    private static final String CODE1 = "{\n    \"theme\": \"standard\",\n    \"encoding\": \"utf-8\n}";
    private static final String CODE2 = "{\n    \"protocol\": \"HTTPS\",\n    \"timelineEnabled\": false\n}";


    @Test
    public void test1()
    {

        Date currentdate = new Date();
        System.out.println(currentdate.getMinutes());
        System.out.println(GlobalConsts.SCREENSHOT_PATH);
    }
    @Test
    public void test() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.seleniumeasy.com/bootstrap-modal-demo.html");
       WebElement buton= driver.findElement(By.cssSelector("a[href='#myModal']"));
       buton.click();
       Thread.sleep(2000);
       driver.findElement(By.cssSelector("a[href='#myModal2']")).click();


    }
}
