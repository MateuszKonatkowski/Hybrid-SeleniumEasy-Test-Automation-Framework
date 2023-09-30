package TestComponents.BasicTests;

import PageFactory.BasicPageFactory.WindowPopupModalPage;
import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WindowsPopupDemoTest extends BaseTest {

    @Test
    public void popup_Twitter_Should_Have_Proper_Address()
    {
        //when
        WindowPopupModalPage windowPopupModalPage = new WindowPopupModalPage(driver);
        //given
        windowPopupModalPage.goToExercise();
        String message = windowPopupModalPage
                .clickTwitterButton()
                .getPopUpWidowsAddress();
        //then
        Assert.assertEquals(message,"https://twitter.com/i/flow/login?redirect_after_login=%2Fintent%2Ffollow%3Fscreen_name%3Dseleniumeasy");
    }

    @Test(groups = {"Smoke"})
    public void popup_Facebook_Should_Have_Proper_Address()
    {
        //when
        WindowPopupModalPage windowPopupModalPage = new WindowPopupModalPage(driver);
        //given
        windowPopupModalPage.goToExercise();
        String message = windowPopupModalPage
                .clickFacebookButton()
                .getPopUpWidowsAddress();
        //then
        Assert.assertEquals(message,"https://www.facebook.com/seleniumeasy");
    }

}
