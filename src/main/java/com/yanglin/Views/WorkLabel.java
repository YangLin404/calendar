package com.yanglin.Views;

import com.yanglin.Models.Work;
import javafx.scene.control.Label;

/**
 * Created by yanglin on 1/12/16.
 */
public class WorkLabel extends Label
{
    public WorkLabel()
    {
        this.setPrefWidth(Double.MAX_VALUE);
    }

    public void setValue(Work work)
    {
        this.getStyleClass().removeAll();
        this.getStyleClass().addAll("lbl","lbl-"+work.getStyleClass(), "workLbl");
        this.setText(work.name());

    }
}
