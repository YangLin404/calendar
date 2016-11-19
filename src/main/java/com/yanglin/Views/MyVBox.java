package com.yanglin.Views;

import javafx.scene.Node;
import javafx.scene.layout.VBox;


public class MyVBox extends VBox
{
    public MyVBox(Node... nodes)
    {
        super(nodes);
        this.getStyleClass().add("dayBox");
    }
}
