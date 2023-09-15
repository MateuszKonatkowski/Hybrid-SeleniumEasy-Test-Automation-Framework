package PageFactory.BasicPage;

import PageFactory.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RadioButtonPage extends AbstractPage {
    WebDriver driver;

    public RadioButtonPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

	@FindBy(css=".text-left .panel:nth-of-type(1) input")
	@CacheLookup
	private List<WebElement> radioButtonElements;

	@FindBy(css="#buttoncheck")
	@CacheLookup
	private WebElement radioButtonButtonElement;

	@FindBy(css=".radiobutton")
	@CacheLookup
	private WebElement radioButtonMessageElement;

	@FindBy(css=".text-left .panel:nth-of-type(2) div.panel-body div:first-of-type input")
	@CacheLookup
	private List<WebElement> groupRadioButtonSexElements;

	@FindBy(css=".text-left .panel:nth-of-type(2) div.panel-body div:last-of-type input")
	@CacheLookup
	private List<WebElement> groupRadioButtonAgeElements;

	@FindBy(css=".text-left .panel:nth-of-type(2) button")
	@CacheLookup
	private WebElement groupRadioButtonButtonElement;

	@FindBy(css=".groupradiobutton")
	@CacheLookup
	private WebElement groupRadioButtonMessageElement;


	private final String exerciseLevel = "basic_example";
	private final String exercise = "Radio Buttons Demo";


	public void goToExercise()
	{
		goTo(exerciseLevel,exercise);
	}



	public RadioButtonPage checkEachRadioButton()
	{
		radioButtonElements.stream().forEach(element -> element.click());
		return new RadioButtonPage(driver);
	}
	public RadioButtonPage checkOneRadioButton()
	{
		radioButtonElements.stream().
				filter(element -> element.getAttribute("value")
						.equalsIgnoreCase("Male"))
				.findFirst()
				.ifPresent(element -> element.click());
		return new RadioButtonPage(driver);
	}
	public String getDarioButtonMessage()
	{
		return radioButtonMessageElement.getText();
	}
	public RadioButtonPage clickRadioButtonButton()
	{
		radioButtonButtonElement.click();
        return new RadioButtonPage(driver);
	}
	public RadioButtonPage clickGroupRadioButtonSex()
	{
		groupRadioButtonSexElements.stream().
                filter(element -> element.getAttribute("value")
                        .equalsIgnoreCase("Male"))
                .findFirst()
                .ifPresent(element -> element.click());
        return new RadioButtonPage(driver);
	}
	public RadioButtonPage clickGroupRadioButtonAge()
	{
		groupRadioButtonAgeElements.stream().
                filter(element -> element.getAttribute("value")
                       .equalsIgnoreCase("0 - 5"))
               .findFirst()
               .ifPresent(element -> element.click());
        return new RadioButtonPage(driver);
	}
	public RadioButtonPage clickGroupRadioButtonButton()
	{
		groupRadioButtonButtonElement.click();
		return new RadioButtonPage(driver);
	}
	public String getDarioGroupRadioButtonMessage()
	{
		return groupRadioButtonMessageElement.getText();
	}



}
