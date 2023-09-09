package TestComponents;

import PageFactory.SimpelFormDemoPage;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleFormDemo extends BaseTest{



    @Test
    public void singelInput_Enter_Any_Data_Should_Show_Message() {
        //given
        SimpelFormDemoPage simpel = new SimpelFormDemoPage(driver);
        String message = "XD";
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
        SimpelFormDemoPage simpel = new SimpelFormDemoPage(driver);
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
        SimpelFormDemoPage simpelFormDemoPage = new SimpelFormDemoPage(driver);
        String value1="1234";
        String value2="4321";
        //when
        simpelFormDemoPage.goToExercise();
        String wynik = simpelFormDemoPage
                .sendDoubellInputValue(value1,value2)
                .clickDobuelInputValue()
                .getDobuelInputMessage();
        //then
        System.out.println(wynik);
        Assert.assertEquals(wynik,"5555");

    }
    @Test
    public void doubleInput_Enter_Singel_Number_Should_Show_Number()
    {
        //give
        SimpelFormDemoPage simpelFormDemoPage = new SimpelFormDemoPage(driver);
        String value1="1234";
        String value2="";
        //when
        simpelFormDemoPage.goToExercise();
        String wynik = simpelFormDemoPage
                .sendDoubellInputValue(value1,value2)
                .clickDobuelInputValue()
                .getDobuelInputMessage();
        //then
        System.out.println(wynik);
        Assert.assertEquals(wynik,"1234");

    }
    @Test
    public void doubleInput_Enter_Singel_Text_Should_Show_Error()
    {
        //give
        SimpelFormDemoPage simpelFormDemoPage = new SimpelFormDemoPage(driver);
        String value1="Mateusz";
        String value2="";
        //when
        simpelFormDemoPage.goToExercise();
        String wynik = simpelFormDemoPage
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
        SimpelFormDemoPage simpelFormDemoPage = new SimpelFormDemoPage(driver);
        String value1="";
        String value2="";
        //when
        simpelFormDemoPage.goToExercise();
        String wynik = simpelFormDemoPage
                .sendDoubellInputValue(value1,value2)
                .clickDobuelInputValue()
                .getDobuelInputMessage();
        //then
        System.out.println(wynik);
        Assert.assertEquals(wynik,"NaN");

    }
}
