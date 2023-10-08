package Util;

import Config.GlobalConsts;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReaderUtil {
    public static String getProperty(String PropertyName)
    {
        Properties properties=new Properties();
        try
        {
            properties.load(new FileInputStream(new File(GlobalConsts.PROPERTIES_PATH)));

        } catch (Throwable e)
        {
            e.printStackTrace();
        }
        String PropertyValue=properties.getProperty(PropertyName);
        LoggerUtil.info("Get "+PropertyName+" value");
        return PropertyValue;
    }
}
