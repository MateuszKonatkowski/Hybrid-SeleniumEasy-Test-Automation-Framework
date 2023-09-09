package TestComponents;

import PageFactory.CheckboxDemoPage;
import org.asynchttpclient.util.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CheckboxDemo extends BaseTest{

    @Test
    public void checkBox_CLick_Should_Show_Message()
    {
        //given
        CheckboxDemoPage checkboxDemoPage = new CheckboxDemoPage(driver);
        //when
        String message = "Success - Check box is checked";
        checkboxDemoPage.goToExercise();
        String wynik = checkboxDemoPage
                .clickCheckBox()
                .getCheckBoxMessage();
        //then
        Assert.assertEquals(wynik,message);
    }
    @Test
    public void checkBox_DoubleCLick_Should_Hide_Message()
    {
        //given
        CheckboxDemoPage checkboxDemoPage = new CheckboxDemoPage(driver);
        String message = "";
        //when
        checkboxDemoPage.goToExercise();
        String wynik = checkboxDemoPage
                .doubelClickCheckBox()
                .getCheckBoxMessage();
        //then
        Assert.assertEquals(wynik,message);
    }
    @Test
    public void checkBoxChecked_CLick_Should_Unchecked_Checkbox()
    {
        //given
        CheckboxDemoPage checkboxDemoPage = new CheckboxDemoPage(driver);
        //when
        checkboxDemoPage.goToExercise();
        checkboxDemoPage
                .clickCheckBoxChecked();
        //then
        Assert.assertFalse(checkboxDemoPage.getCheckBoxCheckedStatus());
    }
    @Test
    public void checkBoxChecked_DoubleCLick_Should_Check_Checkbox()
    {
        //given
        CheckboxDemoPage checkboxDemoPage = new CheckboxDemoPage(driver);
        //when
        checkboxDemoPage.goToExercise();
        checkboxDemoPage
                .doubelClickCheckBox();
        //then
        Assert.assertTrue(checkboxDemoPage.getCheckBoxCheckedStatus());
    }
    @Test
    public void checkBoxDisable_Should_Be_Disable()
    {
        //given
        CheckboxDemoPage checkboxDemoPage = new CheckboxDemoPage(driver);
        //when
        checkboxDemoPage.goToExercise();

        //then
        Assert.assertFalse(checkboxDemoPage.getCheckBoxDisabelStatus());
    }

    @Test
    public void multipleCheckBox_Check_All_Should_Change_Button_Name_And_Check_All()
    {
        //given
        CheckboxDemoPage checkboxDemoPage = new CheckboxDemoPage(driver);
        SoftAssert softAssert = new SoftAssert();
        //when
        checkboxDemoPage.goToExercise();
        checkboxDemoPage
                .clickAllMultipleCheckBox()
                .getMultipleCheckBoxAllButtonValue();
        //then
        softAssert.assertEquals(checkboxDemoPage.getMultipleCheckBoxAllButtonValue(),"Uncheck All");
        softAssert.assertEquals(checkboxDemoPage.getMultipleCheckBoxIsCheckedStatus(),"true");
        softAssert.assertAll();
    }
    @Test
    public void multipleCheckBox_Click_MultipleCheckBoxAllButton_Should_Change_Button_Name_And_Check_All()
    {
        //given
        CheckboxDemoPage checkboxDemoPage = new CheckboxDemoPage(driver);
        SoftAssert softAssert = new SoftAssert();
        //when
        checkboxDemoPage.goToExercise();
        checkboxDemoPage
                .clickAllMultipleCheckBox()
                .getMultipleCheckBoxAllButtonValue();
        //then
        softAssert.assertEquals(checkboxDemoPage.getMultipleCheckBoxAllButtonValue(),"Uncheck All");
        softAssert.assertEquals(checkboxDemoPage.getMultipleCheckBoxIsCheckedStatus(),"true");
        softAssert.assertAll();
    }
    @Test
    public void multipleCheckBox_Click_UncheckAll_Should_Change_Button_Name_And_Uncheck_All()
    {
        //given
        CheckboxDemoPage checkboxDemoPage = new CheckboxDemoPage(driver);
        SoftAssert softAssert = new SoftAssert();
        //when
        checkboxDemoPage.goToExercise();
        checkboxDemoPage
                .doubleClickMultipleCheckBoxAllButton()
                .getMultipleCheckBoxAllButtonValue();
        //then
        softAssert.assertEquals(checkboxDemoPage.getMultipleCheckBoxAllButtonValue(),"Check All");
        softAssert.assertEquals(checkboxDemoPage.getMultipleCheckBoxIsCheckedStatus(),"false");
        softAssert.assertAll();
    }

}

