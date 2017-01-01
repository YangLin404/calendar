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
    public DayCellVBox(EventsListView<Event> eventsLv, CalendarController cc)
    {
        init(cc);
    }

    public DayCellVBox(CalendarController cc)
    {
        init(cc);
    }

    private void init(CalendarController cc)
    {
        this.cc = cc;
        setupStyle();
    }

    private void setupStyle()
    {
        this.getStyleClass().add("dayBox");
        VBox.setVgrow(this, Priority.ALWAYS);
    }


    public void setWorkDay(Work work)
    {
        /*
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
        */
        this.removeWorkLbl();
        if (work != Work.None)
        {
            this.workLbl = new WorkLabel(work);
            this.getChildren().add(this.workLbl);

        }
    }

    public WorkLabel getWorkLbl()
    {
        return workLbl;
    }

    public void setDayModel(DayModel dayModel)
    {
        this.dayModel = dayModel;
        if (this.dayModel.getWork() != Work.None)
            this.setWorkDay(dayModel.getWork());
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
