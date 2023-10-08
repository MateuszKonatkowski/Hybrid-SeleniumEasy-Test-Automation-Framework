package PageFactory.BasicPageFactory;

import Config.GlobalConsts;
import PageFactory.BasePage;
import Util.ExcelDataUtil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

public class SelectDropdownListPage extends BasePage {

    WebDriver driver;

    public SelectDropdownListPage()
    {

    }

    public SelectDropdownListPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="#select-demo")
    @CacheLookup
    private WebElement selectElement;

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
	private WebElement multiSelectMessageElement;



    private final String exerciseLevel = GlobalConsts.BASIC;
    private final String exercise = GlobalConsts.SELECT_DROPDOWN_LIST;
    private final String data_path = GlobalConsts.SELECT_DROPDOWN_LIST_DEMO_DATA_PATH;



    @DataProvider(name = "TestData")
    public Object[][] getData(Method method) throws IOException
    {
        return ExcelDataUtil.getData(method, data_path);
    }

        public void goToExercise()
    {
        goTo(exerciseLevel,exercise);
    }

    public SelectDropdownListPage  selectValue(String day)
    {
        Select select = new Select(selectElement);
        select.selectByValue(day);
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
        return multiSelectMessageElement.getText();
    }

    public SelectDropdownListPage  multiSelectSelectAllValues()
    {
        Select select = new Select(multiSelectElement);
        Actions actions = new Actions(driver);
        List<WebElement> options = select.getOptions();
        waitForElementsVisibility(options);
        options.stream().forEach(option -> actions.keyDown(Keys.CONTROL).click(option).build().perform());
        return new SelectDropdownListPage(driver);
    }

    public SelectDropdownListPage  multiSelectSelectFirstValue() {
        Select select = new Select(multiSelectElement);
        Actions actions = new Actions(driver);
        List<WebElement> options = select.getOptions();
        waitForElementsVisibility(options);
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
