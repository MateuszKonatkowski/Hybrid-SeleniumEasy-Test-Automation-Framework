package TestComponents.BasicTests;

import PageFactory.BasicPageFactory.RadioButtonPage;
import TestComponents.BaseTest;
import Util.IRetryAnalyzerUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonsDemoTest extends BaseTest {

    @Test(priority = 2,dataProvider = "TestData",dataProviderClass = RadioButtonPage.class,description = "radioButtonClickData",retryAnalyzer = IRetryAnalyzerUtil.class)
    public void radioButton_ButtonClick_Should_Show_Message(String value,String expected)
    {
        //given
        RadioButtonPage radioButtonPage = new RadioButtonPage(driver);
        //when
        radioButtonPage.goToExercise();
        String message = radioButtonPage
                .checkOneRadioButton(value)
                .clickRadioButtonButton()
                .getDarioButtonMessage();
        //then
        Assert.assertEquals(message,expected);
    }

   @Test(priority = 2,dataProvider = "TestData",dataProviderClass = RadioButtonPage.class,description = "radioButtonClickSexData")
    public void groupRadioButton_ClickOnlySex_Should_Show_Message(String value,String expected)
   {
       //given
       RadioButtonPage radioButtonPage = new RadioButtonPage(driver);
       //when
       radioButtonPage.goToExercise();
       String message = radioButtonPage
               .clickGroupRadioButtonSex(value)
               .clickGroupRadioButtonButton()
               .getDarioGroupRadioButtonMessage();
       //then
       Assert.assertEquals(message,expected);
   }

   @Test(priority = 1,groups = {"Smoke"},dataProvider = "TestData",dataProviderClass = RadioButtonPage.class,description = "radioButtonClickAgeData")
    public void groupRadioButton_ClickOnlyAge_Should_Show_Message(String value,String expected)
   {
       //given
       RadioButtonPage radioButtonPage = new RadioButtonPage(driver);
       //when
       radioButtonPage.goToExercise();
       String message = radioButtonPage
              .clickGroupRadioButtonAge(value)
              .clickGroupRadioButtonButton()
              .getDarioGroupRadioButtonMessage();
       //then
       Assert.assertEquals(message,expected);
   }

   @Test(priority = 2 ,dataProvider = "TestData",dataProviderClass = RadioButtonPage.class,description = "radioButtonClickBothData")
    public void groupRadioButton_ClickBoth_Should_Show_Message(String value1,String value2, String expected)
   {
       //given
       RadioButtonPage radioButtonPage = new RadioButtonPage(driver);
       //when
       radioButtonPage.goToExercise();
       String message = radioButtonPage
               .clickGroupRadioButtonSex(value1)
               .clickGroupRadioButtonAge(value2)
               .clickGroupRadioButtonButton()
               .getDarioGroupRadioButtonMessage();
       //then
       Assert.assertEquals(message,expected);
   }

}
