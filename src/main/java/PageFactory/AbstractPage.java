package PageFactory;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;

public class AbstractPage {
    WebDriver driver;
    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(css="#myTab a")
    private List<WebElement> exercisesElementsLevel;
    @FindBy(css="#basic .list-group a")
    private List<WebElement> exercisesElements;



    public void waitForElementsVisbility(List<WebElement> elements) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(8));
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }
    public void waitForElementToClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void  waitForElementToDisapire(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(8));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    protected void choseExerciseLevel(String choseLevel) {
        waitForElementsVisbility(exercisesElementsLevel);
        WebElement exercise = exercisesElementsLevel
                .stream()
                .filter(a -> a.getAttribute("id").equals(choseLevel))
                .findFirst()
                .orElse(null);
        exercise.click();

    }
    protected void choseExercise(String choseExercise)
    {
        waitForElementsVisbility(exercisesElements);
        WebElement exercise = exercisesElements
                .stream()
                .filter(a->a.getText().equals(choseExercise))
                .findFirst()
                .orElse(null);
        exercise.click();
    }

    protected void goTo(String level,String exerciseLevel)
    {
        choseExerciseLevel(level);
        choseExercise(exerciseLevel);
    }
}
