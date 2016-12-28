package com.yanglin.Views;

import com.yanglin.Controllers.CalendarController;
import com.yanglin.Models.CalendarViewModel;
import com.yanglin.Models.Work;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.controlsfx.control.PopOver;

/**
 * Created by yanglin on 27/11/16.
 */
public class EventPopOver extends PopOver
{
    private CalendarViewModel cvm;
    private CalendarController cc;
    private Label date;

    public EventPopOver(CalendarViewModel cvm, CalendarController cc)
    {
        super();
        this.cc = cc;
        this.date = new Label();
        constructLayout();
        addEvents();
    }

    private void addEvents()
    {

    }

    private void constructLayout()
    {
        BorderPane borderPane = new BorderPane();
        borderPane.getStyleClass().add("h1");
        borderPane.setTop(date);

        VBox vBox = new VBox();
        //SegmentedButton segmentedButton = new SegmentedButton(new ToggleButton("xx"), new ToggleButton("yy"));
        //vBox.getChildren().addAll(segmentedButton);
        constructWorkBtns(vBox);
        borderPane.setCenter(vBox);

        this.setContentNode(borderPane);
    }

    @Override
    protected void show()
    {
        super.show();
        DayCellPane ownerPane = (DayCellPane) this.getOwnerNode();
        this.date.setText(ownerPane.getDayModel().toString());
        this.date.getStyleClass().addAll("lbl","lbl-default");
    }

    private void constructWorkBtns(VBox vBox)
    {
        HBox btnGroup = new HBox();
        btnGroup.getStyleClass().add("btn-group-horizontal");

        for (Work w : Work.values())
        {
            Button btn = new Button(w.name());
            btn.getStyleClass().addAll("btn","btn-"+w.getStyleClass());
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
            btn.setOnAction(event ->
            {
                Button clickedBtn = (Button) event.getSource();
                DayCellPane dayCellPane = (DayCellPane) this.getOwnerNode();
                Work selectedWork = Work.valueOf(clickedBtn.getText());
                cc.changeDayWork(dayCellPane.getDayModel(),selectedWork,dayCellPane);
                this.hide();
            });
            btnGroup.getChildren().add(btn);

        }
        vBox.getChildren().add(btnGroup);
    }
}
