package Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String getCurrentDate()
    {
        SimpleDateFormat myformat=new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy");
        String newFormat=myformat.format(new Date());
        return newFormat;
    }

}
