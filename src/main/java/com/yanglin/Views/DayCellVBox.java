package com.yanglin.Views;

import com.yanglin.Controllers.CalendarController;
import com.yanglin.Models.DayModel;
import com.yanglin.Models.Event;
import com.yanglin.Models.Work;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;


public class DayCellVBox extends VBox
{
    private WorkLabel workLbl;
    private DayModel dayModel;
    private CalendarController cc;

    //private EventsListView<Event> eventsLv;
    public DayCellVBox(WorkLabel workLbl, EventsListView<Event> eventsLv, CalendarController cc)
    {

        init(workLbl,cc);
    }

    public DayCellVBox(WorkLabel workLbl, CalendarController cc)
    {
        init(workLbl,cc);
    }

    private void init(WorkLabel workLbl, CalendarController cc)
    {
        this.workLbl = workLbl;
        this.cc = cc;

        setupStyle();
    }

    private void setupStyle()
    {
        this.getStyleClass().add("dayBox");
        VBox.setVgrow(this, Priority.ALWAYS);
    }


    public void changeDayWork(Work work)
    {
        this.cc.getCm().setWorkToDay(dayModel,work);
        this.getWorkLbl().setValue(work);
        if (work == Work.None)
            this.removeWorkLbl();
        else
        {
            if (!(this.getChildren().contains(this.workLbl)))
            {
                this.getChildren().add(this.workLbl);
            }
        }
    }

    public WorkLabel getWorkLbl()
    {
        return workLbl;
    }

    public void setDayModel(DayModel dayModel)
    {
        this.dayModel = dayModel;
        //this.getChildren().add(workLbl);
    }

    public void removeWorkLbl()
    {
        this.getChildren().remove(workLbl);
    }

    /*
    public EventsListView<Event> getEventsLv()
    {
        return eventsLv;
    }
    */
}
