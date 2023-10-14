package PageFactory.IntermediatePageFactory;

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

public class AjaxFormSubmitPage extends BasePage {

    WebDriver driver;

    public AjaxFormSubmitPage()
    {

    }

    public AjaxFormSubmitPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    @FindBy(css = "#title")
    @CacheLookup
    private WebElement ajaxNameInputElement;

    @FindBy(css = "#description")
    @CacheLookup
    private WebElement ajaxCommentInputElement;

    @FindBy(css = "#btn-submit")
    @CacheLookup
    private WebElement ajaxSubmitButtonElement;

    @FindBy(css = "#submit-control")
    @CacheLookup
    private WebElement ajaxMessageElement;



    private final String exerciseLevel = GlobalConsts.INTERMEDIATE;
    private final String exercise = GlobalConsts.AJAX_FORM_SUBMIT;
    private final String data_path = GlobalConsts.AJAX_FORM_SUBMIT_DATA_PATH;



    @DataProvider(name = "TestData")
    public Object[][] getData(Method method) throws IOException {
        return ExcelDataUtil.getData(method, data_path);
    }

    public void goToExercise() {
        goTo(exerciseLevel, exercise);
    }

    public AjaxFormSubmitPage sendNameInputValue(String value) {
        ajaxNameInputElement.sendKeys(value);
        return new AjaxFormSubmitPage(driver);
    }

    public AjaxFormSubmitPage sendCommentInputValue(String value) {
        ajaxCommentInputElement.sendKeys(value);
        return new AjaxFormSubmitPage(driver);
    }

    public AjaxFormSubmitPage clickSubmitButtonButton() {
        ajaxSubmitButtonElement.click();
        return new AjaxFormSubmitPage(driver);
    }

    public String getAjaxExpectedMessage(String expected) {
        waitForElementTextAToBeEquals(ajaxMessageElement,expected);
        return ajaxMessageElement.getText();
    }

    public boolean getNameInputStatus(String styleValue)
    {
        return ajaxNameInputElement.getAttribute("style").equals(styleValue);
    }

}