package TestComponents.BasicTests;

import PageFactory.BasicPageFactory.BoostrapModalsPage;
import TestComponents.BaseTest;
import Util.IRetryAnalyzerUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BoostrapModalsTest extends BaseTest {

    @Test(retryAnalyzer = IRetryAnalyzerUtil.class,groups = {"Smoke"})
    public void singelModal_Click_Should_Show_Message_And_Disappear()
    {
        //when
        BoostrapModalsPage boostrapModalsPage = new BoostrapModalsPage(driver);
        SoftAssert softAssert = new SoftAssert();
        //given
        boostrapModalsPage.goToExercise();
        String message =boostrapModalsPage
                .clickSingelModalButton()
                .getSingelModalAlertMessage();
        boostrapModalsPage.acceptSingelModalAlert();
        //then
        softAssert.assertEquals(message,"This is the place where the content for the modal dialog displays");
        softAssert.assertFalse(boostrapModalsPage.getSingelModalAlertStatus());
        softAssert.assertAll();
    }

    @Test(groups = {"Smoke"},priority = 1)
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

    @Test
    public void multiModal_Lunch_Click_Should_Show_Message_And_Disappear()
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
        softAssert.assertEquals(message,"This is the place where the content for the modal dialog displays.");
        softAssert.assertFalse(boostrapModalsPage.getMultiModalAlertStatus());
        softAssert.assertAll();
    }

}
