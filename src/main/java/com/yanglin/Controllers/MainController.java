package com.yanglin.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by yanglin on 13/11/16.
 */

@Controller
public class MainController
{
    @FXML
    private Tab CalendarTab;

    @FXML
    private BorderPane CalendarPane;

    @FXML
    private CalendarController calendarController;

    @Autowired
    public MainController(CalendarController calendarController)
    {
        this.calendarController = calendarController;
    }
}
