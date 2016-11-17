package com.yanglin.Models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.LinkedList;
import java.util.List;

public class DayModel implements Comparable<DayModel>
{
    private SimpleLongProperty idProp;
    private SimpleIntegerProperty dayProp;
    private Month month;
    private SimpleIntegerProperty yearProp;
    private Weekday weekday;
    //private List<Event> events;
    private ObservableList<Event> events;

    public DayModel()
    {
        this.events = new SimpleListProperty<>();
    }

    public DayModel(int day, int month, int year)
    {
        this();
        this.dayProp = new SimpleIntegerProperty(day);
        this.month = Month.getMonthFromDigit(month);
        this.yearProp = new SimpleIntegerProperty(year);
        this.idProp = new SimpleLongProperty();
        this.weekday = Helper.getWeekdayFromDate(this.yearProp.getValue(),this.month,this.dayProp.getValue());
        this.events = FXCollections.observableArrayList();
    }

    public DayModel(int day, int month, int year, List<Event> events)
    {
        this(day,month,year);
        this.setEvents(events);
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

        return dayProp == day1.dayProp && yearProp == day1.yearProp && month == day1.month;

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
        if (yearProp == o.yearProp)
        {
            if (month == o.month)
            {
                return dayProp.get() - o.getDay();
            }
            return month.getDigit() - o.getMonth().getDigit();
        }
        return yearProp.getValue() - o.yearProp.getValue();
    }
}
