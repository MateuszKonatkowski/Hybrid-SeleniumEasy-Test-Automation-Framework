package TestComponents.BasicTests;

import PageFactory.BasicPage.WindowPopupModalPage;
import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WindowsPopupDemoTest extends BaseTest {

    @Test
    public void popup_Twitter_Should_Have_Proper_Adres()
    {
        //when
        WindowPopupModalPage windowPopupModalPage = new WindowPopupModalPage(driver);
        //given
        windowPopupModalPage.goToExercise();
        String message = windowPopupModalPage
                .clickTwitterButton()
                .getPopUpWidnowAdress();
        //then
        Assert.assertEquals(message,"https://twitter.com/i/flow/login?redirect_after_login=%2Fintent%2Ffollow%3Fscreen_name%3Dseleniumeasy");
    }
    @Test
    public void popup_Facebook_Should_Have_Proper_Adres()
    {
        //when
        WindowPopupModalPage windowPopupModalPage = new WindowPopupModalPage(driver);
        //given
        windowPopupModalPage.goToExercise();
        String message = windowPopupModalPage
                .clickFacebookButton()
                .getPopUpWidnowAdress();

        //then
        Assert.assertEquals(message,"https://www.facebook.com/seleniumeasy");
    }
}
