package TestComponents.BasicTests;

import PageFactory.BasicPageFactory.BoostrapAlertsPage;
import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class BoostrapAlertsTest extends BaseTest {

    @Test(priority = 1,groups = {"Smoke"},dataProvider = "TestData",dataProviderClass = BoostrapAlertsPage.class,description = "boostrapAlertAutoSuccess")
    public void boostrapAlert_Click_AutoSuccess_Should_Show_Message_And_Disappear(String expected)
    {
        //given
        BoostrapAlertsPage boostrapAlertsPage = new BoostrapAlertsPage(driver);
        SoftAssert softAssert = new SoftAssert();
        //when
        boostrapAlertsPage.goToExercise();
        String message = boostrapAlertsPage
                .clickBoostrapAutoSuccessElement()
                .getBoostrapAutoSuccessMessage();
        //then
        softAssert.assertEquals(message,expected);
        softAssert.assertFalse(boostrapAlertsPage.getBoostrapAutoSuccessStatus());
        softAssert.assertAll();
    }

    @Test(priority = 1,groups = {"Smoke"},dataProvider = "TestData",dataProviderClass = BoostrapAlertsPage.class,description = "boostrapAlertSuccess")
    public void boostrapAlert_Click_Success_Should_Show_Message(String expected)
    {
        //given
        BoostrapAlertsPage boostrapAlertsPage = new BoostrapAlertsPage(driver);
        //when
        boostrapAlertsPage.goToExercise();
        String message = boostrapAlertsPage
                .clickBoostrapSuccessElement()
                .getBoostrapSuccessMessage();
        //then
        Assert.assertEquals(message,expected);
;
    }

    @Test(priority = 2,dataProvider = "TestData",dataProviderClass = BoostrapAlertsPage.class,description = "boostrapAlertAutoWarning")
    public void boostrapAlert_Click_AutoWarning_Should_Show_Message_And_Disappear(String expected)
    {
        //given
        BoostrapAlertsPage boostrapAlertsPage = new BoostrapAlertsPage(driver);
        SoftAssert softAssert = new SoftAssert();
        //when
        boostrapAlertsPage.goToExercise();
        String message = boostrapAlertsPage
                .clickBoostrapAutoWarningElement()
                .getBoostrapAutoWarningMessage();
        //then
        softAssert.assertEquals(message,expected);
        softAssert.assertFalse(boostrapAlertsPage.getBoostrapAutoWarningStatus());
        softAssert.assertAll();
    }

    @Test(priority = 4,dataProvider = "TestData",dataProviderClass = BoostrapAlertsPage.class,description = "boostrapAlertWarning")
    public void boostrapAlert_Click_Warning_Should_Show_Message(String expected)
    {
        //given
        BoostrapAlertsPage boostrapAlertsPage = new BoostrapAlertsPage(driver);
        //when
        boostrapAlertsPage.goToExercise();
        String message = boostrapAlertsPage
                .clickBoostrapWarningElement()
                .getBoostrapWarningMessage();
        //then
        Assert.assertEquals(message,expected);

    }

    @Test(priority = 3,groups = {"Smoke"},dataProvider = "TestData",dataProviderClass = BoostrapAlertsPage.class,description = "boostrapAlertAutoDanger")
    public void boostrapAlert_Click_AutoDanger_Should_Show_Message_And_Disappear(String expected)
    {
        //given
        BoostrapAlertsPage boostrapAlertsPage = new BoostrapAlertsPage(driver);
        SoftAssert softAssert = new SoftAssert();
        //when
        boostrapAlertsPage.goToExercise();
        String message = boostrapAlertsPage
                .clickBoostrapAutoDangerElement()
                .getBoostrapAutoDangerMessage();
        //then
        softAssert.assertEquals(message,expected);
        softAssert.assertFalse(boostrapAlertsPage.getBoostrapAutoDangerStatus());
        softAssert.assertAll();
    }

    @Test(priority = 4,dataProvider = "TestData",dataProviderClass = BoostrapAlertsPage.class,description = "boostrapAlertDanger")
    public void boostrapAlert_Click_Danger_Should_Show_Message_And_Disappear(String expected)
    {
        //given
        BoostrapAlertsPage boostrapAlertsPage = new BoostrapAlertsPage(driver);
        //when
        boostrapAlertsPage.goToExercise();
        String message = boostrapAlertsPage
                .clickBoostrapDangerElement()
                .getBoostrapDangerMessage();
        //then
        Assert.assertEquals(message,expected);

    }

    @Test(priority = 1,groups = {"Smoke"},dataProvider = "TestData",dataProviderClass = BoostrapAlertsPage.class,description = "boostrapAlertAutoInfo")
    public void boostrapAlert_Click_AutoInfo_Should_Show_Message_And_Disappear(String expected)
    {
        //given
        BoostrapAlertsPage boostrapAlertsPage = new BoostrapAlertsPage(driver);
        SoftAssert softAssert = new SoftAssert();
        //when
        boostrapAlertsPage.goToExercise();
        String message = boostrapAlertsPage
                .clickBoostrapAutoInfoElement()
                .getBoostrapAutoInfoMessage();
        //then
        softAssert.assertEquals(message,expected);
        softAssert.assertFalse(boostrapAlertsPage.getBoostrapAutoInfoStatus());
        softAssert.assertAll();
    }

    @Test(priority = 2,groups = {"Smoke"},dataProvider = "TestData",dataProviderClass = BoostrapAlertsPage.class,description = "boostrapAlertInfo")
    public void boostrapAlert_Click_Info_Should_Show_Message(String expected)
    {
        //given
        BoostrapAlertsPage boostrapAlertsPage = new BoostrapAlertsPage(driver);
        //when
        boostrapAlertsPage.goToExercise();
        String message = boostrapAlertsPage
                .clickBoostrapInfoElement()
                .getBoostrapInfoMessage();
        //then
        Assert.assertEquals(message,expected);
    }

}
