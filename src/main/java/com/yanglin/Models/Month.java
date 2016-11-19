package com.yanglin.Models;

import javafx.beans.property.Property;

import java.util.Calendar;

public enum  Month
{
    JARUARI(0,31), FEBRUARI(1,28), MAART(2,31), APRIL(3,30), MEI(4,31),
    JUNI(5,30), JULI(6,31), AUGUSTUS(7,31), SEPTEMBER(8,30), OKTOBER(9,31), NOVEMBER(10,30), DECEMBER(11,31);

    private int digit;
    private int totaaldays;

    Month(int digit, int totaaldays)
    {
        this.digit = digit;
        this.totaaldays = totaaldays;
    }

    public int getDigit()
    {
        return digit;
    }

    public int getTotaaldays()
    {
        return totaaldays;
    }

    public static Month getCurrentMonth()
    {
        return getMonthFromDigit(Calendar.getInstance().get(Calendar.MONTH));
    }

    public static Month getMonthFromDigit(int digit)
    {
        return Month.values()[digit];
    }
}
