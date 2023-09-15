package TestComponents.BasicTests;

import PageFactory.BasicPage.CheckboxPage;
import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CheckboxDemoTest extends BaseTest {

    @Test
    public void checkBox_CLick_Should_Show_Message()
    {
        //given
        CheckboxPage checkboxPage = new CheckboxPage(driver);
        //when
        String message = "Success - Check box is checked";
        checkboxPage.goToExercise();
        String wynik = checkboxPage
                .clickCheckBox()
                .getCheckBoxMessage();
        //then
        Assert.assertEquals(wynik,message);
    }
    @Test
    public void checkBox_DoubleCLick_Should_Hide_Message()
    {
        //given
        CheckboxPage checkboxPage = new CheckboxPage(driver);
        String message = "";
        //when
        checkboxPage.goToExercise();
        String wynik = checkboxPage
                .doubelClickCheckBox()
                .getCheckBoxMessage();
        //then
        Assert.assertEquals(wynik,message);
    }
    @Test
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
    @Test
    public void checkBoxChecked_DoubleCLick_Should_Check_Checkbox()
    {
        //given
        CheckboxPage checkboxPage = new CheckboxPage(driver);
        //when
        checkboxPage.goToExercise();
        checkboxPage
                .doubelClickCheckBox();
        //then
        Assert.assertTrue(checkboxPage.getCheckBoxCheckedStatus());
    }
    @Test
    public void checkBoxDisable_Should_Be_Disable()
    {
        //given
        CheckboxPage checkboxPage = new CheckboxPage(driver);
        //when
        checkboxPage.goToExercise();
        //then
        Assert.assertFalse(checkboxPage.getCheckBoxDisabelStatus());
    }

    @Test
    public void multipleCheckBox_Check_All_Should_Change_Button_Name_And_Check_All()
    {
        //given
        CheckboxPage checkboxPage = new CheckboxPage(driver);
        SoftAssert softAssert = new SoftAssert();
        //when
        checkboxPage.goToExercise();
        checkboxPage
                .clickAllMultipleCheckBox()
                .getMultipleCheckBoxAllButtonValue();
        //then
        softAssert.assertEquals(checkboxPage.getMultipleCheckBoxAllButtonValue(),"Uncheck All");
        softAssert.assertEquals(checkboxPage.getMultipleCheckBoxIsCheckedStatus(),"true");
        softAssert.assertAll();
    }
    @Test
    public void multipleCheckBox_Click_MultipleCheckBoxAllButton_Should_Change_Button_Name_And_Check_All()
    {
        //given
        CheckboxPage checkboxPage = new CheckboxPage(driver);
        SoftAssert softAssert = new SoftAssert();
        //when
        checkboxPage.goToExercise();
        checkboxPage
                .clickAllMultipleCheckBox()
                .getMultipleCheckBoxAllButtonValue();
        //then
        softAssert.assertEquals(checkboxPage.getMultipleCheckBoxAllButtonValue(),"Uncheck All");
        softAssert.assertEquals(checkboxPage.getMultipleCheckBoxIsCheckedStatus(),"true");
        softAssert.assertAll();
    }
    @Test
    public void multipleCheckBox_Click_UncheckAll_Should_Change_Button_Name_And_Uncheck_All()
    {
        //given
        CheckboxPage checkboxPage = new CheckboxPage(driver);
        SoftAssert softAssert = new SoftAssert();
        //when
        checkboxPage.goToExercise();
        checkboxPage
                .doubleClickMultipleCheckBoxAllButton()
                .getMultipleCheckBoxAllButtonValue();
        //then
        softAssert.assertEquals(checkboxPage.getMultipleCheckBoxAllButtonValue(),"Check All");
        softAssert.assertEquals(checkboxPage.getMultipleCheckBoxIsCheckedStatus(),"false");
        softAssert.assertAll();
    }

}

