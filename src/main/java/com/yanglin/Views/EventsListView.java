package com.yanglin.Views;
import javafx.scene.control.ListView;


public class EventsListView<T> extends ListView<T>
{
    public EventsListView()
    {
        super();
        this.getStyleClass().add("eventsListView");
        this.setPickOnBounds(false);
    }
}
