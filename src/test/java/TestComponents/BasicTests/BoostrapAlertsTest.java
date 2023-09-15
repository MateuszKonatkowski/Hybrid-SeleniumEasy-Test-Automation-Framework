package TestComponents.BasicTests;

import PageFactory.BasicPage.BoostrapAlertsPage;
import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BoostrapAlertsTest extends BaseTest {

    @Test
    public void boostrapAlert_Click_AutoSucces_Should_Show_Message_And_Disappear()
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
        softAssert.assertEquals(message,"I'm an autocloseable success message. I will hide in 5 seconds.");
        softAssert.assertFalse(boostrapAlertsPage.getBoostrapAutoSuccessStatus());
        softAssert.assertAll();
    }
    @Test
    public void boostrapAlert_Click_Succes_Should_Show_Message()
    {
        //given
        BoostrapAlertsPage boostrapAlertsPage = new BoostrapAlertsPage(driver);

        //when
        boostrapAlertsPage.goToExercise();
        String message = boostrapAlertsPage
                .clickBoostrapSuccessElement()
                .getBoostrapSuccessMessage();
        //then
        Assert.assertEquals(message,"×\nI'm a normal success message. To close use the appropriate button.");
;
    }
    @Test
    public void boostrapAlert_Click_AutoWarning_Should_Show_Message_And_Disappear()
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
        softAssert.assertEquals(message,"I'm an autocloseable warning message. I will hide in 3 seconds.");
        softAssert.assertFalse(boostrapAlertsPage.getBoostrapAutoWarningStatus());
        softAssert.assertAll();
    }
    @Test
    public void boostrapAlert_Click_Warning_Should_Show_Message()
    {
        //given
        BoostrapAlertsPage boostrapAlertsPage = new BoostrapAlertsPage(driver);
        SoftAssert softAssert = new SoftAssert();
        //when
        boostrapAlertsPage.goToExercise();
        String message = boostrapAlertsPage
                .clickBoostrapWarningElement()
                .getBoostrapWarningMessage();
        //then
        Assert.assertEquals(message,"×\nI'm a normal warning message. To close use the appropriate button.");

    }
    @Test
    public void boostrapAlert_Click_AutoDanger_Should_Show_Message_And_Disappear()
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
        softAssert.assertEquals(message,"I'm an autocloseable danger message. I will hide in 5 seconds.");
        softAssert.assertFalse(boostrapAlertsPage.getBoostrapAutoDangerStatus());
        softAssert.assertAll();
    }
    @Test
    public void boostrapAlert_Click_Danger_Should_Show_Message_And_Disappear()
    {
        //given
        BoostrapAlertsPage boostrapAlertsPage = new BoostrapAlertsPage(driver);
        SoftAssert softAssert = new SoftAssert();
        //when
        boostrapAlertsPage.goToExercise();
        String message = boostrapAlertsPage
                .clickBoostrapDangerElement()
                .getBoostrapDangerMessage();
        //then
        Assert.assertEquals(message,"×\nI'm a normal danger message. To close use the appropriate button.");

    }
    @Test
    public void boostrapAlert_Click_AutoInfo_Should_Show_Message_And_Disappear()
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
        softAssert.assertEquals(message,"I'm an autocloseable info message. I will hide in 6 seconds.");
        softAssert.assertFalse(boostrapAlertsPage.getBoostrapAutoInfoStatus());
        softAssert.assertAll();
    }
    @Test
    public void boostrapAlert_Click_Info_Should_Show_Message_And()
    {
        //given
        BoostrapAlertsPage boostrapAlertsPage = new BoostrapAlertsPage(driver);
        SoftAssert softAssert = new SoftAssert();
        //when
        boostrapAlertsPage.goToExercise();
        String message = boostrapAlertsPage
                .clickBoostrapInfoElement()
                .getBoostrapInfoMessage();
        //then
        Assert.assertEquals(message,"×\nI'm a normal info message. To close use the appropriate button.");

    }

}
