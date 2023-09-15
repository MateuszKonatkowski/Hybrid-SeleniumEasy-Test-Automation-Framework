package PageFactory.BasicPage;

import PageFactory.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
public class BoostrapAlertsPage extends AbstractPage {
    WebDriver driver;
    public BoostrapAlertsPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	@FindBy(css="#autoclosable-btn-success")
	private WebElement boostrapAutoSuccessElement;
	@FindBy(css=".alert-autocloseable-success")
	private WebElement boostrapAutoSuccessAlert;
    @FindBy(css="#normal-btn-success")
	private WebElement boostrapSuccessElement;
	@FindBy(css=".alert-normal-success")
	private WebElement boostrapSuccessAlert;
    @FindBy(css="#autoclosable-btn-warning")
	private WebElement boostrapAutoWarningElement;
	@FindBy(css=".alert-autocloseable-warning")
	private WebElement boostrapAutoWarningAlert;
    @FindBy(css="#normal-btn-warning")
	private WebElement boostrapWarningElement;
	@FindBy(css=".alert-normal-warning")
	private WebElement boostrapWarningAlert;
    @FindBy(css="#autoclosable-btn-danger")
	private WebElement boostrapAutoDangerElement;
	@FindBy(css=".alert-autocloseable-danger")
	private WebElement boostrapAutoDangerAlert;
    @FindBy(css="#normal-btn-danger")
	private WebElement boostrapDangerElement;
	@FindBy(css=".alert-normal-danger")
	private WebElement boostrapDangerAlert;
    @FindBy(css="#autoclosable-btn-info")
	private WebElement boostrapAutoInfoElement;
	@FindBy(css=".alert-autocloseable-info")
	private WebElement boostrapAutoInfoAlert;
    @FindBy(css="#normal-btn-info")
	private WebElement boostrapInfoElement;
	@FindBy(css=".alert-normal-info")
	private WebElement boostrapInfoAlert;


    private final String exerciseLevel = "basic_example";
    private final String exercise = "Bootstrap Alerts";

    public void goToExercise()
    {
        goTo(exerciseLevel,exercise);
    }
    public BoostrapAlertsPage clickBoostrapAutoSuccessElement()
    {
        boostrapAutoSuccessElement.click();
        return new BoostrapAlertsPage(driver);
    }
    public BoostrapAlertsPage clickBoostrapSuccessElement()
    {
        boostrapSuccessElement.click();
        return new BoostrapAlertsPage(driver);
    }
    public BoostrapAlertsPage clickBoostrapAutoWarningElement()
    {
        boostrapAutoWarningElement.click();
        return new BoostrapAlertsPage(driver);
    }
    public BoostrapAlertsPage clickBoostrapWarningElement()
    {
        boostrapWarningElement.click();
        return new BoostrapAlertsPage(driver);
    }
    public BoostrapAlertsPage clickBoostrapAutoDangerElement()
    {
        boostrapAutoDangerElement.click();
        return new BoostrapAlertsPage(driver);
    }
    public BoostrapAlertsPage clickBoostrapDangerElement()
    {
        boostrapDangerElement.click();
        return new BoostrapAlertsPage(driver);
    }
    public BoostrapAlertsPage clickBoostrapAutoInfoElement()
    {
        boostrapAutoInfoElement.click();
        return new BoostrapAlertsPage(driver);
    }
    public BoostrapAlertsPage clickBoostrapInfoElement()
    {
        boostrapInfoElement.click();
        return new BoostrapAlertsPage(driver);
    }
    public String getBoostrapAutoSuccessMessage()
    {
        return boostrapAutoSuccessAlert.getText();
    }
    public String getBoostrapSuccessMessage()
    {
        return boostrapSuccessAlert.getText();
    }
    public String getBoostrapAutoWarningMessage()
    {
        return boostrapAutoWarningAlert.getText();
    }
    public String getBoostrapWarningMessage()
    {
        return boostrapWarningAlert.getText();
    }
    public String getBoostrapAutoDangerMessage()
    {
        return boostrapAutoDangerAlert.getText();
    }
    public String getBoostrapDangerMessage()
    {
        return boostrapDangerAlert.getText();
    }
    public String getBoostrapAutoInfoMessage()
    {
        return boostrapAutoInfoAlert.getText();
    }
    public String getBoostrapInfoMessage()
    {
        return boostrapInfoAlert.getText();
    }
    public boolean getBoostrapAutoSuccessStatus()
    {
        waitForElementToDisapire(boostrapAutoSuccessAlert);
        return boostrapAutoSuccessAlert.isDisplayed();
    }
    public boolean getBoostrapAutoWarningStatus()
    {
        waitForElementToDisapire(boostrapAutoWarningAlert);
        return boostrapAutoWarningAlert.isDisplayed();
    }
    public boolean getBoostrapAutoDangerStatus()
    {
        waitForElementToDisapire(boostrapAutoDangerAlert);
        return boostrapAutoDangerAlert.isDisplayed();
    }
    public boolean getBoostrapAutoInfoStatus()
    {
        waitForElementToDisapire(boostrapAutoSuccessAlert);
        return boostrapAutoSuccessAlert.isDisplayed();
    }





}
