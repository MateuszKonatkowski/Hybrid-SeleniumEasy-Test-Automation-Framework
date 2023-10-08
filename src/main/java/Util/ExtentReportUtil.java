package Util;
import Config.GlobalConsts;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReportUtil {

     public static ExtentReports getReportObject()
     {
         String path = GlobalConsts.EXTEND_REPORT_PATH;
         ExtentReports extent = new ExtentReports();
         ExtentSparkReporter spark = new ExtentSparkReporter(path);
         spark.config().setTheme(Theme.DARK);
         spark.config().setTimelineEnabled(true);
         spark.config().setReportName("SeleniumEasyFramework results");
         spark.config().setDocumentTitle("Test results");
         extent.attachReporter(spark);
         extent.setSystemInfo("Tester","Mateusz Konatkowski");
         extent.createTest(path);
         return extent;
    }

}

