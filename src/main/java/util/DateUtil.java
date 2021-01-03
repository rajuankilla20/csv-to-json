package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    private static SimpleDateFormat yyyyMMddFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static SimpleDateFormat yyyyMMdd=new SimpleDateFormat("yyyy-MM-dd");

    public static Date getDate(String strDate){
    Date retDate=null;
        try {
            retDate = yyyyMMddFormat.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return  retDate;
    }
    public static Date getYYYMMDDDate(String strDate){
        Date retDate=null;
        try {
            retDate = yyyyMMdd.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return  retDate;
    }

    public static String getDayName(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        String[] days = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
        return  days[cal.get(Calendar.DAY_OF_WEEK) - 1];
    }
}
