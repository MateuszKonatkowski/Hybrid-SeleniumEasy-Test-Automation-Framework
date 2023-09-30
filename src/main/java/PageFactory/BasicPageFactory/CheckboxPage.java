package PageFactory.BasicPageFactory;

import Config.GlobalConsts;
import PageFactory.BasicPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckboxPage extends BasicPage {

    WebDriver driver;

    public CheckboxPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="#isAgeSelected")
    @CacheLookup
	private WebElement checkBoxElement;

	@FindBy(css="label:nth-child(2) input")
    @CacheLookup
	private WebElement checkBoxCheckedElement;

    @FindBy(css="label:nth-child(3) input")
    @CacheLookup
    private WebElement checkBoxDisableElement;

    @FindBy(css="div .checkbox .cb1-element")
    @CacheLookup
    private List<WebElement> multipleCheckBoxElements;

    @FindBy(css="#check1")
    @CacheLookup
    private WebElement multipleCheckBoxButtonElement;

    @FindBy(css="#isChkd")
    @CacheLookup
    private WebElement multipleCheckBoxIsCheckedElement;

	@FindBy(css="#txtAge")
    @CacheLookup
	private WebElement checkBoxMessageElement;



    private final String exerciseLevel = GlobalConsts.BASIC;
    private final String exercise = GlobalConsts.CHECK_BOX;



    public void goToExercise()
    {
        goTo(exerciseLevel,exercise);
    }

    public CheckboxPage clickCheckBox()
    {
        checkBoxElement.click();
        return new CheckboxPage(driver);
    }

    public CheckboxPage doubleClickCheckBox()
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(checkBoxElement).doubleClick().build().perform();
        return new CheckboxPage(driver);
    }

    public String getCheckBoxMessage()
    {
        return checkBoxMessageElement.getText();
    }

    public void clickCheckBoxChecked()
    {
        checkBoxCheckedElement.click();
    }

    public boolean getCheckBoxCheckedStatus()
    {
        return checkBoxCheckedElement.isSelected();
    }

    public boolean getCheckBoxDisableStatus()
    {
        return checkBoxDisableElement.isEnabled();
    }

    public CheckboxPage clickMultipleCheckBoxAllButton()
    {
        multipleCheckBoxButtonElement.click();
        return new CheckboxPage(driver);
    }

    public CheckboxPage doubleClickMultipleCheckBoxAllButton()
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(multipleCheckBoxButtonElement).doubleClick().build().perform();
        return new CheckboxPage(driver);
    }

    public String getMultipleCheckBoxAllButtonValue()
    {
        return multipleCheckBoxButtonElement.getAttribute("value");
    }

    public CheckboxPage clickAllMultipleCheckBox()
    {
        multipleCheckBoxElements
                .stream()
                .forEach(a->a.click());
        return new CheckboxPage(driver);
    }

    public String getMultipleCheckBoxIsCheckedStatus()
    {
       return multipleCheckBoxIsCheckedElement.getAttribute("value");
    }

}