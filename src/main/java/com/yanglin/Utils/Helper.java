package com.yanglin.Utils;

import com.yanglin.Models.Month;
import com.yanglin.Models.Weekday;

import java.util.Calendar;

public class Helper
{
    public static Weekday getWeekdayFromDate(int year, Month month, int day)
    {
        Calendar c = Calendar.getInstance();
        c.set(year, month.getDigit(), day);
        return Weekday.getWeekdayFromDigit(c.get(Calendar.DAY_OF_WEEK));

    }

    public static boolean isSchrikeljaar(int year)
    {
        return (year % 4 == 0 && year % 100 != 0) || (year % 4 == 0 && year % 100 == 0);
    }

    public static int getCurrentYear()
    {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    public static Month getCurrentMonth()
    {
        return Month.getMonthFromDigit(Calendar.getInstance().get(Calendar.MONTH));
    }
}
