package com.yanglin.Models;

import com.yanglin.Utils.Helper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class DayModel implements Comparable<DayModel>
{
    private SimpleLongProperty idProp;
    private SimpleIntegerProperty dayProp;
    private Month month;
    private SimpleIntegerProperty yearProp;
    private Weekday weekday;
    private Work work;
    //private List<Event> events;
    private ObservableList<Event> events;

    public DayModel()
    {

    }

    public DayModel(int day, int month, int year)
    {
        Month m = Month.getMonthFromDigit(month);
        Weekday w = Helper.getWeekdayFromDate(year,m,day);
        init(day,m,year,w,Work.None);
    }



    public DayModel(int day, int month, int year, List<Event> events)
    {
        Month m = Month.getMonthFromDigit(month);
        Weekday w = Helper.getWeekdayFromDate(year,m,day);
        init(day,m,year,w,Work.None);
        this.setEvents(events);
    }

    public DayModel(long id, int day, int month, int year, Weekday weekday, Work work)
    {
        Month m = Month.getMonthFromDigit(month);
        init(day,m,year,weekday,work);
        setId(id);

    }

    private void init(int day, Month month, int year, Weekday weekday, Work work)
    {
        this.dayProp = new SimpleIntegerProperty(day);
        this.month = month;
        this.yearProp = new SimpleIntegerProperty(year);
        this.idProp = new SimpleLongProperty();
        this.weekday = weekday;
        this.events = FXCollections.observableArrayList();
        this.work = work;
    }

    public SimpleIntegerProperty getDayProp()
    {
        return this.dayProp;
    }

    public int getDay()
    {
        return dayProp.getValue();
    }

    public void setDay(int day)
    {
        this.dayProp.setValue(day);
    }

    public ObservableList<Event> getEvents()
    {
        return events;
    }

    public Month getMonth()
    {
        return month;
    }

    public void setMonth(Month month)
    {
        this.month = month;
    }

    public Weekday getWeekday()
    {
        return weekday;
    }

    public void setWeekday(Weekday weekday)
    {
        this.weekday = weekday;
    }

    public SimpleIntegerProperty getYearProp()
    {
        return this.yearProp;
    }

    public int getYear()
    {
        return yearProp.getValue();
    }

    public void setYear(int year)
    {
        this.yearProp.setValue(year);
    }

    public Work getWork()
    {
        return work;
    }

    public void setWork(Work work)
    {
        this.work = work;
    }

    public void setEvents(List<Event> events)
    {
        this.events = FXCollections.observableArrayList(events);
    }

    public SimpleLongProperty getIdProp()
    {
        return this.idProp;
    }

    public long getId()
    {
        return idProp.getValue();
    }

    public void setId(long id)
    {
        this.idProp.set(id);
    }

    public void addEvent(Event event)
    {
        this.events.add(event);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof DayModel)) return false;

        DayModel day1 = (DayModel) o;

        return this.getDay() == day1.getDay() && this.getYear() == day1.getYear() && this.getMonth() == day1.getMonth();

    }

    @Override
    public int hashCode()
    {
        int result = dayProp.getValue();
        result = 31 * result + month.hashCode();
        result = 31 * result + yearProp.getValue();
        result = 31 * result + weekday.hashCode();
        return result;
    }

    @Override
    public int compareTo(DayModel o)
    {
        if (getYear() == o.getYear())
        {
            if (month == o.month)
            {
                return getDay() - o.getDay();
            }
            return month.getDigit() - o.getMonth().getDigit();
        }
        return getYear() - o.getYear();
    }

    @Override
    public String toString()
    {
        return this.getDay()
                + "/"
                + (this.getMonth().getDigit() +1)
                +"/"
                + this.getYear();
    }
}
