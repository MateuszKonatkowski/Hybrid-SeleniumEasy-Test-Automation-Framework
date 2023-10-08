package TestComponents.BasicTests;

import PageFactory.BasicPageFactory.JavascriptAlertsPage;

import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class JavaScriptAlertsTest extends BaseTest {

    @Test(priority = 1,groups = {"Smoke"},dataProvider = "TestData",dataProviderClass = JavascriptAlertsPage.class,description = "alertBoxClickData")
    public void alertBox_Click_Should_ShowAlertMessage_And_Accept(String expected)
    {
        //given
        JavascriptAlertsPage javaScriptAlertPage = new JavascriptAlertsPage(driver);
        //when
        javaScriptAlertPage.goToExercise();
        javaScriptAlertPage.clickJavaScriptAlertBoxButton();
        String alertMessage = javaScriptAlertPage.getAlertMessage();
        javaScriptAlertPage.clickJavaScriptAlertOkButton();
        //then
        Assert.assertEquals(alertMessage, expected);
    }

    @Test(priority = 3,dataProvider = "TestData",dataProviderClass = JavascriptAlertsPage.class,description = "confirmBoxClickAcceptData")
    public void confirmBox_Click_Should_Show_ConfirmMessage_And_Accept(String expected1,String expected2)
    {
        //given
        JavascriptAlertsPage javascriptAlertsPage = new JavascriptAlertsPage(driver);
        SoftAssert softAssert = new SoftAssert();
        //when
        javascriptAlertsPage.goToExercise();
        javascriptAlertsPage.clickJavaScriptConfirmBoxButton();
        String alertMessage = javascriptAlertsPage.getAlertMessage();
        String message =
               javascriptAlertsPage
                       .clickJavaScriptConfirmOkButton()
                       .getJavaScriptConfirmMessage();
        //then
        softAssert.assertEquals(alertMessage, expected1);
        softAssert.assertEquals(message, expected2);
        softAssert.assertAll();
    }

    @Test(priority = 2,dataProvider = "TestData",dataProviderClass = JavascriptAlertsPage.class,description = "confirmBoxClickDismissData")
    public void confirmBox_Click_Should_Show_ConfirmMessage_And_Dismiss(String expected1,String expected2)
    {
        //given
        JavascriptAlertsPage javascriptAlertsPage = new JavascriptAlertsPage(driver);
        SoftAssert softAssert = new SoftAssert();
        //when
        javascriptAlertsPage.goToExercise();
        javascriptAlertsPage.clickJavaScriptConfirmBoxButton();
        String alertMessage = javascriptAlertsPage.getAlertMessage();
        String message =
                javascriptAlertsPage
                        .clickJavaScriptConfirmCancelButton()
                        .getJavaScriptConfirmMessage();
        //then
        softAssert.assertEquals(alertMessage, expected1);
        softAssert.assertEquals(message, expected2);
        softAssert.assertAll();
    }

    @Test(priority = 1,groups = {"Smoke"},dataProvider = "TestData",dataProviderClass = JavascriptAlertsPage.class,description = "promptBoxClickData")
    public void promptBox_Click_Enter_Value_Should_Show_Message(String value, String expected1,String expected2)
    {
        //given
        JavascriptAlertsPage javascriptAlertsPage = new JavascriptAlertsPage(driver);
        SoftAssert softAssert = new SoftAssert();
        //when
        javascriptAlertsPage.goToExercise();
        javascriptAlertsPage.clickJavaScriptPromptBoxButton();
        String alertMessage = javascriptAlertsPage.getAlertMessage();
        String message =
                javascriptAlertsPage
                        .sendJavaScriptPromptMessage(value)
                        .clickJavaScriptPromptOkButton()
                        .getJavaScriptPromptMessage();
        //then
        softAssert.assertEquals(alertMessage, expected1);
        softAssert.assertEquals(message, expected2);
        softAssert.assertAll();
    }

}
