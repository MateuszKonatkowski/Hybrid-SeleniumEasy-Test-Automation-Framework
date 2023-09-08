package TestComponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Brudnopis {
    WebDriver driver;
    @Test
    public void test() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.seleniumeasy.com/");
        List<WebElement> lista = driver.findElements(By.cssSelector("#myTab a"));
       // for(int i=0;i<lista.size();i++)
        //{
        //    lista.get(i).click();
        //}
        WebElement exercise = lista
                .stream()
                .filter(a -> a.getAttribute("id").equals("basic_example"))
                .findFirst()
                .orElse(null);
        exercise.click();
        Thread.sleep(2000);
        List<WebElement> zadania = driver.findElements(By.cssSelector("#basic .list-group a"));
        WebElement zada = zadania.stream().filter(a->a.getText().equals("Bootstrap Alerts")).findFirst().orElse(null);
        zada.click();



    }
}
