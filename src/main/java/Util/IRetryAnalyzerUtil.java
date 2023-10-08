package Util;

import Config.GlobalConsts;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;



public class IRetryAnalyzerUtil implements IRetryAnalyzer {

    int count = 0;
    int maxTry = GlobalConsts.I_RETRY_ANALYZER_COUNT;



    @Override
    public boolean retry(ITestResult iTestResult)
    {
        if(ConfigReaderUtil.getProperty("IRetryAnalyzer").equalsIgnoreCase("TRUE"))
        {
            if (count < maxTry) {
                count++;
                LoggerUtil.info("Retry "+ iTestResult.getMethod().getMethodName()+" test "+count+" time");
                return true;
            }
        }
            return false;

    }

   }
