package PageFactory.BasicPageFactory;

import Config.GlobalConsts;
import PageFactory.BasePage;
import Util.ExcelDataUtil;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

public class SimpleFormPage extends BasePage {

    WebDriver driver;

    public SimpleFormPage()
    {

    }

    public SimpleFormPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }



    @FindBy(css="#user-message")
    @CacheLookup
	private WebElement singleInputElement;

	@FindBy(css="#get-input button")
    @CacheLookup
	private WebElement singleInputButtonElement;

	@FindBy(css="#display")
    @CacheLookup
	private WebElement singleInputMessageElement;

	@FindBy(css="#value1")
    @CacheLookup
	private WebElement doubleInputFirstValueElement;

	@FindBy(css="#value2")
    @CacheLookup
	private WebElement doubleInputSecondValueElement;

	@FindBy(css="#gettotal button")
    @CacheLookup
	private WebElement doubleInputButtonElement;

	@FindBy(css="#displayvalue")
    @CacheLookup
	private WebElement doubleInputMessageElement;



    private final String exerciseLevel = GlobalConsts.BASIC;
    private final String exercise = GlobalConsts.SIMPLE_FORM;
    private final String data_path = GlobalConsts.SIMPLE_FORM_DEMO_DATA_PATH;




    @DataProvider(name = "TestData")
    public Object[][] getData(Method method) throws IOException
    {
        return ExcelDataUtil.getData(method,data_path);
    }

    public void goToExercise()
    {
        goTo(exerciseLevel,exercise);
    }

    public SimpleFormPage sendSingleInputValue(String value)
    {
        singleInputElement.sendKeys(value);
        return new SimpleFormPage(driver);
    }

    public SimpleFormPage sendDoubleInputValue(String firstValue, String secondValue)
    {
        doubleInputFirstValueElement.sendKeys(firstValue);
        doubleInputSecondValueElement.sendKeys(secondValue);
        return new SimpleFormPage(driver);
    }

    public SimpleFormPage clickSingleInputButton()
    {
        singleInputButtonElement.click();
        return new SimpleFormPage(driver);
    }

    public String getSingleInputMessage()
    {
        return singleInputMessageElement.getText();

    }

    public SimpleFormPage clickDoubleInputValue()
    {
        doubleInputButtonElement.click();
        return new SimpleFormPage(driver);

    }

    public String getDoubleInputMessage()
    {
        return doubleInputMessageElement.getText();
    }



}

