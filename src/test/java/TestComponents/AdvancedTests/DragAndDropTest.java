package TestComponents.AdvancedTests;

import PageFactory.AdvancedPageFactory.DragAndDropPage;
import PageFactory.IntermediatePageFactory.BootstrapListBoxPage;
import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DragAndDropTest extends BaseTest {

    @Test(priority = 2,dataProvider = "TestData",dataProviderClass = DragAndDropPage.class,description = "dragAndDropDragItemData")
    public void dragAndDrop_Drag_Item_Should_Move_Item(String value, String expected)
    {
        //when
        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);
        SoftAssert softAssert = new SoftAssert();
        //given
        dragAndDropPage.goToExercise();
        dragAndDropPage
                .dragItemsToDragItem(value);
        //then
        softAssert.assertTrue(dragAndDropPage.getDragItemsToDragMovedItemStatus(value));
        softAssert.assertEquals(dragAndDropPage.getItemsToDragCount(),expected);
        softAssert.assertAll();
    }

    @Test(priority = 1,dataProvider = "TestData",dataProviderClass = DragAndDropPage.class,description = "dragAndDropDragALlItemsData")
    public void dragAndDrop_Drag_AllItems_Should_Move_AllItems(String expected1, String expected2)
    {
        //when
        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);
        SoftAssert softAssert = new SoftAssert();
        //given
        dragAndDropPage.goToExercise();
        dragAndDropPage
                .dragItemsToDragAllItems();
        //then
        softAssert.assertEquals(dragAndDropPage.getItemsToDragCount(),expected1);
        softAssert.assertEquals(dragAndDropPage.getItemsDroppedCount(),expected2);
        softAssert.assertAll();
    }

}
