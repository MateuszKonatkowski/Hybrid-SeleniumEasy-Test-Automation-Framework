package TestComponents.BasicTests;

import PageFactory.BasicPageFactory.SelectDropdownListPage;
import TestComponents.BaseTest;
import Util.IRetryAnalyzerUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectDropdownListDemoTest extends BaseTest {

    @Test(priority = 1,groups = {"Smoke"},dataProvider = "TestData",dataProviderClass = SelectDropdownListPage.class,description = "selectSelectValueData")
    public void select_SelectValue_Should_Show_Message(String value,String expected)
    {
        //given
        SelectDropdownListPage selectDropdownListPage = new SelectDropdownListPage(driver);
        //when
        selectDropdownListPage.goToExercise();
        String message = selectDropdownListPage
                .selectValue(value)
                .getSelectMessage();
        //then
        Assert.assertEquals(message,expected);
    }

    @Test(priority = 3)
    public void multiSelect_Status_Should_Multiple()
    {
        //given
        SelectDropdownListPage selectDropdownListPage = new SelectDropdownListPage(driver);
        //when
        selectDropdownListPage.goToExercise();
        //then
        Assert.assertTrue(selectDropdownListPage.multiSelectStatus());
    }

    @Test(priority = 1,retryAnalyzer = IRetryAnalyzerUtil.class,dataProvider = "TestData",dataProviderClass = SelectDropdownListPage.class,description = "multiSelectSelectAllValueData")
    public void multiSelect_SelectAllValues_Should_Show_All_Message(String expected)
    {
        //given
        SelectDropdownListPage selectDropdownListPage = new SelectDropdownListPage(driver);
        //when
        selectDropdownListPage.goToExercise();
        String message = selectDropdownListPage
                .multiSelectSelectAllValues()
                .clickMultiSelectAllSelectedButton()
                .getMultiSelectMessage();

        //then
        Assert.assertEquals(message,expected);
    }

    @Test(priority = 2,dataProvider = "TestData",dataProviderClass = SelectDropdownListPage.class,description = "multiSelectSelectFirstValueData")
    public void multiSelect_SelectFirstSelectedValue_Should_Show_First_Message(String expected)
    {
        //given
        SelectDropdownListPage selectDropdownListPage = new SelectDropdownListPage(driver);
        //when
        selectDropdownListPage.goToExercise();
        String message = selectDropdownListPage
                .multiSelectSelectFirstValue()
                .clickMultiSelectFirsSelectedButton()
                .getMultiSelectMessage();
        //then
        Assert.assertEquals(message,expected);
    }

}
