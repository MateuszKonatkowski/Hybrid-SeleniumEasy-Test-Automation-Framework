package Listeners;

import Config.GlobalConsts;
import Driver.DriverFactory;
import Util.ExtentReportUtil;

import Util.ScreenShotUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;




public class Listener   implements ITestListener {


    ExtentTest extentTest;



    ExtentReports extent = ExtentReportUtil.getReportObject();

    @Override
    public void onFinish(ITestContext contextFinish) {
        extent.flush();



    }

    @Override
    public void onStart(ITestContext contextStart) {



    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {


    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver=null;



        try {
            driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
        }

        String destinationScreenshotPath = ScreenShotUtil.captureScreenshot(driver,result.getName());

        extentTest.addScreenCaptureFromPath(destinationScreenshotPath);
        extentTest.fail(result.getThrowable());



    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.log(Status.SKIP,"Test Skiped");

    }

    @Override
    public void onTestStart(ITestResult result) {

        extentTest = extent.createTest(result.getMethod().getMethodName()).assignAuthor("Mateusz Konatkowski").pass("details");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.log(Status.PASS,"Test Passed");


    }

}
