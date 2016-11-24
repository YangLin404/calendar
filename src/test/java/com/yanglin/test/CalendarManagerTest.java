package com.yanglin.test;
import com.yanglin.Models.DayFactory;
import com.yanglin.Models.DayModel;
import com.yanglin.Models.Month;
import com.yanglin.Repository.DayRepo;
import com.yanglin.Repository.IDayRepo;
import com.yanglin.Service.CalendarManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.mockito.Mockito;
import static org.mockito.Mockito.*;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Created by yanglin on 22/11/16.
 */
public class CalendarManagerTest
{
    private CalendarManager calendarManager;
    private IDayRepo mockDayRepo;
    private DayFactory dayFactory;
    private final int YEARTOTEST = 2016;

    public CalendarManagerTest()
    {

    }

    @Before
    public void setup()
    {
        this.mockDayRepo = Mockito.mock(DayRepo.class);
        this.dayFactory = DayFactory.getInstance();
        when(this.mockDayRepo.getDays()).thenReturn(dayFactory.createDaysByYear(this.YEARTOTEST));
        this.calendarManager = new CalendarManager(this.mockDayRepo);
    }


    @Test
    public void getDaysByMonthYear_ReturnsCorrectDaysTest()
    {


        SortedSet<DayModel> expectedDays = this.dayFactory.createDaysByMonthYear(this.YEARTOTEST,Month.JANUARI);

        SortedSet<DayModel> days = calendarManager.getDaysByMonthYear(this.YEARTOTEST, Month.JANUARI);


        Assert.assertArrayEquals(expectedDays.toArray(), days.toArray());
    }

    @Test
    public void getDaysOfPreviousMonth_With2016feb_ReturnsCorrectDays()
    {

        SortedSet expectedDays = this.dayFactory.createDaysByMonthYear(this.YEARTOTEST, Month.JANUARI);

        SortedSet<DayModel> days = calendarManager.getDaysOfPreviousMonth(this.YEARTOTEST, Month.FEBRUARI);

        Assert.assertArrayEquals(expectedDays.toArray(),days.toArray());

    }

    @Test
    public void getDaysOfNextMonth_With2016Feb_ReturnsCorrectDays()
    {

        SortedSet expectedDays = this.dayFactory.createDaysByMonthYear(this.YEARTOTEST, Month.FEBRUARI);

        SortedSet<DayModel> days = calendarManager.getDaysOfNextMonth(this.YEARTOTEST, Month.JANUARI);

        Assert.assertArrayEquals(expectedDays.toArray(),days.toArray());
    }

}
