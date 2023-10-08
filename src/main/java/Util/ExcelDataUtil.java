package Util;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

public class ExcelDataUtil {

    public static Object[][] getData(Method method,String data_path) throws IOException {
        DataFormatter formatter = new DataFormatter();
        String sheet_name = method.getAnnotation(Test.class).description();
        FileInputStream fis = new FileInputStream(data_path);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet(sheet_name);
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
        LoggerUtil.info("Read "+data_path+" data");
        return data;
    }

}

