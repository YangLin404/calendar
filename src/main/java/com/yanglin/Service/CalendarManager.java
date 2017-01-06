package com.yanglin.Service;

import com.yanglin.Models.*;
import com.yanglin.Repository.IDayRepo;
import com.yanglin.Repository.SettingRepo;
import com.yanglin.Utils.Helper;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class CalendarManager
{
    private IDayRepo dayRepo;
    private SettingRepo settingRepo;
    private SortedSet<DayModel> days;
    private SettingModel userSetting;

    private final static Logger LOGGER = Logger.getLogger(CalendarManager.class.getName());

    @Autowired
    public CalendarManager(IDayRepo dayRepo, SettingRepo settingRepo)
    {
        this.dayRepo = dayRepo;
        this.settingRepo = settingRepo;

    }

    @PostConstruct
    public void init()
    {
        this.days = new TreeSet<>();
        this.readSettings();
        this.dayRepo.setConnectieStr(this.userSetting.getUrl()+":"+this.userSetting.getPort());
        this.readMoreDays(Helper.getCurrentYear());


    }

    private void readSettings()
    {
        userSetting = settingRepo.readSetting();
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
            readMoreDays(preYear);
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
            readMoreDays(nextYear);
        }
        else
        {
            nextMonth = currentMonth.getNextMonth();
        }
        return getDaysByMonthYear(nextYear,nextMonth);
    }

    private void readMoreDays(int year)
    {
        LOGGER.log(Level.INFO, "try to read days of year " + year + " from api.");
        this.days.addAll(this.dayRepo.readDaysByYear(year));
        LOGGER.log(Level.INFO,   this.days.size() +" days successful loaded from api.");
    }

    public void setWorkToDay(DayModel day, Work work)
    {
        day.setWork(work);
        dayRepo.updateDay(day);
    }

    public boolean isToday(DayModel d)
    {
        Calendar c = Calendar.getInstance();
        int todayYear = c.get(Calendar.YEAR);
        int todayMonth = c.get(Calendar.MONTH);
        int todayDay = c.get((Calendar.DAY_OF_MONTH));
        return d.getYear() == todayYear && d.getMonth().getDigit() == todayMonth && d.getDay() == todayDay;
    }

}
