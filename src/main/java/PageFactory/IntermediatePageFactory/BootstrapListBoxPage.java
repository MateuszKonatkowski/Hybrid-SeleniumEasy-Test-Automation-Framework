package PageFactory.IntermediatePageFactory;

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

public class BootstrapListBoxPage extends BasePage {

    WebDriver driver;

    public BootstrapListBoxPage()
    {

    }

    public BootstrapListBoxPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


	@FindBy(css=".list-left .form-control")
    @CacheLookup
	private WebElement boostrapListLeftSearchInputElement;

    @FindBy(css=".list-right .form-control")
    @CacheLookup
    private WebElement boostrapListRightSearchInputElement;

	@FindBy(css=".list-left .btn")
    @CacheLookup
	private WebElement boostrapListLeftSelectAllButtonElement;

	@FindBy(css=".list-right .btn")
    @CacheLookup
	private WebElement boostrapListRightLeftSelectAllButtonElement;

	@FindBy(css=".move-left")
    @CacheLookup
	private WebElement boostrapListLeftMoveButtonElement;

    @FindBy(css=".move-right")
    @CacheLookup
    private WebElement boostrapListRightMoveButtonElement;

	@FindBy(css=".list-left .list-group li")
    @CacheLookup
	private List<WebElement> boostrapListLeftValuesElements;

    @FindBy(css=".list-right .list-group li")
    @CacheLookup
    private List<WebElement> boostrapListRightValuesElements;



    private final String exerciseLevel = GlobalConsts.INTERMEDIATE;
    private final String exercise = GlobalConsts.BOOSTRAP_LIST_BOX;
    private final String data_path = GlobalConsts.BOOSTRAP_LIST_BOX_DATA_PATH;



    @DataProvider(name = "TestData")
    public Object[][] getData(Method method) throws IOException {
        return ExcelDataUtil.getData(method, data_path);
    }

    public void goToExercise() {
        goTo(exerciseLevel, exercise);
    }


    public  BootstrapListBoxPage sendLeftSearchInputValue(String search)
    {
        boostrapListLeftSearchInputElement.sendKeys(search);
        return new BootstrapListBoxPage(driver);
    }

    public  BootstrapListBoxPage sendRightSearchInputValue(String search)
    {
        boostrapListRightSearchInputElement.sendKeys(search);
        return new BootstrapListBoxPage(driver);
    }

    public  BootstrapListBoxPage clickLeftSelectAllButtonButton()
    {
        boostrapListLeftSelectAllButtonElement.click();
        return new BootstrapListBoxPage(driver);
    }

    public  BootstrapListBoxPage clickRightSelectAllButtonButton()
    {
        boostrapListRightLeftSelectAllButtonElement.click();
        return new BootstrapListBoxPage(driver);
    }

    public  BootstrapListBoxPage clickMoveLeftButtonButton()
    {
        boostrapListLeftMoveButtonElement.click();
        return new BootstrapListBoxPage(driver);
    }

    public  BootstrapListBoxPage clickMoveRightButtonButton()
    {
        boostrapListRightMoveButtonElement.click();
        return new BootstrapListBoxPage(driver);
    }


    public BootstrapListBoxPage selectLeftValuesValue(String value)
    {
        WebElement element = boostrapListLeftValuesElements
                .stream()
                .filter(a -> a.getText().equalsIgnoreCase(value))
                .findFirst()
                .orElse(null);
        element.click();
        return new BootstrapListBoxPage(driver);
    }

    public BootstrapListBoxPage selectRightValuesValue(String value)
    {
        WebElement element = boostrapListRightValuesElements
                .stream()
                .filter(a -> a.getText().equalsIgnoreCase(value))
                .findFirst()
                .orElse(null);
        element.click();
        return new BootstrapListBoxPage(driver);
    }
    public boolean getLeftValueToRightStatus(String value)
    {
        return boostrapListRightValuesElements
                .stream()
                .anyMatch(a -> a.getText().equalsIgnoreCase(value));
    }

    public boolean getRightValueToLeftStatus(String value)
    {
        return boostrapListLeftValuesElements
                .stream()
                .anyMatch(a -> a.getText().equalsIgnoreCase(value));
    }

    public String getLeftValuesCount()
    {
         int all_values = (int) boostrapListLeftValuesElements.stream().count();
         int hidden_values = (int) boostrapListLeftValuesElements
                .stream()
                .filter(a -> a.getAttribute("style").equalsIgnoreCase("display: none;"))
                .count();
        return String.valueOf(all_values-hidden_values);
    }

    public String getRightValuesCount()
    {
        int all_values = (int) boostrapListRightValuesElements.stream().count();
        int hidden_values = (int) boostrapListRightValuesElements
                .stream()
                .filter(a -> a.getAttribute("style").equalsIgnoreCase("display: none;"))
                .count();
        return String.valueOf(all_values-hidden_values);
    }

}
