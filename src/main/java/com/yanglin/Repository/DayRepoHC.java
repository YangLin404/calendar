package com.yanglin.Repository;

import com.yanglin.Models.DayFactory;
import com.yanglin.Models.DayModel;
import com.yanglin.Models.EventFactory;
import com.yanglin.Models.Month;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by yanglin on 17/11/16.
 */
public class DayRepoHC implements IDayRepo
{


    private final static Logger LOGGER = Logger.getLogger(DayRepoHC.class.getName());

    private final int YEARTOCREATE = 2016;
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

    public TreeSet<DayModel> readDaysByYear()
    {
        return fakeDays;
    }

    private void setupDays()
    {
        LOGGER.log(Level.INFO,"setup HC Days starting");

        this.fakeDays.addAll(DayFactory.getInstance().createDaysByYear(YEARTOCREATE));

        LOGGER.log(Level.FINE,"setup HC Days finished size of fakedays:{0}",fakeDays.size());
    }

    private void setupEvents()
    {
        LOGGER.log(Level.INFO,"setup HC fakeEvents starting");
        for (DayModel d : fakeDays)
        {
            d.addEvent(eventFactory.createRandomEvent(d));
        }

        LOGGER.log(Level.INFO,"setup HC fakeEvents finished");
    }

    @Override
    public SortedSet<DayModel> readDaysByYear(int year)
    {
        return null;
    }

    @Override
    public void updateDay(DayModel d)
    {

    }
}
