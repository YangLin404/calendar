package com.yanglin.Models;

import java.time.LocalTime;
import java.util.Calendar;


public class Event
{
    private long id;
    private String title;
    private LocalTime startTime;
    private LocalTime endTime;
    private long dayId;

    public Event()
    {

    }

    public Event(String title, LocalTime startTime, LocalTime endTime, long dayId)
    {
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.dayId = dayId;


    }

    public long getDayId()
    {
        return dayId;
    }



    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public LocalTime getEndTime()
    {
        return endTime;
    }

    public void setEndTime(LocalTime endTime)
    {
        this.endTime = endTime;
    }

    public LocalTime getStartTime()
    {
        return startTime;
    }

    public void setStartTime(LocalTime startTime)
    {
        this.startTime = startTime;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.title)
                .append(" ")
                .append(this.getStartTime().toString());
        return sb.toString();
    }
}
