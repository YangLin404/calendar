package com.yanglin.Models;

public enum Weekday
{
    MAANDAAG(0,"MA"),DINSDAG(1,"DI"),WOENSDAG(2,"WOE"),DONDERDAG(3,"DO"),VRIJDAG(4,"VR"),ZATERDAG(5,"ZA"),ZONDAG(6,"ZO");

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
        return Weekday.values()[digit-1];
    }
}
