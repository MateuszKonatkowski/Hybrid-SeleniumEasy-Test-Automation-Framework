package PageFactory.BasicPageFactory;

import Config.GlobalConsts;
import PageFactory.BasicPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
public class BoostrapAlertsPage extends BasicPage {

    WebDriver driver;

    public BoostrapAlertsPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

	@FindBy(css="#autoclosable-btn-success")
    @CacheLookup
	private WebElement boostrapAutoSuccessElement;

	@FindBy(css=".alert-autocloseable-success")
    @CacheLookup
	private WebElement boostrapAutoSuccessAlertElement;

    @FindBy(css="#normal-btn-success")
    @CacheLookup
	private WebElement boostrapSuccessElement;

	@FindBy(css=".alert-normal-success")
    @CacheLookup
	private WebElement boostrapSuccessAlertElement;

    @FindBy(css="#autoclosable-btn-warning")
    @CacheLookup
	private WebElement boostrapAutoWarningElement;

	@FindBy(css=".alert-autocloseable-warning")
    @CacheLookup
	private WebElement boostrapAutoWarningAlertElement;

    @FindBy(css="#normal-btn-warning")
    @CacheLookup
	private WebElement boostrapWarningElement;

	@FindBy(css=".alert-normal-warning")
    @CacheLookup
	private WebElement boostrapWarningAlertElement;

    @FindBy(css="#autoclosable-btn-danger")
    @CacheLookup
	private WebElement boostrapAutoDangerElement;

	@FindBy(css=".alert-autocloseable-danger")
    @CacheLookup
	private WebElement boostrapAutoDangerAlertElement;

    @FindBy(css="#normal-btn-danger")
    @CacheLookup
	private WebElement boostrapDangerElement;

	@FindBy(css=".alert-normal-danger")
    @CacheLookup
	private WebElement boostrapDangerAlertElement;

    @FindBy(css="#autoclosable-btn-info")
    @CacheLookup
	private WebElement boostrapAutoInfoElement;

	@FindBy(css=".alert-autocloseable-info")
    @CacheLookup
	private WebElement boostrapAutoInfoAlertElement;

    @FindBy(css="#normal-btn-info")
    @CacheLookup
	private WebElement boostrapInfoElement;

	@FindBy(css=".alert-normal-info")
    @CacheLookup
	private WebElement boostrapInfoAlertElement;



    private final String exerciseLevel = GlobalConsts.BASIC;
    private final String exercise = GlobalConsts.BOOSTRAP_ALERTS;



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
        return boostrapAutoSuccessAlertElement.getText();
    }

    public String getBoostrapSuccessMessage()
    {
        return boostrapSuccessAlertElement.getText();
    }

    public String getBoostrapAutoWarningMessage()
    {
        return boostrapAutoWarningAlertElement.getText();
    }

    public String getBoostrapWarningMessage()
    {
        return boostrapWarningAlertElement.getText();
    }

    public String getBoostrapAutoDangerMessage()
    {
        return boostrapAutoDangerAlertElement.getText();
    }

    public String getBoostrapDangerMessage()
    {
        return boostrapDangerAlertElement.getText();
    }

    public String getBoostrapAutoInfoMessage()
    {
        return boostrapAutoInfoAlertElement.getText();
    }

    public String getBoostrapInfoMessage()
    {
        return boostrapInfoAlertElement.getText();
    }

    public boolean getBoostrapAutoSuccessStatus()
    {
        waitForElementToDisapire(boostrapAutoSuccessAlertElement);
        return boostrapAutoSuccessAlertElement.isDisplayed();
    }

    public boolean getBoostrapAutoWarningStatus()
    {
        waitForElementToDisapire(boostrapAutoWarningAlertElement);
        return boostrapAutoWarningAlertElement.isDisplayed();
    }

    public boolean getBoostrapAutoDangerStatus()
    {
        waitForElementToDisapire(boostrapAutoDangerAlertElement);
        return boostrapAutoDangerAlertElement.isDisplayed();
    }

    public boolean getBoostrapAutoInfoStatus()
    {
        waitForElementToDisapire(boostrapAutoInfoAlertElement);
        return boostrapAutoInfoAlertElement.isDisplayed();
    }

}
