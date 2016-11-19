package com.yanglin.Views;

import javafx.scene.control.Label;


public class WeekdayLabel extends DayLabel
{
    public WeekdayLabel()
    {
        super();
        this.getStyleClass().addAll("weekdayLbl");
        this.setPrefSize(Double.MAX_VALUE,200);
    }
}
