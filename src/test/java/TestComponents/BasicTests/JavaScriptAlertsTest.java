package TestComponents.BasicTests;

import PageFactory.BasicPage.JavascriptAlertsPage;
import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class JavaScriptAlertsTest extends BaseTest {
    @Test
    public void alertBox_Click_Should_ShowAlertMessage_And_Accept()
    {
        //given
        JavascriptAlertsPage javaScriptAlertPage = new JavascriptAlertsPage(driver);
        //when
        javaScriptAlertPage.goToExercise();
        javaScriptAlertPage.clickJavaScriptAlertBoxButton();
        String alertmessage = javaScriptAlertPage.getAlertMessage();
        javaScriptAlertPage.clickJavaScriptAlertOkButton();

        //then
        Assert.assertEquals(alertmessage, "I am an alert box!");
    }
    @Test
    public void confirmBox_Click_Should_Show_ConfirmMessage_And_Accept()
    {
        //given
        JavascriptAlertsPage javascriptAlertsPage = new JavascriptAlertsPage(driver);
        SoftAssert softAssert = new SoftAssert();
        //when
        javascriptAlertsPage.goToExercise();
        javascriptAlertsPage.clickJavaScriptConfirmBoxButton();
        String alertmessage = javascriptAlertsPage.getAlertMessage();
        String message =
               javascriptAlertsPage
                       .clickJavaScriptConfirmOkButton()
                       .getJavaScriptConfirmMessage();
        //then
        softAssert.assertEquals(alertmessage, "Press a button!");
        softAssert.assertEquals(message, "You pressed OK!");
        softAssert.assertAll();
    }
    @Test
    public void confirmBox_Click_Should_Show_ConfirmMessage_And_Dismiss()
    {
        //given
        JavascriptAlertsPage javascriptAlertsPage = new JavascriptAlertsPage(driver);
        SoftAssert softAssert = new SoftAssert();
        //when
        javascriptAlertsPage.goToExercise();
        javascriptAlertsPage.clickJavaScriptConfirmBoxButton();
        String alertmessage = javascriptAlertsPage.getAlertMessage();
        String message =
                javascriptAlertsPage
                        .clickJavaScriptConfirmCancelButton()
                        .getJavaScriptConfirmMessage();
        //then
        softAssert.assertEquals(alertmessage, "Press a button!");
        softAssert.assertEquals(message, "You pressed Cancel!");
        softAssert.assertAll();
    }
    @Test
    public void promptBox_Click_Enter_Value_Should_Show_Message()
    {
        //given
        JavascriptAlertsPage javascriptAlertsPage = new JavascriptAlertsPage(driver);
        SoftAssert softAssert = new SoftAssert();
        //when
        javascriptAlertsPage.goToExercise();
        javascriptAlertsPage.clickJavaScriptPromptBoxButton();
        String alertmessage = javascriptAlertsPage.getAlertMessage();
        String message =
                javascriptAlertsPage
                        .sendJavaScriptPromptMessage()
                        .clickJavaScriptPromptOkButton()
                        .getJavaScriptPromptMessage();
        //then
        softAssert.assertEquals(alertmessage, "Please enter your name");
        softAssert.assertEquals(message, "You have entered 'XD' !");
        softAssert.assertAll();
    }

}
