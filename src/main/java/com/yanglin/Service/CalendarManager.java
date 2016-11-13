package com.yanglin.Service;

import com.yanglin.Models.DayModel;
import com.yanglin.Repository.DayRepo;
import org.springframework.stereotype.Service;

import java.util.SortedSet;

@Service
public class CalendarManager
{
    private DayRepo dayRepo;

    private SortedSet<DayModel> days;


    public CalendarManager(DayRepo dayRepo)
    {
        this.dayRepo = dayRepo;
    }
}
