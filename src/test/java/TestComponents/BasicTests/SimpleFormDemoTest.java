package TestComponents.BasicTests;


import PageFactory.BasicPageFactory.SimpleFormPage;
import TestComponents.BaseTest;

import org.testng.Assert;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class SimpleFormDemoTest extends BaseTest {


    @Test(priority = 1,groups = {"Smoke"},dataProvider = "TestData",dataProviderClass = SimpleFormPage.class,description = "singleInputData")
    public void singleInput_Enter_Data_Should_Show_Message(String value, String expected) {
        //given
        SimpleFormPage simpleFormPage = new SimpleFormPage(driver);
        //when
        simpleFormPage.goToExercise();
        String result = simpleFormPage
                .sendSingleInputValue(value)
                .clickSingleInputButton()
                .getSingleInputMessage();
        //then
        Assert.assertEquals(result,expected);
    }

    @Test(priority = 1,groups = {"Smoke"},dataProvider = "TestData",dataProviderClass = SimpleFormPage.class,description = "doubleInputData")
    public void doubleInput_Enter_Data_Should_Show_Message(String value1,String value2,String expected)
    {
        //given
        SimpleFormPage simpleFormPage = new SimpleFormPage(driver);
        //when
        simpleFormPage.goToExercise();
        String result = simpleFormPage
                .sendDoubleInputValue(value1,value2)
                .clickDoubleInputValue()
                .getDoubleInputMessage();
        //then
        Assert.assertEquals(result,expected);
    }

}
