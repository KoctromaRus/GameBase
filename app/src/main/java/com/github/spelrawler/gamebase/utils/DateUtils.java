package com.github.spelrawler.gamebase.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Spel on 28.05.2017.
 */

public class DateUtils {

    public static String getYear(long time) {
        return getYear(new Date(time));
    }

    public static String getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return String.valueOf(calendar.get(Calendar.YEAR));
    }

}
