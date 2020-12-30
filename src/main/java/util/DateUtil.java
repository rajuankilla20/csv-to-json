package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private static SimpleDateFormat yyyyMMddFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Date getDate(String strDate){
    Date retDate=null;
        try {
            retDate = yyyyMMddFormat.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return  retDate;
    }
}
