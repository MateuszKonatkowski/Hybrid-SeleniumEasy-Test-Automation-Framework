package TestComponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Brudnopis {
    WebDriver driver;
    @Test
    public void test() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.seleniumeasy.com/window-popup-modal-demo.html");
       WebElement buton= driver.findElement(By.cssSelector(".two-windows a"));
       buton.click();
       Set<String> windows = driver.getWindowHandles();

       Iterator<String> it = windows.iterator();
       while (it.hasNext())
       {
           System.out.println(driver.switchTo().window(it.next()).getCurrentUrl());
       }
      // String parentid = it.next();
       //String childid1 = it.next();
       //String childid2 = it.next();
       //driver.switchTo().window(childid1);
       //System.out.println(driver.switchTo().window(childid1).getCurrentUrl());

        //System.out.println(driver.switchTo().window(childid2).getCurrentUrl());
      // windows.remove(parentid);






    }
}
