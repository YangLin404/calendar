package com.yanglin.Models;

/**
 * Created by yanglin on 24/12/16.
 */
public class DataDay implements Comparable<DataDay>
{
    private long id;
    private Month month;
    private int year;
    private Weekday weekday;
    private Work work;
    private int day;

    public DataDay()
    {

    }

    public DataDay(long id, int day, Month month, int year, Weekday weekday, Work work)
    {
        this.id = id;
        this.month = month;
        this.year = year;
        this.weekday = weekday;
        this.work = work;
    }

    public int getDay()
    {
        return day;
    }

    public void setDay(int day)
    {
        this.day = day;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public Month getMonth()
    {
        return month;
    }

    public void setMonth(Month month)
    {
        this.month = month;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public Weekday getWeekday()
    {
        return weekday;
    }

    public void setWeekday(Weekday weekday)
    {
        this.weekday = weekday;
    }

    public Work getWork()
    {
        return work;
    }

    public void setWork(Work work)
    {
        this.work = work;
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
    public int compareTo(DataDay o)
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
}
