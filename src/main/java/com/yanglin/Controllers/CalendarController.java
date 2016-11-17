package com.yanglin.Controllers;

import com.yanglin.Models.DayFactory;
import com.yanglin.Models.DayModel;
import com.yanglin.Models.Event;
import com.yanglin.Service.CalendarManager;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CalendarController
{
    @Autowired
    private CalendarManager calendarManager;

    @FXML
    private BorderPane calendarPane;

    @FXML
    private TableView calendarTableView;

    @FXML
    private Label lblMon1;

    @FXML
    private Button testBtn;

    public CalendarController(CalendarManager calendarManager)
    {
        this.calendarManager = calendarManager;

    }
    @FXML
    public void initialize()
    {
        /* test
        day = DayFactory.getInstance().createDay(1,1,1991);
        Calendar start = Calendar.getInstance();
        start.set(1991,Calendar.JANUARY,1,24,1);
        Calendar end = Calendar.getInstance();
        end.set(1991,Calendar.JANUARY,1,24,15);
        day.addEvent(new Event("x",start,end,1));
        lblMon1.textProperty().bind(Bindings.convert(day.getDayProp()));
        lVMon0.setItems(day.getEvents());
        */
    }



    @FXML
    public void test()
    {
        /*
        Random rand = new Random();
        day.setDay(rand.nextInt(50));
        day.getEvents().get(0).setTitle(String.valueOf(rand.nextInt(20)));
        Calendar start = Calendar.getInstance();
        start.set(1991,Calendar.JANUARY,1,24,1);
        Calendar end = Calendar.getInstance();
        end.set(1991,Calendar.JANUARY,1,24,15);
        day.addEvent(new Event("x", start, end,1));
        day.getEvents().notifyAll();
        */


    }
}
