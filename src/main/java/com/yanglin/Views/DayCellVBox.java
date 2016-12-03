package com.yanglin.Views;

import com.yanglin.Controllers.CalendarController;
import com.yanglin.Models.DayModel;
import com.yanglin.Models.Event;
import com.yanglin.Models.Work;
import javafx.scene.layout.VBox;


public class DayCellVBox extends VBox
{
    private DayLabel dayLbl;
    private WorkLabel workLbl;
    private DayModel dayModel;
    private CalendarController cc;

    //private EventsListView<Event> eventsLv;
    public DayCellVBox(DayLabel lbl, WorkLabel workLbl, EventsListView<Event> eventsLv, CalendarController cc)
    {
        super(lbl,workLbl,eventsLv);
        setupStyle();
        this.dayLbl = lbl;
        this.workLbl = workLbl;
        this.cc = cc;
        //this.eventsLv = eventsLv;
    }

    public DayCellVBox(DayLabel lbl, WorkLabel workLbl, CalendarController cc)
    {
        super(lbl,workLbl);
        setupStyle();
        this.dayLbl = lbl;
        this.workLbl = workLbl;
        this.cc = cc;
    }

    public DayCellVBox(WeekdayLabel weekdayLabel)
    {
        super(weekdayLabel);
        setupStyle();
        this.dayLbl = weekdayLabel;
    }

    private void setupStyle()
    {
        this.getStyleClass().add("dayBox");
    }

    public void setDayModel(DayModel dayModel)
    {
        this.dayModel = dayModel;
    }

    public DayModel getDayModel()
    {
        return dayModel;
    }

    public void changeDayWork(Work work)
    {
        this.cc.getCm().setWorkToDay(dayModel,work);
        this.getWorkLbl().setValue(work);
    }

    public DayLabel getDayLbl()
    {
        return dayLbl;
    }

    public WorkLabel getWorkLbl()
    {
        return workLbl;
    }

    /*
    public EventsListView<Event> getEventsLv()
    {
        return eventsLv;
    }
    */

    public boolean isNotWeekday()
    {
        return !(this.dayLbl instanceof WeekdayLabel);
    }
}
