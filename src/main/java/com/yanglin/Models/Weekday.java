package com.yanglin.Models;

public enum Weekday
{
    MAANDAG(0,"Ma"),DINSDAG(1,"Di"),WOENSDAG(2,"Woe"),DONDERDAG(3,"Do"),VRIJDAG(4,"Vr"),ZATERDAG(5,"Za"),ZONDAG(6,"Zo");

    private int index;
    private String afkorting;

    Weekday(int index, String afkorting)
    {
        this.index = index;
        this.afkorting = afkorting;
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
}
