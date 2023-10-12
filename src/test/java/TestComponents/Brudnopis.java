package TestComponents;

import Listeners.Listener;
import Util.LoggerUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import org.apache.poi.ss.usermodel.Row;

public class Brudnopis {
    WebDriver driver;
    public ArrayList<String> getData(String testcasename) throws IOException
    {
        ArrayList<String> a=new ArrayList<String>();
        File file = new File(System.getProperty("user.dir")+"\\src\\test\\java\\TestComponents\\test.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        System.out.println(workbook.getNumberOfSheets());
        int sheets = workbook.getNumberOfSheets();
        for(int i=0; i<sheets; i++)
        {
            workbook.getSheetName(i).equalsIgnoreCase("Arkusz1");
            XSSFSheet sheet = workbook.getSheetAt(i);
            Iterator<Row> rows = sheet.iterator();
            Row firstrow = rows.next();
            Iterator<Cell> cell = firstrow.cellIterator();
            int k = 0;
            int column = 0;
            while(cell.hasNext())
            {
                Cell value = cell.next();
                if(value.getStringCellValue().equalsIgnoreCase("animal"))
                {
                    column=k;
                }
                k++;
            }
            System.out.println(column);
            while(rows.hasNext())
            {
                Row r = rows.next();
                if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcasename))
                {
                    Iterator<Cell> cel = r.cellIterator();
                    while(cel.hasNext())
                    {
                       Cell c = cel.next();
                       if(c.getCellType() == CellType.STRING)
                       {
                           a.add(c.getStringCellValue());
                       }
                       else
                       {
                           a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
                       }
                    }
                }
            }

    }

        return a;
    }
    DataFormatter formatter = new DataFormatter();
    @DataProvider(name="driverTest")
    public Object[][] getData() throws IOException {
       // Object[][] data = {{"hello","text","1"},{"bye","message","143"},{"solo","call","12"}};
        //return data;
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\TestComponents\\Books.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
       int rowCount = sheet.getPhysicalNumberOfRows();
       XSSFRow row = sheet.getRow(0);
       int colCount = row.getLastCellNum();
       Object data[][] = new Object[rowCount-1][colCount];
       for(int i = 0; i < rowCount-1; i++)
       {
           row=sheet.getRow(i+1);
           for(int j=0; j < colCount; j++)
           {
               XSSFCell cell = row.getCell(j);
               data[i][j]=formatter.formatCellValue(cell);
           }
       }

        return data;
    }
    @Test(dataProvider ="driverTest")
    public void testCaseData(String greeting, String communication,String id)
    {
        System.out.println(id);
    }



    private static final Logger logger = LogManager.getLogger();
    @Test
    public void test2()
    {
        logger.info("XD");
        logger.error("XD");
        logger.debug("XD");
        LoggerUtil.info("Mateusz");
    }
}
