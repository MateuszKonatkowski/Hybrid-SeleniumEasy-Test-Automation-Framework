package PageFactory;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SimpelFormDemoPage extends AbstractComponent {
    WebDriver driver;
    public SimpelFormDemoPage(WebDriver driver) {
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

    String exerciseLevel = "basic_example";
    String exercise = "Simple Form Demo";


    public void goToExercise()
    {
        goTo(exerciseLevel,exercise);
    }

    public SimpelFormDemoPage sendSingelInputValue(String value)
    {
        singelInputElement.sendKeys(value);
        return new SimpelFormDemoPage(driver);
    }
    public SimpelFormDemoPage sendDoubellInputValue(String first_value,String secend_value)
    {
        doubelInputFirstValueElement.sendKeys(first_value);
        doubelInputSecendValueElement.sendKeys(secend_value);
        return new SimpelFormDemoPage(driver);
    }
    public SimpelFormDemoPage clickSingelInputButton()
    {
        singelInputButtonElement.click();
        return new SimpelFormDemoPage(driver);
    }
    public String getSingleInputMessage()
    {
        return singelInputMessageElement.getText();

    }
    public SimpelFormDemoPage clickDobuelInputValue()
    {
        doubelInputButtonElement.click();
        return new SimpelFormDemoPage(driver);
    }
    public String getDobuelInputMessage()
    {
        return doubleInputMessageElement.getText();
    }









}
