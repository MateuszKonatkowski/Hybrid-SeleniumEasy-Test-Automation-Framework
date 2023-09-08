package TestComponents;

import PageFactory.SimpelFormDemoPage;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleFormDemo extends BaseTest{



    @Test
    public void singelInputTest() {
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
    public void doubelInputTest()
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
}
