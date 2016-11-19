package com.yanglin.Controllers;
import com.yanglin.Models.DayModel;
import com.yanglin.Models.Event;
import com.yanglin.Models.Month;
import com.yanglin.Models.Weekday;
import com.yanglin.Service.CalendarManager;
import com.yanglin.Utils.Helper;
import com.yanglin.Views.DayLabel;
import com.yanglin.Views.EventsListView;
import com.yanglin.Views.MyVBox;
import com.yanglin.Views.WeekdayLabel;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.LinkedList;
import java.util.Random;
import java.util.SortedSet;
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
    @FXML
    private Label testLbl;

    private LinkedList<MyVBox> dayCells;
    private LinkedList<DayLabel> dayLbls;
    private LinkedList<WeekdayLabel> weekdayLabels;
    private LinkedList<EventsListView<Event>> eventsLvs;
    private SortedSet<DayModel> currentDisplayingDays;

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
        initCurrentDisplayingDays();
        constructDayCells();
        initDayCells();
        initWeekDayCells();
        addEventHandlersToDayCells();
    }

    private void addEventHandlersToDayCells()
    {

    }

    private void initWeekDayCells()
    {
        LOGGER.log(Level.INFO, "initing weekday cells");
        for (Weekday w : Weekday.values())
        {
            WeekdayLabel weekdayLabel = this.weekdayLabels.get(w.getIndex());
            weekdayLabel.setText(w.getAfkorting());
            weekdayLabel.getStyleClass().add("weekdayCell");
        }
        LOGGER.log(Level.INFO, "weekday cells initialized.");
    }

    private void initDayCells()
    {
        resetDaycells();
        LOGGER.log(Level.INFO, "initing day cell");
        int start = this.currentDisplayingDays.first().getWeekday().getIndex();
        for (DayModel d : this.currentDisplayingDays)
        {

            this.dayLbls.get(start).setText(String.valueOf(d.getDay()));
            this.eventsLvs.get(start).setItems(d.getEvents());
            start++;
        }
        LOGGER.log(Level.INFO, "day cell initialized. count:{0}",this.dayCells.size());
    }

    private void initCurrentDisplayingDays()
    {
        currentDisplayingDays = calendarManager.getDaysByMonthYear(Helper.getCurrentYear(), Helper.getCurrentMonth());
    }

    private void resetDaycells()
    {
        LOGGER.log(Level.INFO, "starting to resetting day lbl");
        for (DayLabel d: dayLbls)
        {
            d.setText("");
        }
        LOGGER.log(Level.INFO, "resetting day lbl completed");
        LOGGER.log(Level.INFO, "starting to resetting eventslistview");
        for (ListView<Event> lv: eventsLvs)
        {
            lv.setItems(null);
        }
        LOGGER.log(Level.INFO, "resetting eventslistview completed");
    }

    private void constructDayCells()
    {
        LOGGER.log(Level.INFO, "starting to constructing day cells");

        this.dayCells = new LinkedList<>();
        this.dayLbls = new LinkedList<>();
        this.weekdayLabels = new LinkedList<>();
        this.eventsLvs = new LinkedList<>();
        for (int i=0; i<7; i++)
        {
            for (int j=0; j<7; j++)
            {
                MyVBox vBox;
                if (i==0)
                {
                    WeekdayLabel weekdayLabel = new WeekdayLabel();
                    this.weekdayLabels.add(weekdayLabel);
                    vBox = new MyVBox(weekdayLabel);
                }
                else
                {
                    DayLabel label = new DayLabel();
                    EventsListView<Event> listView = new EventsListView<>();
                    vBox = new MyVBox(label, listView);
                    this.dayLbls.add(label);
                    this.eventsLvs.add(listView);

                }
                this.dayCells.add(vBox);
                this.calendarGridPane.add(vBox, j, i);
            }
        }
        LOGGER.log(Level.INFO, "constructing day lbls finished");
    }


    @FXML
    public void test()
    {
        Random random = new Random();
        Month month = Month.getMonthFromDigit(random.nextInt(12));
        currentDisplayingDays = calendarManager.getDaysByMonthYear(2016, Month.JARUARI);
        this.testLbl.setText(month.JARUARI.name());
        initDayCells();

    }
}
