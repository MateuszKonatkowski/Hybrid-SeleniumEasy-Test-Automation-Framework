package TestComponents.BasicTests;

import PageFactory.BasicPageFactory.SimpleFormPage;
import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleFormDemoTest extends BaseTest {

    @Test(groups = {"Smoke"})
    public void singleInput_Enter_Any_Data_Should_Show_Message() {
        //given
        SimpleFormPage simple = new SimpleFormPage(driver);
        String message = "Mateusz";
        //when
        simple.goToExercise();
        String result = simple
                .sendSingleInputValue(message)
                .clickSingleInputButton()
                .getSingleInputMessage();
        //then
        Assert.assertEquals(result,message);
    }

    @Test
    public void singleInput_Not_Entering_Any_Data_Should_Show_No_Message() {
        //given
        SimpleFormPage simple = new SimpleFormPage(driver);
        String message = "";
        //when
        simple.goToExercise();
        String result = simple
                .sendSingleInputValue("")
                .clickSingleInputButton()
                .getSingleInputMessage();
        //then
        Assert.assertEquals(result,message);
    }

    @Test(groups = {"Smoke"})
    public void doubleInput_Enter_Double_Number_Should_Show_Sum()
    {
        //give
        SimpleFormPage simpleFormPage = new SimpleFormPage(driver);
        String value1="1234";
        String value2="4321";
        //when
        simpleFormPage.goToExercise();
        String result = simpleFormPage
                .sendDoubleInputValue(value1,value2)
                .clickDoubleInputValue()
                .getDoubleInputMessage();
        //then
        Assert.assertEquals(result,"5555");
    }

    @Test
    public void doubleInput_Enter_Single_Number_Should_Show_Number()
    {
        //give
        SimpleFormPage simpleFormPage = new SimpleFormPage(driver);
        String value1="0";
        String value2="1234";
        //when
        simpleFormPage.goToExercise();
        String result = simpleFormPage
                .sendDoubleInputValue(value1,value2)
                .clickDoubleInputValue()
                .getDoubleInputMessage();
        //then
        Assert.assertEquals(result,"1234");
    }

    @Test
    public void doubleInput_Enter_Single_Text_Should_Show_Error()
    {
        //give
        SimpleFormPage simpleFormPage = new SimpleFormPage(driver);
        String value1="Mateusz";
        String value2="";
        //when
        simpleFormPage.goToExercise();
        String result = simpleFormPage
                .sendDoubleInputValue(value1,value2)
                .clickDoubleInputValue()
                .getDoubleInputMessage();
        //then
        Assert.assertEquals(result,"NaN");
    }

    @Test(groups = {"Smoke"})
    public void doubleInput_Enter_No_Data_Should_Show_Error()
    {
        //give
        SimpleFormPage simpleFormPage = new SimpleFormPage(driver);
        String value1="";
        String value2="";
        //when
        simpleFormPage.goToExercise();
        String result = simpleFormPage
                .sendDoubleInputValue(value1,value2)
                .clickDoubleInputValue()
                .getDoubleInputMessage();
        //then
        Assert.assertEquals(result,"NaN");
    }

}
