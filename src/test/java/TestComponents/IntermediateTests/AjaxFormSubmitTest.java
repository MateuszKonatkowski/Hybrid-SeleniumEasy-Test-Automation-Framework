package TestComponents.IntermediateTests;

import PageFactory.BasicPageFactory.SimpleFormPage;
import PageFactory.IntermediatePageFactory.AjaxFormSubmitPage;
import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AjaxFormSubmitTest extends BaseTest {

    @Test(priority = 1,groups = {"Smoke"},dataProvider = "TestData",dataProviderClass = AjaxFormSubmitPage.class,description = "ajaxFormMessageData")
    public void ajaxForm_Enter_Data_Should_Show_Message(String value1, String value2, String expected1, String expected2)
    {
        //given
        AjaxFormSubmitPage ajaxFormSubmitPage = new AjaxFormSubmitPage(driver);
        SoftAssert softAssert = new SoftAssert();
        //when
        ajaxFormSubmitPage.goToExercise();
        String message = ajaxFormSubmitPage
                .sendNameInputValue(value1)
                .sendCommentInputValue(value2)
                .clickSubmitButtonButton()
                .getAjaxExpectedMessage(expected1);
        //then
        softAssert.assertEquals(message,expected1);
        softAssert.assertTrue(ajaxFormSubmitPage.getNameInputStatus(expected2));
        softAssert.assertAll();
    }


}
