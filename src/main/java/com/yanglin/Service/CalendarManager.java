package com.yanglin.Service;

import com.yanglin.Models.DayModel;
import com.yanglin.Models.Event;
import com.yanglin.Models.Month;
import com.yanglin.Models.Work;
import com.yanglin.Repository.IDayRepo;
import com.yanglin.Utils.Helper;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class CalendarManager
{
    private IDayRepo dayRepo;
    private SortedSet<DayModel> days;

    private final static Logger LOGGER = Logger.getLogger(CalendarManager.class.getName());

    @Autowired
    public CalendarManager(IDayRepo dayRepo)
    {
        this.dayRepo = dayRepo;
        this.resetDays(Helper.getCurrentYear());
    }

    public ObservableList<Event> getEventsByDay(DayModel day)
    {
        return days.stream().filter(d -> d.equals(day)).findFirst().get().getEvents();
    }

    public SortedSet<DayModel> getDaysByMonthYear(int year, Month month)
    {
        return days.stream()
                .filter(d -> (d.getMonth() == month && d.getYear() == year))
                .collect(Collectors.toCollection(TreeSet<DayModel>::new));
    }

    public SortedSet<DayModel> getDaysOfPreMonth(int currentYear, Month currentMonth)
    {
        int preYear=currentYear;
        Month preMonth;

        if (currentMonth==Month.JANUARI)
        {
            preYear--;
            preMonth = Month.DECEMBER;
            resetDays(preYear);
        }
        else
        {
            preMonth = currentMonth.getPreMonth();
        }
        return getDaysByMonthYear(preYear,preMonth);
    }

    public SortedSet<DayModel> getDaysOfNextMonth(int currentYear, Month currentMonth)
    {
        LOGGER.log(Level.INFO, "get days of next month for " + currentMonth + "/" + currentYear);
        int nextYear=currentYear;
        Month nextMonth;

        if (currentMonth==Month.DECEMBER)
        {
            LOGGER.log(Level.INFO, "getting next month of Dec, need retrive days of next year");
            nextYear++;
            nextMonth = Month.JANUARI;
            resetDays(nextYear);
        }
        else
        {
            nextMonth = currentMonth.getNextMonth();
        }
        return getDaysByMonthYear(nextYear,nextMonth);
    }

    public void resetDays(int year)
    {
        LOGGER.log(Level.INFO, "try to read days of year " + year + " from api.");
        this.days = dayRepo.readDaysByYear(year);
        LOGGER.log(Level.INFO,   this.days.size() +" days successful loaded from api.");
    }

    public void setWorkToDay(DayModel day, Work work)
    {
        day.setWork(work);
        dayRepo.updateDay(day);
    }

}
