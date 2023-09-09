package PageFactory;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckboxDemoPage extends AbstractComponent {
    WebDriver driver;
    public CheckboxDemoPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css="#isAgeSelected")
	private WebElement checkBoxElement;
	@FindBy(css="label:nth-child(2) input")
	private WebElement checkBoxCheckedElement;
    @FindBy(css="label:nth-child(3) input")
    private WebElement checkBoxDisableElement;
    @FindBy(css="div .checkbox .cb1-element")
    private List<WebElement> multipleCheckBoxElements;
    @FindBy(css="#check1")
    private WebElement multipleCheckBoxButtonElement;
    @FindBy(css="#isChkd")
    private WebElement multipleCheckBoxIsCheckedElement;
	@FindBy(css="#txtAge")
	private WebElement checkBoxMessageElement;


    private final String exerciseLevel = "basic_example";
   private final String exercise = "Check Box Demo";


    public void goToExercise()
    {
        goTo(exerciseLevel,exercise);
    }

    public CheckboxDemoPage clickCheckBox()
    {
        checkBoxElement.click();
        return new CheckboxDemoPage(driver);
    }
    public CheckboxDemoPage doubelClickCheckBox()
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(checkBoxElement).doubleClick().build().perform();
        return new CheckboxDemoPage(driver);
    }
    public String getCheckBoxMessage()
    {
        return checkBoxMessageElement.getText();

    }
    public void clickCheckBoxChecked()
    {
        checkBoxCheckedElement.click();

    }
    public void doubleClickCheckBoxChecked()
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(checkBoxCheckedElement).doubleClick().build().perform();

    }
    public boolean getCheckBoxCheckedStatus()
    {
        return checkBoxCheckedElement.isSelected();
    }
    public boolean getCheckBoxDisabelStatus()
    {
        return checkBoxDisableElement.isEnabled();
    }
    public CheckboxDemoPage clickMultipleCheckBoxAllButton()
    {
        multipleCheckBoxButtonElement.click();
        return new CheckboxDemoPage(driver);
    }
    public CheckboxDemoPage doubleClickMultipleCheckBoxAllButton()
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(multipleCheckBoxButtonElement).doubleClick().build().perform();
        return new CheckboxDemoPage(driver);
    }
    public String getMultipleCheckBoxAllButtonValue()
    {
        return multipleCheckBoxButtonElement.getAttribute("value");

    }
    public CheckboxDemoPage  clickAllMultipleCheckBox()
    {
        multipleCheckBoxElements
                .stream()
                .forEach(a->a.click());
        return new CheckboxDemoPage(driver);
    }
    public String getMultipleCheckBoxIsCheckedStatus()
    {
       return multipleCheckBoxIsCheckedElement.getAttribute("value");

    }

}
