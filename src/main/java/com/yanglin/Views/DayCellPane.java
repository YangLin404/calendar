package com.yanglin.Views;

import com.yanglin.Controllers.CalendarController;
import com.yanglin.Models.DayModel;
import com.yanglin.Models.Event;
import javafx.scene.layout.BorderPane;

/**
 * Created by yanglin on 3/12/16.
 */
public class DayCellPane extends BorderPane
{
    private DayLabel dayLbl;
    private DayModel dayModel;
    private CalendarController cc;
    private DayCellVBox dayCellVBox;

    private DayCellPane(DayLabel lbl)
    {


    }

    public DayCellPane(DayLabel lbl, WorkLabel workLbl, CalendarController cc)
    {
        init(lbl,workLbl,new DayCellVBox(workLbl,cc));
    }

    public DayCellPane(DayLabel lbl, WorkLabel workLbl, EventsListView<Event> eventsLv, CalendarController cc)
    {
        //this.eventsLv = eventsLv;
        init(lbl,workLbl,new DayCellVBox(workLbl,eventsLv,cc));
    }

    private void init(DayLabel lbl, WorkLabel workLbl, DayCellVBox dayCellVBox)
    {
        setupStyle();
        this.dayLbl = lbl;
        this.cc = cc;
        this.dayCellVBox = dayCellVBox;
        setupLayout();
    }

    private void setupLayout()
    {
        this.setTop(this.dayLbl);
        this.setCenter(this.dayCellVBox);
        this.setMinHeight(0.0);
    }

    private void setupStyle()
    {
        this.getStyleClass().add("dayAnchorPane");
    }

    public void setDayModel(DayModel dayModel)
    {
        this.dayModel = dayModel;
        this.dayCellVBox.setDayModel(dayModel);
    }

    public DayModel getDayModel()
    {
        return dayModel;
    }

    public DayLabel getDayLbl()
    {
        return dayLbl;
    }
    public WorkLabel getWorkLbl()
    {
        return this.dayCellVBox.getWorkLbl();
    }
}
