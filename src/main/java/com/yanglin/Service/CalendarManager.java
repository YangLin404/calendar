package com.yanglin.Service;

import com.yanglin.Models.DayModel;
import com.yanglin.Models.Event;
import com.yanglin.Models.Month;
import com.yanglin.Repository.DayRepo;
import com.yanglin.Repository.IDayRepo;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Service
public class CalendarManager
{
    private IDayRepo dayRepo;

    private SortedSet<DayModel> days;


    public CalendarManager(IDayRepo dayRepo)
    {
        this.dayRepo = dayRepo;
        this.days = this.dayRepo.getDays();
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
}
