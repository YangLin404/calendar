package com.yanglin.Controllers;

import com.yanglin.Views.DayCellPane;
import com.yanglin.Views.DayLabel;
import com.yanglin.Views.WorkLabel;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * Created by yanglin on 28/12/16.
 */

@Component
public class DayCellFactory
{

    private final static Logger LOGGER = Logger.getLogger(DayCellFactory.class.getName());

    public LinkedList<DayCellPane> createDaycells(CalendarController cc)
    {
        LinkedList<DayCellPane> daycells = new LinkedList<>();
        for (int i=1; i<7; i++)
        {
            for (int j=0; j<7; j++)
            {
                DayCellPane d = createDaycell(cc);
                daycells.add(d);
                cc.getCalendarGridPane().add(d, j, i);
            }
        }
        return daycells;
    }

    private DayCellPane createDaycell(CalendarController cc)
    {
        DayLabel label = new DayLabel();
        WorkLabel workLbl = new WorkLabel();
        //EventsListView<Event> listView = new EventsListView<>();
        return new DayCellPane(label,workLbl,cc);
    }

}
