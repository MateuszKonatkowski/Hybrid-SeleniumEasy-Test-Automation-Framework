package TestComponents.BasicTests;

import PageFactory.BasicPageFactory.BoostrapModalsPage;
import TestComponents.BaseTest;
import Util.IRetryAnalyzerUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BoostrapModalsTest extends BaseTest {

    @Test(priority = 1,retryAnalyzer = IRetryAnalyzerUtil.class,groups = {"Smoke"},dataProvider = "TestData",dataProviderClass = BoostrapModalsPage.class,description = "singleModalClickData")
    public void singleModal_Click_Should_Show_Message_And_Disappear(String expected)
    {
        //when
        BoostrapModalsPage boostrapModalsPage = new BoostrapModalsPage(driver);
        SoftAssert softAssert = new SoftAssert();
        //given
        boostrapModalsPage.goToExercise();
        String message =boostrapModalsPage
                .clickSingleModalButton()
                .getSingleModalAlertMessage();
        boostrapModalsPage.acceptSingelModalAlert();
        //then
        softAssert.assertEquals(message,expected);
        softAssert.assertFalse(boostrapModalsPage.getSingelModalAlertStatus());
        softAssert.assertAll();
    }

    @Test(priority = 1,groups = {"Smoke"})
    public void multiModal_Click_Should_Show_Message_And_Disappear()
    {
        //when
        BoostrapModalsPage boostrapModalsPage = new BoostrapModalsPage(driver);
        //given
        boostrapModalsPage.goToExercise();
        boostrapModalsPage
                .clickMultipleModalButton()
                .acceptMultiModalAlert();
        //then
        Assert.assertFalse(boostrapModalsPage.getMultiModalAlertStatus());
    }

    @Test(priority = 2,dataProvider = "TestData",dataProviderClass = BoostrapModalsPage.class,description = "multiModalLunchClickData")
    public void multiModal_Lunch_Click_Should_Show_Message_And_Disappear(String expected)
    {
        //when
        BoostrapModalsPage boostrapModalsPage = new BoostrapModalsPage(driver);
        SoftAssert softAssert = new SoftAssert();
        //given
        boostrapModalsPage.goToExercise();
        String message = boostrapModalsPage
                .clickMultipleModalButton()
                .clickMultipleModalLunchButton()
                .getMultipleModalLunchMessage();
        boostrapModalsPage.clickMultipleModalLunchAcceptButton();
        //then
        softAssert.assertEquals(message,expected);
        softAssert.assertFalse(boostrapModalsPage.getMultiModalAlertStatus());
        softAssert.assertAll();
    }

}
