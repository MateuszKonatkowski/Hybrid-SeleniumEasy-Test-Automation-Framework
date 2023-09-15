package PageFactory.BasicPage;

import PageFactory.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	private WebElement singelInputElement;
	@FindBy(css="#get-input button")
	private WebElement singelInputButtonElement;
	@FindBy(css="#display")
	private WebElement singelInputMessageElement;
	@FindBy(css="#value1")
	private WebElement doubelInputFirstValueElement;
	@FindBy(css="#value2")
	private WebElement doubelInputSecendValueElement;
	@FindBy(css="#gettotal button")
	private WebElement doubelInputButtonElement;

	@FindBy(css="#displayvalue")
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
