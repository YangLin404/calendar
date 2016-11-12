package com.yanglin.Models;

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
}
