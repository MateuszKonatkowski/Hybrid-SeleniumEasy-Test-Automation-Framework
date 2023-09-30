package PageFactory;



import Config.GlobalConsts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;

public class BasicPage {
    WebDriver driver;

    public BasicPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css="#myTab a")
    @CacheLookup
    private List<WebElement> exercisesElementsLevel;

    @FindBy(css="#basic .list-group a")
    @CacheLookup
    private List<WebElement> exercisesElements;



    public void waitForElementsVisbility(List<WebElement> elements) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(GlobalConsts.EXPLICITE_TIME));
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public  void  waitForElementVisibility(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(GlobalConsts.EXPLICITE_TIME));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void  waitForElementToDisapire(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(GlobalConsts.EXPLICITE_TIME));
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
