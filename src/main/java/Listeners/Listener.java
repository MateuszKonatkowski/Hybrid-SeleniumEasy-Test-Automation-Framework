package Listeners;


import PageFactory.BasePage;
import Util.ConfigReaderUtil;
import Util.ExtentReportUtil;


import Util.LoggerUtil;
import Util.ScreenShotUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


import org.testng.ITestListener;
import org.testng.ITestContext;
import org.testng.ITestResult;


import java.io.IOException;


public class Listener extends BasePage implements ITestListener {

    ExtentTest extentTest;

    ExtentReports extent = ExtentReportUtil.getReportObject();

    ThreadLocal<ExtentTest> test = new ThreadLocal<>();



    @Override
    public void onFinish(ITestContext contextFinish)
    {
        extent.flush();
        LoggerUtil.info("Tests finished");
    }

    @Override
    public void onStart(ITestContext contextStart)
    {

        LoggerUtil.info("Tests started");

    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        test.get().fail(result.getThrowable());
        LoggerUtil.error("Test "+result.getMethod().getMethodName()+" failed");
        if(ConfigReaderUtil.getProperty("screenshotOnFail").equalsIgnoreCase("TRUE"))
        {

            try {
                test.get().addScreenCaptureFromPath(ScreenShotUtil.captureScreenshot(driver, result.getMethod().getMethodName(), result.getTestClass().getName()));
            } catch (IOException e) {
                LoggerUtil.error("Failed to capture "+ result.getMethod().getMethodName()+" screenshot");
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result)
    {
        test.get().log(Status.SKIP,"Test Skipped");
        LoggerUtil.info("Test "+result.getMethod().getMethodName()+" Skipped");
        if(ConfigReaderUtil.getProperty("screenshotOnSkip").equalsIgnoreCase("TRUE"))
        {
            try {
                test.get().addScreenCaptureFromPath(ScreenShotUtil.captureScreenshot(driver, result.getMethod().getMethodName(), result.getTestClass().getName()));
            } catch (IOException e) {
                LoggerUtil.error("Failed to capture "+ result.getMethod().getMethodName()+" screenshot");
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public void onTestStart(ITestResult result)
    {
        extentTest = extent.createTest(result.getMethod().getMethodName()).assignAuthor(ConfigReaderUtil.getProperty("author")).pass("Test Start");
        test.set(extentTest);
        LoggerUtil.info("Test "+result.getMethod().getMethodName()+" Started");
    }

    @Override
    public void onTestSuccess(ITestResult result)
    {
        test.get().log(Status.PASS,"Test Passed");
        LoggerUtil.info("Test "+result.getMethod().getMethodName()+" Passed");

        if(ConfigReaderUtil.getProperty("screenshotOnSuccess").equalsIgnoreCase("TRUE"))
        {
            try {
                test.get().addScreenCaptureFromPath(ScreenShotUtil.captureScreenshot(driver, result.getMethod().getMethodName(), result.getTestClass().getName()));
            } catch (IOException e) {
                LoggerUtil.error("Failed to capture "+ result.getMethod().getMethodName()+" screenshot");
                throw new RuntimeException(e);
            }
        }

    }

}
