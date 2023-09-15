package TestComponents.BasicTests;

import PageFactory.BasicPage.SimpelFormPage;
import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleFormDemoTest extends BaseTest {



    @Test
    public void singelInput_Enter_Any_Data_Should_Show_Message() {
        //given
        SimpelFormPage simpel = new SimpelFormPage(driver);
        String message = "Mateusz";
        //when
        simpel.goToExercise();
        String wynik = simpel
                .sendSingelInputValue(message)
                .clickSingelInputButton()
                .getSingleInputMessage();
        //then
        Assert.assertEquals(wynik,message);
    }
    @Test
    public void singelInput_Not_Entering_Any_Data_Should_Show_No_Message() {
        //given
        SimpelFormPage simpel = new SimpelFormPage(driver);
        String message = "";
        //when
        simpel.goToExercise();
        String wynik = simpel
                .sendSingelInputValue("")
                .clickSingelInputButton()
                .getSingleInputMessage();
        //then
        Assert.assertEquals(wynik,"");
    }
    @Test
    public void doubleInput_Enter_Double_Number_Should_Show_Sum()
    {
        //give
        SimpelFormPage simpelFormPage = new SimpelFormPage(driver);
        String value1="1234";
        String value2="4321";
        //when
        simpelFormPage.goToExercise();
        String wynik = simpelFormPage
                .sendDoubellInputValue(value1,value2)
                .clickDobuelInputValue()
                .getDobuelInputMessage();
        //then
        System.out.println(wynik);
        Assert.assertEquals(wynik,"5555");

    }
    @Test
    public void doubleInput_Enter_Single_Number_Should_Show_Number()
    {
        //give
        SimpelFormPage simpelFormPage = new SimpelFormPage(driver);
        String value1="1234";
        String value2="";
        //when
        simpelFormPage.goToExercise();
        String wynik = simpelFormPage
                .sendDoubellInputValue(value1,value2)
                .clickDobuelInputValue()
                .getDobuelInputMessage();
        //then
        System.out.println(wynik);
        Assert.assertEquals(wynik,"1234");

    }
    @Test
    public void doubleInput_Enter_Single_Text_Should_Show_Error()
    {
        //give
        SimpelFormPage simpelFormPage = new SimpelFormPage(driver);
        String value1="Mateusz";
        String value2="";
        //when
        simpelFormPage.goToExercise();
        String wynik = simpelFormPage
                .sendDoubellInputValue(value1,value2)
                .clickDobuelInputValue()
                .getDobuelInputMessage();
        //then
        System.out.println(wynik);
        Assert.assertEquals(wynik,"NaN");

    }
    @Test
    public void doubleInput_Enter_No_Data_Should_Show_Error()
    {
        //give
        SimpelFormPage simpelFormPage = new SimpelFormPage(driver);
        String value1="";
        String value2="";
        //when
        simpelFormPage.goToExercise();
        String wynik = simpelFormPage
                .sendDoubellInputValue(value1,value2)
                .clickDobuelInputValue()
                .getDobuelInputMessage();
        //then
        System.out.println(wynik);
        Assert.assertEquals(wynik,"NaN");

    }
}
