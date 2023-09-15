package PageFactory.BasicPage;

import PageFactory.AbstractPage;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class WindowPopupModalPage extends AbstractPage {
    WebDriver driver; //Driver
    public WindowPopupModalPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
	@FindBy(css="a[title='Follow @seleniumeasy on Twitter']")
	private WebElement popupTwitterButtonElement;
	@FindBy(css="a[title='Follow @seleniumeasy on Facebook']")
	private WebElement popupFacebookButtonElement;
	@FindBy(css=".two-windows a")
	private WebElement popupFaceBookAndTwitterButtonElement;
	@FindBy(css="#followall")
	private WebElement popupFollowAllButtonElement;
    private final String exerciseLevel = "basic_example";
    private final String exercise = "Window Popup Modal";


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
    public String getPopUpWidnowAdress()
    {
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentid = it.next();
        String childid = it.next();
        return driver.switchTo().window(childid).getCurrentUrl();
    }




}
