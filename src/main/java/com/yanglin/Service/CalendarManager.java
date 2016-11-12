package com.yanglin.Service;

import com.yanglin.Models.Day;

import java.util.SortedSet;


public class CalendarManager
{
    private static CalendarManager ourInstance = new CalendarManager();

    public static CalendarManager getInstance()
    {
        return ourInstance;
    }


    private SortedSet<Day> days;


    private CalendarManager()
    {

    }
}
