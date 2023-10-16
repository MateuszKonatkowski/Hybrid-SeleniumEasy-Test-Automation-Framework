package PageFactory.AdvancedPageFactory;

import Config.GlobalConsts;
import Util.ExcelDataUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import PageFactory.BasePage;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

public class TableDataSearchPage extends BasePage {

    WebDriver driver;

    public TableDataSearchPage()
    {

    }

    public TableDataSearchPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



	@FindBy(css="#task-table-filter")
    @CacheLookup
	private WebElement tableDataTaskInputElement;

	@FindBy(css="#task-table tbody tr td")
    @CacheLookup
	private List<WebElement> tableDataTaskListElements;

	@FindBy(css=".btn-filter")
    @CacheLookup
	private WebElement tableDataUsersFilterButtonElement;

	@FindBy(css=".filters input")
    @CacheLookup
	private List<WebElement> tableDataUsersFilterInputElements;//

    @FindBy(css=".filterable tbody tr td")
    @CacheLookup
    private List<WebElement> tableDataUsersFilterListElements;




    private final String exerciseLevel = GlobalConsts.ADVANCED;
    private final String exercise = GlobalConsts.TABLE_DATA_SEARCH;
    private final String data_path = GlobalConsts.TABLE_DATA_SEARCH_DATA_PATH;



    @DataProvider(name = "TestData")
    public Object[][] getData(Method method) throws IOException {
        return ExcelDataUtil.getData(method, data_path);
    }

    public void goToExercise() {
        goTo(exerciseLevel, exercise);
    }


    public TableDataSearchPage sendTaskInputValue(String value)
    {
        tableDataTaskInputElement.sendKeys(value);
        return new TableDataSearchPage(driver);
    }

    public boolean getTaskListElementStatus(String element)
    {
       return tableDataTaskListElements
                .stream()
                .anyMatch(a -> a.getText().equalsIgnoreCase(element));
    }

    public String getTaskListElementCount(String element)
    {
        return String.valueOf(tableDataTaskListElements
                .stream()
                .filter(a -> a.getText().equalsIgnoreCase(element)).count());
    }

    public TableDataSearchPage clickUsersFilterButtonButton()
    {
        tableDataUsersFilterButtonElement.click();
        return new TableDataSearchPage(driver);
    }

    public TableDataSearchPage sendUsersFilterInputValue(String filter, String value)
    {
        WebElement inputFilter = tableDataUsersFilterInputElements
                .stream()
                .filter(a -> a.getAttribute("placeholder").equalsIgnoreCase(filter))
                .findFirst()
                .orElse(null);
        inputFilter.sendKeys(value);
        return new TableDataSearchPage(driver);
    }

    public boolean getUsersFilterListElementStatus(String element)
    {
        return tableDataUsersFilterListElements
                .stream()
                .anyMatch(a -> a.getText().equalsIgnoreCase(element));
    }

    public String getUsersFilterListElementCount(String element)
    {
        return String.valueOf(tableDataUsersFilterListElements
                .stream()
                .filter(a -> a.getText().equalsIgnoreCase(element)).count());
    }

}
