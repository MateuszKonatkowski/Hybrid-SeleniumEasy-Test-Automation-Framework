package TestComponents.AdvancedTests;

import PageFactory.AdvancedPageFactory.TableDataSearchPage;
import PageFactory.BasicPageFactory.CheckboxPage;
import TestComponents.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TableDataSearchTest extends BaseTest {

    @Test(priority = 1,dataProvider = "TestData",dataProviderClass = TableDataSearchPage.class,description = "tableDataTasksEnterValueData")
    public void tableDataSearch_Tasks_Enter_Value_Should_Show_Element(String value1, String value2,String value3 ,String expected)
    {
        //given
        TableDataSearchPage tableDataSearchPage = new TableDataSearchPage(driver);
        SoftAssert softAssert = new SoftAssert();
        //when
        tableDataSearchPage.goToExercise();
        Boolean result = tableDataSearchPage
                .sendTaskInputValue(value1)
                .getTaskListElementStatus(value2);
        //then
        softAssert.assertTrue(result);
        softAssert.assertEquals(tableDataSearchPage.getTaskListElementCount(value3),expected);
        softAssert.assertAll();
    }

    @Test(priority = 2,groups = {"Smoke"},dataProvider = "TestData",dataProviderClass = TableDataSearchPage.class,description = "tableDataUsersEnterValueData")
    public void  tableDataSearch_Users_Enter_Value_Should_Show_Element(String value1, String value2, String value3, String expected)
    {
        //given
        TableDataSearchPage tableDataSearchPage = new TableDataSearchPage(driver);
        SoftAssert softAssert = new SoftAssert();
        //when
        tableDataSearchPage.goToExercise();
        Boolean result = tableDataSearchPage
                .clickUsersFilterButtonButton()
                .sendUsersFilterInputValue(value1,value2)
                .getUsersFilterListElementStatus(value2);
        System.out.println(value1);
        //then
        softAssert.assertTrue(result);
        softAssert.assertEquals(tableDataSearchPage.getUsersFilterListElementCount(value3),expected);
        softAssert.assertAll();
    }

}
