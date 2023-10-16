package TestComponents.AdvancedTests;

import PageFactory.AdvancedPageFactory.DragAndDropPage;
import PageFactory.IntermediatePageFactory.BootstrapListBoxPage;
import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DragAndDropTest extends BaseTest {

    @Test(priority = 2,dataProvider = "TestData",dataProviderClass = DragAndDropPage.class,description = "dragAndDropDragItemData")
    public void dragAndDrop_Drag_Item_Should_Move_Item(String value)
    {
        //given
        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);

        //when
        dragAndDropPage.goToExercise();
        dragAndDropPage
                .dragItemsToDragItem(value);
        //then
        Assert.assertTrue(dragAndDropPage.getDragItemsToDragMovedItemStatus(value));

    }

    @Test(priority = 1,dataProvider = "TestData",dataProviderClass = DragAndDropPage.class,description = "dragAndDropDragALlItemsData")
    public void dragAndDrop_Drag_AllItems_Should_Move_AllItems(String expected)
    {
        //given
        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);

        //when
        dragAndDropPage.goToExercise();
        dragAndDropPage
                .dragItemsToDragAllItems();
        //then
        Assert.assertEquals(dragAndDropPage.getItemsDroppedCount(),expected);

    }

}
