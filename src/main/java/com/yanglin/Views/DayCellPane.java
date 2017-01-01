package com.yanglin.Views;

import com.yanglin.Controllers.CalendarController;
import com.yanglin.Models.DayModel;
import com.yanglin.Models.Event;
import com.yanglin.Models.Work;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;

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

    public DayCellPane(DayLabel lbl, CalendarController cc)
    {
        init(lbl,new DayCellVBox(cc));
    }

    public DayCellPane(DayLabel lbl, EventsListView<Event> eventsLv, CalendarController cc)
    {
        //this.eventsLv = eventsLv;
        init(lbl,new DayCellVBox(eventsLv,cc));
    }

    private void init(DayLabel lbl, DayCellVBox dayCellVBox)
    {
        setupStyle();
        this.dayLbl = lbl;
        this.cc = cc;
        this.dayCellVBox = dayCellVBox;
        setupLayout();
    }

    private void setupLayout()
    {
        this.dayLbl.setAlignment(Pos.CENTER_RIGHT);
        this.setTop(this.dayLbl);
        this.setCenter(this.dayCellVBox);
        this.setMinHeight(0.0);
    }

    private void setupStyle()
    {
        this.getStyleClass().add("dayCellPane");
    }

    public void setDayModel(DayModel dayModel)
    {
        this.dayModel = dayModel;
        this.dayCellVBox.setDayModel(dayModel);
    }

    public void changeDayWork(Work work)
    {
        this.dayCellVBox.setWorkDay(work);
    }


    public DayModel getDayModel()
    {
        return dayModel;
    }

    public DayLabel getDayLbl()
    {
        return dayLbl;
    }
}
