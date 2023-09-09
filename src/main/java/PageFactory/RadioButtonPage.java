package PageFactory;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RadioButtonPage extends AbstractComponent {
    WebDriver driver;
    public RadioButtonPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
	@FindBy(css=".text-left .panel:nth-of-type(1) input")
	private List<WebElement> radioButtonElements;
	@FindBy(css="#buttoncheck")
	private WebElement radioButtonButtonElement;
	@FindBy(css=".radiobutton")
	private WebElement radioButtonMessageElement;
	@FindBy(css=".text-left .panel:nth-of-type(2) div.panel-body div:first-of-type input")
	private List<WebElement> groupRadioButtonSexElements;
	@FindBy(css=".text-left .panel:nth-of-type(2) div.panel-body div:last-of-type input")
	private List<WebElement> groupRadioButtonAgeElements;
	@FindBy(css=".text-left .panel:nth-of-type(2) button")
	private WebElement groupRadioButtonButtonElement;
	@FindBy(css=".groupradiobutton")
	private WebElement groupRadioButtonMessageElement;


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




}
