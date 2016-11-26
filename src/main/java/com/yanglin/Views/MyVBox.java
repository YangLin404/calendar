package com.yanglin.Views;

import com.yanglin.Models.Event;
import javafx.scene.layout.VBox;


public class MyVBox extends VBox
{
    private DayLabel dayLbl;
    private EventsListView<Event> eventsLv;
    public MyVBox(DayLabel lbl, EventsListView<Event> eventsLv)
    {
        super(lbl,eventsLv);
        this.getStyleClass().add("dayBox");
        this.dayLbl = lbl;
        this.eventsLv = eventsLv;
    }

    public MyVBox(WeekdayLabel weekdayLabel)
    {
        super(weekdayLabel);
        this.getStyleClass().add("dayBox");
        this.dayLbl = weekdayLabel;
    }

    public DayLabel getDayLbl()
    {
        return dayLbl;
    }

    public EventsListView<Event> getEventsLv()
    {
        return eventsLv;
    }

    public boolean isNotWeekday()
    {
        return !(this.dayLbl instanceof WeekdayLabel);
    }
}
