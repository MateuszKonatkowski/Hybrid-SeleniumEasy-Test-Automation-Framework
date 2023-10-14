package TestComponents.IntermediateTests;

import PageFactory.IntermediatePageFactory.BootstrapListBoxPage;
import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BoostrapListBoxTest extends BaseTest {

    @Test(priority = 1,dataProvider = "TestData",dataProviderClass = BootstrapListBoxPage.class,description = "boostrapListLeftALLData")
    public void boostrapList_Left_SelectAll_And_Move_Should_Move_All_Elements(String value, String expected1, String expected2)
    {
        //when
        BootstrapListBoxPage bootstrapListBoxPage = new BootstrapListBoxPage(driver);
        SoftAssert softAssert = new SoftAssert();
        //given
        bootstrapListBoxPage.goToExercise();
        bootstrapListBoxPage
                .sendLeftSearchInputValue(value)
                .clickLeftSelectAllButtonButton()
                .clickMoveRightButtonButton();
        //then
        softAssert.assertEquals(bootstrapListBoxPage.getLeftValuesCount(),expected1);
        softAssert.assertEquals(bootstrapListBoxPage.getRightValuesCount(),expected2);
        softAssert.assertAll();
    }

    @Test(priority = 2,dataProvider = "TestData",dataProviderClass = BootstrapListBoxPage.class,description = "boostrapListRightALLData")
    public void boostrapList_Right_SelectAll_And_Move_Should_Move_All_Elements(String value, String expected1, String expected2)
    {
        //when
        BootstrapListBoxPage bootstrapListBoxPage = new BootstrapListBoxPage(driver);
        SoftAssert softAssert = new SoftAssert();
        //given
        bootstrapListBoxPage.goToExercise();
        bootstrapListBoxPage
                .sendRightSearchInputValue(value)
                .clickRightSelectAllButtonButton()
                .clickMoveLeftButtonButton();
        //then
        softAssert.assertEquals(bootstrapListBoxPage.getLeftValuesCount(),expected1);
        softAssert.assertEquals(bootstrapListBoxPage.getRightValuesCount(),expected2);
        softAssert.assertAll();
    }

    @Test(priority = 3,dataProvider = "TestData",dataProviderClass = BootstrapListBoxPage.class,description = "boostrapListLeftElementData")
    public void boostrapList_Left_Select_Element_And_Move_Should_Move_Element(String value1,String value2, String  expected)
    {
        //when
        BootstrapListBoxPage bootstrapListBoxPage = new BootstrapListBoxPage(driver);
        //given
        bootstrapListBoxPage.goToExercise();
        bootstrapListBoxPage
                .sendLeftSearchInputValue(value1)
                .selectLeftValuesValue(value2)
                .clickMoveRightButtonButton();

        //then
        Assert.assertTrue(bootstrapListBoxPage.getLeftValueToRightStatus(expected));
    }

    @Test(priority = 1,dataProvider = "TestData",dataProviderClass = BootstrapListBoxPage.class,description = "boostrapListRightElementData")
    public void boostrapList_Right_Select_Element_And_Move_Should_Move_Element(String value1,String value2, String  expected)
    {
        //when
        BootstrapListBoxPage bootstrapListBoxPage = new BootstrapListBoxPage(driver);
        //given
        bootstrapListBoxPage.goToExercise();
        bootstrapListBoxPage
                .sendRightSearchInputValue(value1)
                .selectRightValuesValue(value2)
                .clickMoveLeftButtonButton();

        //then
        Assert.assertTrue(bootstrapListBoxPage.getRightValueToLeftStatus(expected));
    }
}
