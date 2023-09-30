package TestComponents.BasicTests;

import PageFactory.BasicPageFactory.JavascriptAlertsPage;
import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class JavaScriptAlertsTest extends BaseTest {

    @Test(groups = {"Smoke"})
    public void alertBox_Click_Should_ShowAlertMessage_And_Accept()
    {
        //given
        JavascriptAlertsPage javaScriptAlertPage = new JavascriptAlertsPage(driver);
        //when
        javaScriptAlertPage.goToExercise();
        javaScriptAlertPage.clickJavaScriptAlertBoxButton();
        String alertMessage = javaScriptAlertPage.getAlertMessage();
        javaScriptAlertPage.clickJavaScriptAlertOkButton();
        //then
        Assert.assertEquals(alertMessage, "I am an alert box!");
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
        String alertMessage = javascriptAlertsPage.getAlertMessage();
        String message =
               javascriptAlertsPage
                       .clickJavaScriptConfirmOkButton()
                       .getJavaScriptConfirmMessage();
        //then
        softAssert.assertEquals(alertMessage, "Press a button!");
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
        String alertMessage = javascriptAlertsPage.getAlertMessage();
        String message =
                javascriptAlertsPage
                        .clickJavaScriptConfirmCancelButton()
                        .getJavaScriptConfirmMessage();
        //then
        softAssert.assertEquals(alertMessage, "Press a button!");
        softAssert.assertEquals(message, "You pressed Cancel!");
        softAssert.assertAll();
    }

    @Test(groups = {"Smoke"})
    public void promptBox_Click_Enter_Value_Should_Show_Message()
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
                        .sendJavaScriptPromptMessage("XD")
                        .clickJavaScriptPromptOkButton()
                        .getJavaScriptPromptMessage();
        //then
        softAssert.assertEquals(alertMessage, "Please enter your name");
        softAssert.assertEquals(message, "You have entered 'XD' !");
        softAssert.assertAll();
    }

}
