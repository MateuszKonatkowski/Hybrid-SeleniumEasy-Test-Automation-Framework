package PageFactory;



import Config.GlobalConsts;
import Util.LoggerUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;

public class BasePage {
    public static WebDriver driver;

    public BasePage()
    {

    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css="#myTab a")
    @CacheLookup
    private List<WebElement> exercisesElementsLevel;

    @FindBy(css=".active.in .list-group a")
    @CacheLookup
    private List<WebElement> exercisesElements;



    public void waitForElementsVisibility(List<WebElement> elements) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(GlobalConsts.EXPLICITE_TIME));
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        LoggerUtil.info("Wait for "+elements+" to be visible");
    }

    public  void  waitForElementVisibility(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(GlobalConsts.EXPLICITE_TIME));
        wait.until(ExpectedConditions.visibilityOf(element));
        LoggerUtil.info("Wait for "+element+" to be visible");
    }

    public void  waitForElementToDisappear(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(GlobalConsts.EXPLICITE_TIME));
        wait.until(ExpectedConditions.invisibilityOf(element));
        LoggerUtil.info("Wait for "+element+" to disappear");
    }

    public void waitForElementTextAToBeEquals(WebElement element,String expected)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(GlobalConsts.EXPLICITE_TIME));
        wait.until(ExpectedConditions.textToBePresentInElement(element,expected));
    }

    protected void choseExerciseLevel(String choseLevel) {
        System.out.println(exercisesElementsLevel);
        waitForElementsVisibility(exercisesElementsLevel);
        WebElement exercise = exercisesElementsLevel
                .stream()
                .filter(a -> a.getAttribute("id").equals(choseLevel))
                .findFirst()
                .orElse(null);
        exercise.click();
        LoggerUtil.info("Chose "+choseLevel+" level");
    }

    protected void choseExercise(String choseExercise)
    {

        System.out.println(exercisesElements);
        //waitForElementsVisibility(exercisesElements);
        WebElement exercise = exercisesElements
                .stream()
                .filter(a->a.getText().equals(choseExercise))
                .findFirst()
                .orElse(null);
        exercise.click();
        LoggerUtil.info("Chose "+choseExercise+" exercise");
    }

    protected void goTo(String level,String exerciseLevel)
    {
        choseExerciseLevel(level);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        choseExercise(exerciseLevel);
    }

}
