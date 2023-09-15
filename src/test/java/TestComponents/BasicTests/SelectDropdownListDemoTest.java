package TestComponents.BasicTests;

import PageFactory.BasicPage.SelectDropdownListPage;
import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectDropdownListDemoTest extends BaseTest {
    @Test
    public void select_SelectValue_Should_Show_Message()
    {
        //given
        SelectDropdownListPage selectDropdownListPage = new SelectDropdownListPage(driver);
        //when
        selectDropdownListPage.goToExercise();
        String message = selectDropdownListPage
                .selectValue()
                .getSelectMessage();
        //then
        Assert.assertEquals(message,"Day selected :- Sunday");
    }

    @Test
    public void multiSelect_Status_Should_Multiple()
    {
        //given
        SelectDropdownListPage selectDropdownListPage = new SelectDropdownListPage(driver);
        //when
        selectDropdownListPage.goToExercise();
        //then
        Assert.assertTrue(selectDropdownListPage.multiSelectStatus());
    }
    @Test
    public void multiSelect_SelectAllValues_Should_Show_All_Message()
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
        System.out.println(message);
        Assert.assertEquals(message,"Options selected are : California,Florida,New Jersey,New York,Ohio,Texas,Pennsylvania,Washington");
    }
    @Test
    public void multiSelect_SelectFirstSelectedValue_Should_Show_First_Message()
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
        Assert.assertEquals(message,"First selected option is : Pennsylvania");
    }
}
