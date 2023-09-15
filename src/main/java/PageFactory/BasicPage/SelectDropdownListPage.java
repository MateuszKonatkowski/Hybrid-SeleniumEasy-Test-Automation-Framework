package PageFactory.BasicPage;

import PageFactory.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectDropdownListPage extends AbstractPage {
    WebDriver driver;

    public SelectDropdownListPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="#select-demo")
    @CacheLookup
    private WebElement selectElemnt;

    @FindBy(css=".selected-value")
    @CacheLookup
    private WebElement selectMessageElement;

	@FindBy(css="#multi-select")
    @CacheLookup
	private WebElement multiSelectElement;

	@FindBy(css="#printMe")
    @CacheLookup
	private WebElement multiSelectFirsSelectedButtonElement;

	@FindBy(css="#printAll")
    @CacheLookup
	private WebElement multiSelectAllSelectedButtonElement;
	@FindBy(css=".getall-selected")
    @CacheLookup
	private WebElement multiSelectMessage;

    private final String exerciseLevel = "basic_example";
    private final String exercise = "Select Dropdown List";


    public void goToExercise()
    {
        goTo(exerciseLevel,exercise);
    }


    public SelectDropdownListPage  selectValue()
    {
        Select select = new Select(selectElemnt);
        select.selectByValue("Sunday");
        return new SelectDropdownListPage(driver);
    }
    public String getSelectMessage()
    {
        return selectMessageElement.getText();
    }
    public boolean multiSelectStatus()
    {
        Select select = new Select(multiSelectElement);
        return select.isMultiple();
    }
    public String getMultiSelectMessage()
    {
        return multiSelectMessage.getText();
    }
    public SelectDropdownListPage  multiSelectSelectAllValues()
    {
        Select select = new Select(multiSelectElement);
        Actions actions = new Actions(driver);
        List<WebElement> options = select.getOptions();
        options.stream().forEach(option -> actions.keyDown(Keys.CONTROL).click(option).build().perform());
        return new SelectDropdownListPage(driver);
    }
    public SelectDropdownListPage  multiSelectSelectFirstValue() {
        Select select = new Select(multiSelectElement);
        Actions actions = new Actions(driver);
        List<WebElement> options = select.getOptions();
        options.stream().forEach(option -> actions.keyDown(Keys.CONTROL).click(option).build().perform());
        return new SelectDropdownListPage(driver);
    }

        public SelectDropdownListPage clickMultiSelectFirsSelectedButton()
    {
        multiSelectFirsSelectedButtonElement.click();
        return new SelectDropdownListPage(driver);
    }
    public SelectDropdownListPage clickMultiSelectAllSelectedButton()
    {
        multiSelectAllSelectedButtonElement.click();
        return new SelectDropdownListPage(driver);
    }
}
