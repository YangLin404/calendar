package com.yanglin.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by yanglin on 13/11/16.
 */
public class MainController
{
    @FXML
    private Tab CalendarTab;

    @FXML
    private BorderPane CalendarPane;

    @FXML
    @Autowired
    private CalendarController calendarController;

    public MainController(CalendarController calendarController)
    {
        this.calendarController = calendarController;
    }
}
