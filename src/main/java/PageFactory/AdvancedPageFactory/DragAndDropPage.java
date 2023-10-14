package PageFactory.AdvancedPageFactory;

import Config.GlobalConsts;
import Util.ExcelDataUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import PageFactory.BasePage;
import org.testng.annotations.DataProvider;


import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

public class DragAndDropPage extends BasePage {

    WebDriver driver;

    public DragAndDropPage()
    {

    }

    public DragAndDropPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

	@FindBy(css="#todrag span")
	private List<WebElement> dragAndDropItemsToDragElements;

	@FindBy(css="#mydropzone")
	private WebElement dragAndDropItemDropZoneElement;

	@FindBy(css="#droppedlist span")
	private List<WebElement> dragAndDropItemsDroppedElements;




    private final String exerciseLevel = GlobalConsts.ADVANCED;
    private final String exercise = GlobalConsts.DRAG_AND_DROP;
    private final String data_path = GlobalConsts.DRAG_AND_DROP_DATA_PATH;



    @DataProvider(name = "TestData")
    public Object[][] getData(Method method) throws IOException {
        return ExcelDataUtil.getData(method, data_path);
    }

    public void goToExercise() {
        goTo(exerciseLevel, exercise);
    }

    public DragAndDropPage dragItemsToDragItem(String item)
    {
        Actions action = new Actions(driver);
        WebElement element = dragAndDropItemsToDragElements
                .stream().filter(a -> a.getText().equals(item))
                .findFirst()
                .orElse(null);
        action.dragAndDrop(element,dragAndDropItemDropZoneElement).build().perform();
        return new DragAndDropPage(driver);
    }

    public boolean getDragItemsToDragMovedItemStatus(String item)
    {
        return dragAndDropItemsDroppedElements
                .stream()
                .anyMatch(a -> a.getText().equals(item));
    }

    public DragAndDropPage dragItemsToDragAllItems()
    {
        Actions action = new Actions(driver);
        dragAndDropItemsToDragElements
                .stream()
                .forEach(a -> action.dragAndDrop(a,dragAndDropItemDropZoneElement).build().perform());
        return new DragAndDropPage(driver);
    }

    public String getItemsDroppedCount()
    {
         String count = String.valueOf(dragAndDropItemsDroppedElements.stream().count());
        return count;
    }

    public String getItemsToDragCount()
    {
        return String.valueOf(dragAndDropItemsToDragElements.stream().count());
    }

}
