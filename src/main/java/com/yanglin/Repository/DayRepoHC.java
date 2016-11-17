package com.yanglin.Repository;

import com.yanglin.Models.DayFactory;
import com.yanglin.Models.DayModel;
import com.yanglin.Models.EventFactory;
import com.yanglin.Models.Month;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.TreeSet;

/**
 * Created by yanglin on 17/11/16.
 */
public class DayRepoHC implements IDayRepo
{
    //just for testing
    private TreeSet<DayModel> fakeDays;
    private EventFactory eventFactory;

    public DayRepoHC()
    {
        fakeDays = new TreeSet<>();
        eventFactory = EventFactory.getInstance();
        setupDays();
        setupEvents();

    }

    public TreeSet<DayModel> getDays()
    {
        return fakeDays;
    }

    private void setupDays()
    {
        int total=0;
        for (Month m : Month.values())
        {
            for (int i=1; i<=m.getTotaaldays(); i++)
            {
                DayModel day = DayFactory.getInstance().createDay(i,m.getDigit(),2016);
                day.setId(total);
                fakeDays.add(day);
            }
        }
    }

    private void setupEvents()
    {
        for (DayModel d : fakeDays)
        {
            d.addEvent(eventFactory.createRandomEvent(d));
        }
    }
}
