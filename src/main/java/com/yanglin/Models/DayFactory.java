package com.yanglin.Models;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class DayFactory
{
    private static DayFactory ourInstance = new DayFactory();

    public static DayFactory getInstance()
    {
        return ourInstance;
    }

    private DayFactory()
    {

    }

    public Day createDay(int day, int month, int year, List<Event> events)
    {
        return new Day(day,month,year,events);
    }

    public Day createDay(int day, int month, int year)
    {
        return new Day(day,month,year);
    }

    public Day createDummyDay()
    {
        return new Day(1,0,1000);
    }

    public Set<Day> getDaysByYear(int year)
    {
        Set<Day> requestedDays = new TreeSet<>();
        for (Month m : Month.values())
        {
            int aantalDays = m.getTotaaldays();
            if (m == Month.FEBRUARI && Helper.isSchrikeljaar(year))
                aantalDays++;
            for (int i=1; i<=aantalDays; i++)
            {
                requestedDays.add(createDay(i,m.getDigit(),year));
            }
        }

        return requestedDays;
    }
}
