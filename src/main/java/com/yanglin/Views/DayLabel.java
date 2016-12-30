package com.yanglin.Views;

import javafx.scene.control.Label;

public class DayLabel extends Label
{
    public DayLabel()
    {
        super();
        this.getStyleClass().add("dayLbl");
        //this.setPrefWidth(Double.MAX_VALUE);
    }

    public void setToday()
    {
        this.getStyleClass().add("todayLbl");
    }
}
