package com.yanglin.Models;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by yanglin on 17/11/16.
 */
public class EventFactory
{
    private static EventFactory ourInstance = new EventFactory();

    public static EventFactory getInstance()
    {
        return ourInstance;
    }

    private EventFactory()
    {

    }

    public Event createEvent(String title,int sH, int sM, int eH, int eM, DayModel day)
    {
        return this.createEvent(title, LocalTime.of(sH,sM),LocalTime.of(eH,eM),day);
    }

    public Event createEvent(String title, LocalTime start, LocalTime end, DayModel day)
    {
        return new Event(title, start, end, day.getId());
    }
    //just for testing
    public Event createRandomEvent(DayModel day)
    {
        Random random = new Random();
        String title = String.valueOf(random.nextInt(200));
        LocalTime start = LocalTime.of(random.nextInt(12), random.nextInt(61));
        LocalTime end = start.plusHours(1);
        return createEvent(title,start,end,day);
    }
}
