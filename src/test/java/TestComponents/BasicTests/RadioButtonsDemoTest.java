package TestComponents.BasicTests;

import PageFactory.BasicPage.RadioButtonPage;
import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonsDemoTest extends BaseTest {

    @Test
    public void radioButton_ButtonClick_Should_Show_Message()
    {
        //given
        RadioButtonPage radioButtonPage = new RadioButtonPage(driver);
        //when
        radioButtonPage.goToExercise();
        String message = radioButtonPage
                .checkOneRadioButton()
                .clickRadioButtonButton()
                .getDarioButtonMessage();
        //then
        Assert.assertEquals(message,"Radio button 'Male' is checked");
    }
   @Test
    public void radioButton_NoButtonClick_Should_Show_Message()
   {
       //given
        RadioButtonPage radioButtonPage = new RadioButtonPage(driver);
       //when
       radioButtonPage.goToExercise();
       String message = radioButtonPage
             .clickRadioButtonButton()
             .getDarioButtonMessage();
       //then
       Assert.assertEquals(message,"Radio button is Not checked");

   }
   @Test
    public void groupRadioButton_ClickOnlySex_Should_Show_Message()
   {
       //given
       RadioButtonPage radioButtonPage = new RadioButtonPage(driver);
       //when
       radioButtonPage.goToExercise();
       String message = radioButtonPage
               .clickGroupRadioButtonSex()
               .clickGroupRadioButtonButton()
               .getDarioGroupRadioButtonMessage();
       //then
       Assert.assertEquals(message,"Sex : Male\nAge group:");
   }
   @Test
    public void groupRadioButton_ClickOnlyAge_Should_Show_Message()
   {
       //given
       RadioButtonPage radioButtonPage = new RadioButtonPage(driver);
       //when
       radioButtonPage.goToExercise();
       String message = radioButtonPage
              .clickGroupRadioButtonAge()
              .clickGroupRadioButtonButton()
              .getDarioGroupRadioButtonMessage();
       //then
       Assert.assertEquals(message,"Sex :\nAge group: 0 - 5");
   }
   @Test
    public void groupRadioButton_ClickBoth_Should_Show_Message()
   {
       //given
       RadioButtonPage radioButtonPage = new RadioButtonPage(driver);
       //when
       radioButtonPage.goToExercise();
       String message = radioButtonPage
               .clickGroupRadioButtonSex()
               .clickGroupRadioButtonAge()
               .clickGroupRadioButtonButton()
               .getDarioGroupRadioButtonMessage();
       //then
       Assert.assertEquals(message,"Sex : Male\nAge group: 0 - 5");
   }
}
