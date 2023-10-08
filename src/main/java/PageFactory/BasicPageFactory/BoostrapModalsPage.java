package PageFactory.BasicPageFactory;

import Config.GlobalConsts;
import PageFactory.BasePage;
import Util.ExcelDataUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.lang.reflect.Method;

public class BoostrapModalsPage extends BasePage {

    WebDriver driver;

    public BoostrapModalsPage()
    {

    }

    public BoostrapModalsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

	@FindBy(css="a[href='#myModal0']")
    @CacheLookup
	private WebElement singleModalButtonElement;

	@FindBy(css="a[href='#myModal']")
    @CacheLookup
	private WebElement multipleModalButtonElement;

    @FindBy(css="#myModal0")
    @CacheLookup
    private WebElement singleModalAlertElement;

    @FindBy(css="#myModal0 .modal-body")
    @CacheLookup
    private WebElement singleModalAlertMessageElement;

	@FindBy(css="#myModal0 .btn-primary")
    @CacheLookup
	private WebElement singleModalAlertAcceptElement;

	@FindBy(css="a[href='#myModal2']")
    @CacheLookup
	private WebElement multiModalLunchButtonElement;

	@FindBy(css="#myModal a[onclick='history.go(0)']")
    @CacheLookup
	private WebElement multiModalAlertAcceptElement;

	@FindBy(css="#myModal .modal-content")
    @CacheLookup
	private WebElement multiModalAlertElement;;

    @FindBy(css="#myModal2 .modal-body")
    @CacheLookup
    private WebElement multipleModalLunchAlertMessageElement;

	@FindBy(css="#myModal2 .btn-primary")
    @CacheLookup
	private WebElement multipleModalLunchAcceptButtonElement;



    private final String exerciseLevel = GlobalConsts.BASIC;
    private final String exercise = GlobalConsts.BOOSTRAP_MODALS;
    private final String data_path = GlobalConsts.BOOSTRAP_MODALS_DATA_PATH;



    @DataProvider(name = "TestData")
    public Object[][] getData(Method method) throws IOException
    {
        return ExcelDataUtil.getData(method,data_path);
    }

    public void goToExercise()
    {
        goTo(exerciseLevel,exercise);
    }

    public BoostrapModalsPage clickSingelModalButton()
    {
        singleModalButtonElement.click();
        return new BoostrapModalsPage(driver);
    }

    public BoostrapModalsPage clickMultipleModalButton()
    {
        multipleModalButtonElement.click();
        return new BoostrapModalsPage(driver);
    }

    public String getSingelModalAlertMessage()
    {
        waitForElementVisibility(singleModalAlertElement);
        return singleModalAlertMessageElement.getText();
    }

    public BoostrapModalsPage acceptSingelModalAlert()
    {
        singleModalAlertAcceptElement.click();
        return new BoostrapModalsPage(driver);
    }

    public boolean getSingelModalAlertStatus()
    {
        waitForElementToDisappear(singleModalAlertMessageElement);
        return singleModalAlertMessageElement.isDisplayed();
    }

    public BoostrapModalsPage acceptMultiModalAlert()
    {
        waitForElementVisibility(multiModalAlertElement);
        multiModalAlertAcceptElement.click();
        return new BoostrapModalsPage(driver);
    }

    public boolean getMultiModalAlertStatus()
    {
        waitForElementToDisappear(multiModalAlertElement);
        return multiModalAlertElement.isDisplayed();
    }

    public BoostrapModalsPage clickMultipleModalLunchButton()
    {
        waitForElementVisibility(multiModalLunchButtonElement);
        multiModalLunchButtonElement.click();
        return new BoostrapModalsPage(driver);
    }

    public String getMultipleModalLunchMessage()
    {
        waitForElementVisibility(multipleModalLunchAlertMessageElement);
        return multipleModalLunchAlertMessageElement.getText();
    }

    public BoostrapModalsPage clickMultipleModalLunchAcceptButton()
    {
        waitForElementVisibility(multipleModalLunchAcceptButtonElement);
        multipleModalLunchAcceptButtonElement.click();
        return new BoostrapModalsPage(driver);
    }

}
