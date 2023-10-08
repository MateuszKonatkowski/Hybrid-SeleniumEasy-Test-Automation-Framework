package TestComponents.BasicTests;

import PageFactory.BasicPageFactory.CheckboxPage;

import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CheckboxDemoTest extends BaseTest {

    @Test(priority = 1,dataProvider = "TestData",dataProviderClass = CheckboxPage.class,description = "checkBoxClickData")
    public void checkBox_CLick_Should_Show_Message(String expected)
    {
        //given
        CheckboxPage checkboxPage = new CheckboxPage(driver);
        //when
        checkboxPage.goToExercise();
        String result = checkboxPage
                .clickCheckBox()
                .getCheckBoxMessage();
        //then
        Assert.assertEquals(result,expected);
    }

    @Test(priority = 3)
    public void checkBox_DoubleCLick_Should_Hide_Message()
    {
        //given
        CheckboxPage checkboxPage = new CheckboxPage(driver);
        //when
        checkboxPage.goToExercise();
        Boolean result = checkboxPage
                .doubleClickCheckBox()
                .getCheckBoxStatus();
        //then
        Assert.assertFalse(result);
    }

    @Test(priority = 2)
    public void checkBoxChecked_CLick_Should_Unchecked_Checkbox()
    {
        //given
        CheckboxPage checkboxPage = new CheckboxPage(driver);
        //when
        checkboxPage.goToExercise();
        checkboxPage
                .clickCheckBoxChecked();
        //then
        Assert.assertFalse(checkboxPage.getCheckBoxCheckedStatus());
    }

    @Test(priority = 3)
    public void checkBoxChecked_DoubleCLick_Should_Check_Checkbox()
    {
        //given
        CheckboxPage checkboxPage = new CheckboxPage(driver);
        //when
        checkboxPage.goToExercise();
        checkboxPage
                .doubleClickCheckBox();
        //then
        Assert.assertTrue(checkboxPage.getCheckBoxCheckedStatus());
    }

    @Test(priority = 4)
    public void checkBoxDisable_Should_Be_Disable()
    {
        //given
        CheckboxPage checkboxPage = new CheckboxPage(driver);
        //when
        checkboxPage.goToExercise();
        //then
        Assert.assertFalse(checkboxPage.getCheckBoxDisableStatus());
    }

    @Test(priority = 1,dataProvider = "TestData",dataProviderClass = CheckboxPage.class,description = "multipleCheckBoxCheckAllData")
    public void multipleCheckBox_Check_All_Should_Change_Button_Name_And_CheckAll(String expected1,String expected2)
    {
        //given
        CheckboxPage checkboxPage = new CheckboxPage(driver);
        SoftAssert softAssert = new SoftAssert();
        //when
        checkboxPage.goToExercise();
        String result = checkboxPage
                .clickAllMultipleCheckBox()
                .getMultipleCheckBoxAllButtonValue();
        //then
        softAssert.assertEquals(result,expected1);
        softAssert.assertEquals(checkboxPage.getMultipleCheckBoxIsCheckedStatus(),expected2);
        softAssert.assertAll();
    }

    @Test(priority = 1,groups = {"Smoke"},dataProvider = "TestData",dataProviderClass = CheckboxPage.class,description = "multipleCheckBoxClickButtonData")
    public void multipleCheckBox_Click_MultipleCheckBoxAllButton_Should_Change_Button_Name_And_CheckAll(String expected1,String expected2)
    {
        //given
        CheckboxPage checkboxPage = new CheckboxPage(driver);
        SoftAssert softAssert = new SoftAssert();
        //when
        checkboxPage.goToExercise();
        String result = checkboxPage
                .clickAllMultipleCheckBox()
                .getMultipleCheckBoxAllButtonValue();
        //then
        softAssert.assertEquals(result,expected1);
        softAssert.assertEquals(checkboxPage.getMultipleCheckBoxIsCheckedStatus(),expected2);
        softAssert.assertAll();
    }

    @Test(priority = 2,dataProvider = "TestData",dataProviderClass = CheckboxPage.class,description = "multipleCheckBoxClickUnAllData")
    public void multipleCheckBox_Click_UncheckAll_Should_Change_Button_Name_And_UncheckAll(String expected1,String expected2)
    {
        //given
        CheckboxPage checkboxPage = new CheckboxPage(driver);
        SoftAssert softAssert = new SoftAssert();
        //when
        checkboxPage.goToExercise();
        String result = checkboxPage
                .doubleClickMultipleCheckBoxAllButton()
                .getMultipleCheckBoxAllButtonValue();
        //then
        softAssert.assertEquals(result,expected1);
        softAssert.assertEquals(checkboxPage.getMultipleCheckBoxIsCheckedStatus(),expected2);
        softAssert.assertAll();
    }

}

