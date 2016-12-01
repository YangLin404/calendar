package com.yanglin.Views;

import com.yanglin.Controllers.CalendarController;
import com.yanglin.Models.CalendarViewModel;
import com.yanglin.Models.Work;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import org.controlsfx.control.PopOver;
import org.controlsfx.control.SegmentedButton;
import org.controlsfx.tools.Borders;
import org.springframework.cglib.core.internal.Function;

import java.util.LinkedList;

/**
 * Created by yanglin on 27/11/16.
 */
public class EventPopOver extends PopOver
{
    private CalendarViewModel cvm;
    public EventPopOver(CalendarViewModel cvm)
    {
        super();
        constructLayout();
    }

    private void constructLayout()
    {
        BorderPane borderPane = new BorderPane();
        Label label = new Label("werken:");
        borderPane.setTop(label);

        VBox vBox = new VBox();
        //SegmentedButton segmentedButton = new SegmentedButton(new ToggleButton("xx"), new ToggleButton("yy"));
        //vBox.getChildren().addAll(segmentedButton);
        constructWorkBtns(vBox);
        borderPane.setCenter(vBox);

        this.setContentNode(borderPane);
    }

    private void constructWorkBtns(VBox vBox)
    {
        HBox btnGroup = new HBox();
        btnGroup.getStyleClass().add("btn-group-horizontal");

        for (Work w : Work.values())
        {
            Button btn = new Button(w.name());
            btn.getStyleClass().addAll("btn",w.getStyleClass());
            if (w.ordinal() == 0)
            {
                btn.getStyleClass().add("first");
            }
            else if (w.ordinal() == Work.values().length-1)
            {
                btn.getStyleClass().add("last");
            }
            else
            {
                btn.getStyleClass().add("middle");
            }
            btnGroup.getChildren().add(btn);

        }
        vBox.getChildren().add(btnGroup);
    }
}
