package PageFactory.BasicPageFactory;

import Config.GlobalConsts;
import PageFactory.BasicPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavascriptAlertsPage extends BasicPage {
    WebDriver driver;

    public JavascriptAlertsPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

	@FindBy(css="div[class='panel panel-primary']:first-of-type .btn")
    @CacheLookup
	private WebElement javaScriptAlertBoxButtonElement;

	@FindBy(css="div[class='panel panel-primary']:nth-of-type(2) .btn")
    @CacheLookup
	private WebElement javaScriptConfirmBoxButtonElement;

	@FindBy(css="div[class='panel panel-primary']:last-of-type .btn")
    @CacheLookup
	private WebElement javaScriptPromptBoxButtonElement;

	@FindBy(css="#confirm-demo")
    @CacheLookup
	private WebElement javaScriptConfirmBoxMessageElement;

    @FindBy(css="#prompt-demo")
    @CacheLookup
    private WebElement javaScriptPromptBoxMessageElement;



    private final String exerciseLevel = GlobalConsts.BASIC;
    private final String exercise = GlobalConsts.JAVASCRIPT_ALERTS;



    public void goToExercise()
    {
        goTo(exerciseLevel,exercise);
    }

    public JavascriptAlertsPage clickJavaScriptAlertBoxButton()
    {
        javaScriptAlertBoxButtonElement.click();
        return new JavascriptAlertsPage(driver);
    }

    public JavascriptAlertsPage clickJavaScriptConfirmBoxButton()
    {
        javaScriptConfirmBoxButtonElement.click();
        return new JavascriptAlertsPage(driver);
    }

    public JavascriptAlertsPage clickJavaScriptPromptBoxButton()
    {
        javaScriptPromptBoxButtonElement.click();
        return new JavascriptAlertsPage(driver);
    }

    public String getAlertMessage()
    {
        return driver.switchTo().alert().getText();
    }

    public void  clickJavaScriptAlertOkButton()
    {
        driver.switchTo().alert().accept();
    }

    public JavascriptAlertsPage clickJavaScriptConfirmOkButton()
    {
        driver.switchTo().alert().accept();
        return new JavascriptAlertsPage(driver);
    }

    public JavascriptAlertsPage  clickJavaScriptConfirmCancelButton()
    {
        driver.switchTo().alert().dismiss();
        return new JavascriptAlertsPage(driver);
    }

    public JavascriptAlertsPage clickJavaScriptPromptCancelButton()
    {
        driver.switchTo().alert().dismiss();
        return new JavascriptAlertsPage(driver);
    }

    public JavascriptAlertsPage clickJavaScriptPromptOkButton()
    {
        driver.switchTo().alert().accept();
        return new JavascriptAlertsPage(driver);
    }

    public JavascriptAlertsPage  sendJavaScriptPromptMessage(String message)
    {
        driver.switchTo().alert().sendKeys(message);
        return new JavascriptAlertsPage(driver);
    }

    public String getJavaScriptConfirmMessage()
    {
        return javaScriptConfirmBoxMessageElement.getText();
    }

    public String getJavaScriptPromptMessage()
    {
        return javaScriptPromptBoxMessageElement.getText();
    }

}
