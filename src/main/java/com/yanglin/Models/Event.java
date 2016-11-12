package com.yanglin.Models;

import java.util.Date;


public class Event
{
    private long id;
    private String title;
    private Date startTime;
    private Date endTime;
    private long dayId;

    public Event()
    {

    }

    public Event(String title, Date startTime, Date endTime, long dayId)
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

    public Date getEndTime()
    {
        return endTime;
    }

    public void setEndTime(Date endTime)
    {
        this.endTime = endTime;
    }

    public Date getStartTime()
    {
        return startTime;
    }

    public void setStartTime(Date startTime)
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
}
