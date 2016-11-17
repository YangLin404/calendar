package com.yanglin.Models;

import javafx.beans.property.Property;

import java.util.Calendar;

public enum  Month
{
    JARUARI(1,31), FEBRUARI(2,28), MAART(3,31), APRIL(4,30), MEI(5,31),
    JUNI(6,30), JULI(7,31), AUGUSTUS(8,31), SEPTEMBER(9,30), OKTOBER(10,31), NOVEMBER(11,30), DECEMBER(12,31);

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
