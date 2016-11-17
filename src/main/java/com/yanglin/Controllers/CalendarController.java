package com.yanglin.Controllers;
import com.yanglin.Models.DayModel;
import com.yanglin.Service.CalendarManager;
import com.yanglin.Utils.Helper;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.LinkedList;
import java.util.SortedSet;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class CalendarController
{
    private final static Logger LOGGER = Logger.getLogger(CalendarController.class.getName());


    @Autowired
    private CalendarManager calendarManager;

    @FXML
    private BorderPane calendarPane;

    @FXML
    private GridPane calendarGridPane;

    @FXML
    private Button testBtn;

    private LinkedList<Label> dayLbls;
    private SortedSet<DayModel> currentDisplayingDays;

    public CalendarController(CalendarManager calendarManager)
    {
        this.calendarManager = calendarManager;
        ConsoleHandler hl = new ConsoleHandler();
        hl.setLevel(Level.ALL);
        LOGGER.addHandler(hl);
        LOGGER.setLevel(Level.ALL);

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
        initCurrentDisplayingDays();
        constructDayLbls();
        initDayLbls();
    }

    private void initDayLbls()
    {
        LOGGER.log(Level.INFO, "initing day lbls");
        int start = this.currentDisplayingDays.first().getWeekday().getIndex();
        for (DayModel d : this.currentDisplayingDays)
        {

            this.dayLbls.get(start).setText(String.valueOf(d.getDay()));
            start++;
        }
        LOGGER.log(Level.INFO, "day lbls inizialized. count:{0}",this.dayLbls.size());
    }

    private void initCurrentDisplayingDays()
    {
        currentDisplayingDays = calendarManager.getDaysByMonthYear(Helper.getCurrentYear(), Helper.getCurrentMonth());
    }

    private void constructDayLbls()
    {
        LOGGER.log(Level.INFO, "starting to constructing day lbls");
        this.dayLbls = new LinkedList<>();
        for (int i=0; i<6; i++)
        {
            for (int j=0; j<6; j++)
            {
                Label label = new Label("x");
                this.dayLbls.add(label);
                this.calendarGridPane.add(label,j,i);
            }
        }
        LOGGER.log(Level.INFO, "constructing day lbls finished");
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
