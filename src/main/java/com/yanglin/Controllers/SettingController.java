package com.yanglin.Controllers;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.springframework.stereotype.Controller;

/**
 * Created by yanglin on 1/01/17.
 */

@Controller
public class SettingController
{
    @FXML
    private Button devSettingBtn;


    public SettingController()
    {
        addActionListeners();
    }

    private void addActionListeners()
    {
    }


}
