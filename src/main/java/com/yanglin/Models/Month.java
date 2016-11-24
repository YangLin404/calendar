package com.yanglin.Models;

import com.yanglin.Utils.Helper;
import javafx.beans.property.Property;

import java.util.Calendar;

public enum  Month
{
    JANUARI(0,31), FEBRUARI(1,28), MAART(2,31), APRIL(3,30),
    MEI(4,31), JUNI(5,30), JULI(6,31), AUGUSTUS(7,31),
    SEPTEMBER(8,30), OKTOBER(9,31), NOVEMBER(10,30), DECEMBER(11,31);

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

    public int getTotaaldays(int year)
    {
        if (this == Month.FEBRUARI && Helper.isSchrikeljaar(year))
            return totaaldays+1;
        else
            return totaaldays;
    }

    public Month getNextMonth()
    {
        if (this.digit==11)
            return Month.values()[0];
        return Month.values()[this.digit+1];
    }

    public Month getPreMonth()
    {
        if (this.digit==0)
            return Month.values()[11];
        return Month.values()[this.digit-1];
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
