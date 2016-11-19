package com.yanglin.Models;

import com.yanglin.Utils.Helper;

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

    public DayModel createDay(int day, int month, int year, List<Event> events)
    {
        return new DayModel(day,month,year,events);
    }

    public DayModel createDay(int day, int month, int year)
    {
        return new DayModel(day,month,year);
    }

    public DayModel createDay(int day, Month month, int year)
    {
        return new DayModel(day,month,year);
    }

    public DayModel createDummyDay()
    {
        return new DayModel(1,0,1000);
    }

    public Set<DayModel> getDaysByYear(int year)
    {
        Set<DayModel> requestedDays = new TreeSet<>();
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
