package Util;

import Config.GlobalConsts;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class ScreenShotUtil {

    public static String captureScreenshot(WebDriver driver,String testName,String testClass) throws IOException {

        File srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String destinationScreenshotPath = GlobalConsts.SCREENSHOT_PATH+testClass+"_"+testName+"_"+DateUtil.getCurrentDate()+".png";
        FileHandler.copy(srcScreenshot,new File(destinationScreenshotPath));
        LoggerUtil.info("Capture "+testName+" screenshot");
        return destinationScreenshotPath;
    }
}
