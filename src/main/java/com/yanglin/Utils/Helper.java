package com.yanglin.Utils;

import com.yanglin.Models.Month;
import com.yanglin.Models.Weekday;

import java.util.Calendar;

public class Helper
{
    public static Weekday getWeekdayFromDate(int year, Month month, int day)
    {
        Calendar c = Calendar.getInstance();
        int m = month.getDigit();
        c.set(year, m, day);
        int weekday = c.get(Calendar.DAY_OF_WEEK);
        //java calendar start on sunday
        return Weekday.getWeekdayFromDigit(weekday ==1 ? Weekday.ZONDAG.getIndex() : weekday-2);

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
