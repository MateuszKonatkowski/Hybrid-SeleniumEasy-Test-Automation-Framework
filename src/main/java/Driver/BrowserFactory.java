package Driver;

import Config.GlobalConsts;

import Util.ConfigReaderUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;





import java.time.Duration;


public class BrowserFactory {

    public static  WebDriver driver;

    public static WebDriver initializeDriver()  {

        String browserName = System.getProperty("browser")!=null ? System.getProperty("browser"): ConfigReaderUtil.getProperty("browser");
        String url = ConfigReaderUtil.getProperty("url");

        if(browserName.contains("chrome")) {

            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();

            if(browserName.contains("headless")||ConfigReaderUtil.getProperty("headless").equalsIgnoreCase("TRUE"))
            {
                options.addArguments(GlobalConsts.HEADLESS);
            }
            options.addArguments(GlobalConsts.START_MAXIMIZED);
            options.addArguments(GlobalConsts.DISABLE_EXTENSIONS);
            options.addArguments(GlobalConsts.DISABLE_INFOBARS);
            options.addArguments(GlobalConsts.DISABLE_NOTIFICATIONS);
            options.addArguments(GlobalConsts.REMOTE_ALLOW_ORIGINS);

            driver = new ChromeDriver(options);

        }

        else if(browserName.contains("edge"))
        {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();


            if(browserName.contains("headless")||ConfigReaderUtil.getProperty("headless").equalsIgnoreCase("TRUE"))
            {
                options.addArguments(GlobalConsts.HEADLESS);
            }
            options.addArguments(GlobalConsts.START_MAXIMIZED);
            options.addArguments(GlobalConsts.DISABLE_EXTENSIONS);
            options.addArguments(GlobalConsts.DISABLE_INFOBARS);
            options.addArguments(GlobalConsts.DISABLE_NOTIFICATIONS);
            options.addArguments(GlobalConsts.REMOTE_ALLOW_ORIGINS);


            driver = new EdgeDriver(options);

        }
        else if(browserName.contains("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            if(browserName.contains("headless")||ConfigReaderUtil.getProperty("headless").equalsIgnoreCase("TRUE"))
            {
                options.addArguments(GlobalConsts.HEADLESS);
            }
            options.addArguments(GlobalConsts.START_MAXIMIZED);
            options.addArguments(GlobalConsts.DISABLE_EXTENSIONS);
            options.addArguments(GlobalConsts.DISABLE_INFOBARS);
            options.addArguments(GlobalConsts.DISABLE_NOTIFICATIONS);
            options.addArguments(GlobalConsts.REMOTE_ALLOW_ORIGINS);

            driver = new FirefoxDriver(options);

        }
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(GlobalConsts.PAGE_LOUD_TIME));
        driver.get(url);
        return driver;

    }
}
