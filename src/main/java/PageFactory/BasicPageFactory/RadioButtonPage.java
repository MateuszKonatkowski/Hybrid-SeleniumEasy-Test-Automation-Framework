package PageFactory.BasicPageFactory;

import Config.GlobalConsts;
import PageFactory.BasicPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RadioButtonPage extends BasicPage {

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



	private final String exerciseLevel = GlobalConsts.BASIC;
	private final String exercise = GlobalConsts.RADIO_BUTTON;



	public void goToExercise()
	{
		goTo(exerciseLevel,exercise);
	}

	public RadioButtonPage checkEachRadioButton()
	{
		radioButtonElements.stream().forEach(element -> element.click());
		return new RadioButtonPage(driver);
	}

	public RadioButtonPage checkOneRadioButton(String sex)
	{
		radioButtonElements.stream().
				filter(element -> element.getAttribute("value")
						.equalsIgnoreCase(sex))
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

	public RadioButtonPage clickGroupRadioButtonSex(String sex)
	{
		groupRadioButtonSexElements.stream().
                filter(element -> element.getAttribute("value")
                        .equalsIgnoreCase(sex))
                .findFirst()
                .ifPresent(element -> element.click());
        return new RadioButtonPage(driver);
	}

	public RadioButtonPage clickGroupRadioButtonAge(String age)
	{
		groupRadioButtonAgeElements.stream().
                filter(element -> element.getAttribute("value")
                       .equalsIgnoreCase(age))
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
