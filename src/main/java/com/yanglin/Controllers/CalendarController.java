package com.yanglin.Controllers;

import com.yanglin.Service.CalendarManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
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
    private GridPane calendarGrid;

    @FXML
    private Button myButton;

    public CalendarController(CalendarManager calendarManager)
    {
        this.calendarManager = calendarManager;

    }
    @FXML
    public void test()
    {
        ListView listView = new ListView();
        ObservableList<String> items = FXCollections.observableArrayList ("Single", "Double", "Suite", "Family App");
        listView.setItems(items);
        this.calendarGrid.add(listView,1,1);
    }
}
