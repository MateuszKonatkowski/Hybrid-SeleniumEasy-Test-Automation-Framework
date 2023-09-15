package PageFactory.BasicPage;

import PageFactory.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SimpelFormPage extends AbstractPage {
    WebDriver driver;
    public SimpelFormPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

	@FindBy(css="#user-message")
    @CacheLookup
	private WebElement singelInputElement;

	@FindBy(css="#get-input button")
    @CacheLookup
	private WebElement singelInputButtonElement;

	@FindBy(css="#display")
    @CacheLookup
	private WebElement singelInputMessageElement;

	@FindBy(css="#value1")
    @CacheLookup
	private WebElement doubelInputFirstValueElement;

	@FindBy(css="#value2")
    @CacheLookup
	private WebElement doubelInputSecendValueElement;

	@FindBy(css="#gettotal button")
    @CacheLookup
	private WebElement doubelInputButtonElement;

	@FindBy(css="#displayvalue")
    @CacheLookup
	private WebElement doubleInputMessageElement;

    private final String exerciseLevel = "basic_example";
    private final String exercise = "Simple Form Demo";


    public void goToExercise()
    {
        goTo(exerciseLevel,exercise);
    }

    public SimpelFormPage sendSingelInputValue(String value)
    {
        singelInputElement.sendKeys(value);
        return new SimpelFormPage(driver);
    }
    public SimpelFormPage sendDoubellInputValue(String firstValue, String secendValue)
    {
        doubelInputFirstValueElement.sendKeys(firstValue);
        doubelInputSecendValueElement.sendKeys(secendValue);
        return new SimpelFormPage(driver);
    }
    public SimpelFormPage clickSingelInputButton()
    {
        singelInputButtonElement.click();
        return new SimpelFormPage(driver);
    }
    public String getSingleInputMessage()
    {
        return singelInputMessageElement.getText();

    }
    public SimpelFormPage clickDobuelInputValue()
    {
        doubelInputButtonElement.click();
        return new SimpelFormPage(driver);
    }
    public String getDobuelInputMessage()
    {
        return doubleInputMessageElement.getText();
    }









}
