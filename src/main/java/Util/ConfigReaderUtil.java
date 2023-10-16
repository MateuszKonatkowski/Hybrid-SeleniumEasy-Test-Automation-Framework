package Util;

import Config.GlobalConsts;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReaderUtil {
    public static String getProperty(String propertyName)
    {
        Properties properties=new Properties();
        try
        {
            properties.load(new FileInputStream(new File(GlobalConsts.PROPERTIES_PATH)));

        } catch (Throwable e)
        {
            LoggerUtil.error("Failed to get "+propertyName+" value");
            e.printStackTrace();

        }

        String PropertyValue=properties.getProperty(propertyName);
        LoggerUtil.info("Get "+propertyName+" value");
        return PropertyValue;
    }
}
