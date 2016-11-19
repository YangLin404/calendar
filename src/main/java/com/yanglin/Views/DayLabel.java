package com.yanglin.Views;

import javafx.scene.control.Label;

public class DayLabel extends Label
{
    public DayLabel()
    {
        super();
        this.getStyleClass().add("dayLbl");
        this.setPrefSize(Double.MAX_VALUE,200);
    }
}
