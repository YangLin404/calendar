package com.yanglin.Models;

import java.util.Arrays;
import java.util.Calendar;

public enum Weekday
{
    MAANDAG(0,"Ma", Calendar.MONDAY),DINSDAG(1,"Di",Calendar.TUESDAY),
    WOENSDAG(2,"Woe",Calendar.WEDNESDAY),DONDERDAG(3,"Do",Calendar.THURSDAY),
    VRIJDAG(4,"Vr",Calendar.FRIDAY),ZATERDAG(5,"Za",Calendar.SATURDAY),ZONDAG(6,"Zo",Calendar.SUNDAY);

    private int index;
    private String afkorting;
    private int calendarWeekDay;

    Weekday(int index, String afkorting, int cwd)
    {
        this.index = index;
        this.afkorting = afkorting;
        this.calendarWeekDay = cwd;
    }

    public int getIndex()
    {
        return index;
    }

    public String getAfkorting()
    {
        return afkorting;
    }

    public static Weekday getWeekdayFromDigit(int digit)
    {
        return Weekday.values()[digit];
    }

    public static Weekday getWDFromCWD(int cwd)
    {
        return Arrays.stream(Weekday.values()).filter(w -> w.calendarWeekDay == cwd).findFirst().get();
    }
}
