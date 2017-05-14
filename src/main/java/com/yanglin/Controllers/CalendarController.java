package com.yanglin.Controllers;
import com.yanglin.Models.*;
import com.yanglin.Service.CalendarManager;
import com.yanglin.Utils.Helper;
import com.yanglin.Views.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.print.*;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.transform.Scale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.LinkedList;
import java.util.SortedSet;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class CalendarController
{
    private final static Logger LOGGER = Logger.getLogger(CalendarController.class.getName());


    private CalendarManager cm;
    private DayCellFactory dayCellFactory;

    @FXML
    private BorderPane calendarPane;

    @FXML
    private GridPane calendarGridPane;

    @FXML
    private Label monthLbl;
    @FXML
    private Label yearLbl;

    @FXML
    private Button preBtn;
    @FXML
    private Button currentBtn;
    @FXML
    private Button nextBtn;

    private LinkedList<DayCellPane> dayCells;
    private CalendarViewModel calendarViewModel;
    private LinkedList<DayLabel> weekdayCells;

    @Autowired
    public CalendarController(CalendarManager cm, DayCellFactory dayCF)
    {
        this.cm = cm;
        this.dayCellFactory = dayCF;

    }
    @FXML
    public void initialize()
    {
        this.calendarViewModel = new CalendarViewModel();
        updateCalendarViewModel(Helper.getCurrentYear(),Helper.getCurrentMonth());
        setLayoutToGridPane();
        constructWeekdayCells();
        constructDayCells();
        initDayCells();
        addEventHandlersToDayCells();
        bindProperties();
    }

    private void setLayoutToGridPane()
    {

    }

    private void constructWeekdayCells()
    {
        LOGGER.log(Level.INFO, "constructing weekday cells");
        this.weekdayCells = new LinkedList<>();
        int j=0;
        for (Weekday w : Weekday.values())
        {
            WeekdayLabel weekdayLabel = new WeekdayLabel();
            weekdayLabel.setText(w.getAfkorting());
            this.calendarGridPane.add(weekdayLabel, j, 0);
            j++;
        }
        LOGGER.log(Level.INFO, "weekday cells constructed.");
    }

    private void bindProperties()
    {
        this.monthLbl.textProperty().bind(this.calendarViewModel.getCurrentMonthStrProp());
        this.yearLbl.textProperty().bind(this.calendarViewModel.currentYearStrProperty());
    }

    private void addEventHandlersToDayCells()
    {

    }

    private void initDayCells()
    {
        resetDaycells();
        LOGGER.log(Level.INFO, "initing day cell");
        int start = this.calendarViewModel.getCurrentDays().first().getWeekday().getIndex();
        for (DayModel d : this.calendarViewModel.getCurrentDays())
        {
            DayCellPane crrDayCell = this.dayCells.get(start);
            crrDayCell.setDayModel(d);
            crrDayCell.getDayLbl().setText(String.valueOf(d.getDay()));
            crrDayCell.changeDayWork(d.getWork());
            crrDayCell.setOnMouseClicked((MouseEvent event) ->
            {
                //this.eventPopOver.show(crrDayCell,event.getScreenX(),event.getScreenY());
                EventPopOver eventPopOver = new EventPopOver(this);
                eventPopOver.show(crrDayCell,event.getScreenX(),event.getScreenY());
            });
            if (this.cm.isToday(d))
                crrDayCell.getDayLbl().setToday();
            start++;
        }
        LOGGER.log(Level.INFO, "day cell initialized. count:{0}",this.dayCells.size());
    }

    private void updateCalendarViewModel(int year, Month month)
    {
        this.calendarViewModel.setDays(cm.getDaysByMonthYear(year, month));
    }

    private void updateCalendarViewModel(SortedSet<DayModel> days)
    {
        this.calendarViewModel.setDays(days);
    }

    private void resetDaycells()
    {
        LOGGER.log(Level.INFO, "starting to resetting day lbl and eventslistview");
        calendarGridPane.getChildren().removeAll(this.dayCells);
            //v.getEventsLv().setItems(null);
        LOGGER.log(Level.INFO, "resetting day lbl and eventslistview completed");
        constructDayCells();
    }

    private void constructDayCells()
    {
        LOGGER.log(Level.INFO, "starting to constructing day cells");
        this.dayCells = dayCellFactory.createDaycells(this);
        LOGGER.log(Level.INFO, "constructing day lbls finished");
    }

    public void changeDayWork(DayModel d, Work w, DayCellPane dayCellPane)
    {
        this.getCm().setWorkToDay(d,w);
        dayCellPane.changeDayWork(w);
    }

    public void printCurrentPage()
    {
        PrinterJob printerJob = PrinterJob.createPrinterJob();
        PageLayout pageLayout = Printer.getDefaultPrinter().createPageLayout(Paper.A4,PageOrientation.LANDSCAPE, 0.5,0.5,0.5,0.5);
        printerJob.getJobSettings().setPrintQuality(PrintQuality.DRAFT);
        printerJob.getJobSettings().setPrintColor(PrintColor.MONOCHROME);
        GridPane paneToPrint = this.getCalendarGridPane();
        double scaleX
                = (pageLayout.getPrintableWidth()-5) / paneToPrint.getBoundsInParent().getWidth();
        double scaleY
                = (pageLayout.getPrintableHeight()-5) / paneToPrint.getBoundsInParent().getHeight();
        Scale scaleToPrint = new Scale(scaleX,scaleY);
        paneToPrint.getTransforms().add(scaleToPrint);

        if (printerJob.printPage(pageLayout,paneToPrint))
        {
            printerJob.endJob();
            paneToPrint.getTransforms().remove(scaleToPrint);
        }


    }

    public GridPane getCalendarGridPane()
    {
        return calendarGridPane;
    }

    public CalendarManager getCm()
    {
        return this.cm;
    }

    @FXML
    public void handlePreBtn(ActionEvent actionEvent)
    {
        updateCalendarViewModel(cm.getDaysOfPreMonth(this.calendarViewModel.getCurrentYear(), this.calendarViewModel.getCurrentMonth()));
        initDayCells();
    }
    @FXML
    public void handleCurrentMonthBtn(ActionEvent actionEvent)
    {
        updateCalendarViewModel(Helper.getCurrentYear(),Helper.getCurrentMonth());
        initDayCells();
    }
    @FXML
    public void handleNextMonthBtn(ActionEvent actionEvent)
    {
        this.calendarViewModel.setDays(cm.getDaysOfNextMonth(this.calendarViewModel.getCurrentYear(),this.calendarViewModel.getCurrentMonth()));
        initDayCells();
    }
}
