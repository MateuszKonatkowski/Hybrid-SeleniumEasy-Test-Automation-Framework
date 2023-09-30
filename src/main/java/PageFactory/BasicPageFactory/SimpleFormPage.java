package PageFactory.BasicPageFactory;

import Config.GlobalConsts;
import PageFactory.BasicPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SimpleFormPage extends BasicPage {

    WebDriver driver;

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
