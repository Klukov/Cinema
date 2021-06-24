package com.PiotrKlukowski.Cinema.utils;

import java.util.Calendar;
import java.util.Date;

public final class DateUtils {
    private DateUtils() {}

    private static final int WEEKEND_START_HOUR = 14;
    private static final int WEEKEND_END_HOUR = 23;

    private static boolean isWeekend(Date date) {
        var now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
        return (dayOfWeek == Calendar.FRIDAY && hourOfDay >= WEEKEND_START_HOUR) ||
                (dayOfWeek == Calendar.SATURDAY) ||
                (dayOfWeek == Calendar.SUNDAY && hourOfDay < WEEKEND_END_HOUR);
    }
}
