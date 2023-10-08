package TestComponents.BasicTests;


import PageFactory.BasicPageFactory.WindowPopupModalPage;
import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WindowsPopupDemoTest extends BaseTest {

    @Test(priority = 2,dataProvider = "TestData",dataProviderClass = WindowPopupModalPage.class,description = "popupTwitterData")
    public void popup_Twitter_Should_Have_Proper_Address(String expected)
    {
        //when
        WindowPopupModalPage windowPopupModalPage = new WindowPopupModalPage(driver);
        //given
        windowPopupModalPage.goToExercise();
        String message = windowPopupModalPage
                .clickTwitterButton()
                .getPopUpWidowsAddress();
        //then
        Assert.assertEquals(message,expected);
    }

    @Test(priority = 1,groups = {"Smoke"},dataProvider = "TestData",dataProviderClass = WindowPopupModalPage.class,description = "popupFacebookData")
    public void popup_Facebook_Should_Have_Proper_Address(String expected)
    {
        //when
        WindowPopupModalPage windowPopupModalPage = new WindowPopupModalPage(driver);
        //given
        windowPopupModalPage.goToExercise();
        String message = windowPopupModalPage
                .clickFacebookButton()
                .getPopUpWidowsAddress();
        //then
        Assert.assertEquals(message,expected);
    }

}
