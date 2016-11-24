package com.yanglin.Models;

import com.yanglin.Utils.Helper;

import java.util.List;
import java.util.Set;
import java.util.SortedSet;
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

    public SortedSet<DayModel> createDaysByYear(int year)
    {
        SortedSet<DayModel> requestedDays = new TreeSet<>();
        int total=0;
        for (Month m : Month.values())
        {
            requestedDays.addAll(createDaysByMonthYear(year,m));
        }

        return requestedDays;
    }

    public SortedSet<DayModel> createDaysByMonthYear(int year, Month month)
    {
        SortedSet<DayModel> requestedDays = new TreeSet<>();
        int total=0;
        for (int i=1; i<=month.getTotaaldays(year); i++)
        {
            DayModel day = DayFactory.getInstance().createDay(i,month,year);
            day.setId(total);
            requestedDays.add(day);
        }
        return requestedDays;
    }
}
