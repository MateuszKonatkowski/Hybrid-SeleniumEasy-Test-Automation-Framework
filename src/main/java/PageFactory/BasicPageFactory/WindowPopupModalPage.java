package PageFactory.BasicPageFactory;

import Config.GlobalConsts;
import PageFactory.BasePage;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;

import Util.ExcelDataUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;


public class WindowPopupModalPage extends BasePage {

    WebDriver driver;

    public WindowPopupModalPage()
    {

    }

    public WindowPopupModalPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

	@FindBy(css="a[title='Follow @seleniumeasy on Twitter']")
    @CacheLookup
	private WebElement popupTwitterButtonElement;

	@FindBy(css="a[title='Follow @seleniumeasy on Facebook']")
    @CacheLookup
	private WebElement popupFacebookButtonElement;

	@FindBy(css=".two-windows a")
    @CacheLookup
	private WebElement popupFaceBookAndTwitterButtonElement;

	@FindBy(css="#followall")
    @CacheLookup
	private WebElement popupFollowAllButtonElement;



    private final String exerciseLevel = GlobalConsts.BASIC;
    private final String exercise = GlobalConsts.WINDOWS_POPUP;
    private final String data_path = GlobalConsts.WINDOWS_POPUP_DEMO_DATA_PATH;



    @DataProvider(name = "TestData")
    public Object[][] getData(Method method) throws IOException
    {
        return ExcelDataUtil.getData(method, data_path);
    }

    public void goToExercise()
    {
        goTo(exerciseLevel,exercise);
    }

    public WindowPopupModalPage clickTwitterButton()
    {
        popupTwitterButtonElement.click();
        return new WindowPopupModalPage(driver);
    }

    public WindowPopupModalPage clickFacebookButton()
    {
        popupFacebookButtonElement.click();
        return new WindowPopupModalPage(driver);
    }

    public WindowPopupModalPage clickTwitterAndFacebookButton()
    {
        popupFaceBookAndTwitterButtonElement.click();
        return new WindowPopupModalPage(driver);
    }

    public String getPopUpWidowsAddress()
    {
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentid = it.next();
        String childid = it.next();
        return driver.switchTo().window(childid).getCurrentUrl();
    }

}
