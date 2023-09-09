package AbstractComponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AbstractComponent {
    WebDriver driver;
    public AbstractComponent(WebDriver driver)
    {
        this.driver=driver;
    }
    @FindBy(css="#myTab a")
    private List<WebElement> exercisesElementsLevel;
    @FindBy(css="#basic .list-group a")
    private List<WebElement> exercisesElements;



    public void waitForElements(List<WebElement> elements)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }
    public void waitForElementToClick(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void choseExerciseLevel(String choseLevel)
    {
        waitForElements(exercisesElementsLevel);
        WebElement exercise = exercisesElementsLevel
                .stream()
                .filter(a -> a.getAttribute("id").equals(choseLevel))
                .findFirst()
                .orElse(null);
        exercise.click();

    }
    public void choseExercise(String choseExercise)
    {
        waitForElements(exercisesElements);
        WebElement exercise = exercisesElements
                .stream()
                .filter(a->a.getText().equals(choseExercise))
                .findFirst()
                .orElse(null);
        exercise.click();
    }

    public void goTo(String Level,String exerciseLevel)
    {
        choseExerciseLevel(Level);
        choseExercise(exerciseLevel);
    }
}
