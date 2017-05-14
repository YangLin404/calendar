package com.yanglin;


import com.sun.javafx.application.LauncherImpl;
import com.yanglin.Views.MyPreloader;
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.print.PrinterJob;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CalendarApp extends Application {

    private ConfigurableApplicationContext springContext;
    private Parent rootNode;


    public static void main(String[] args) {
        //launch(args);
        LauncherImpl.launchApplication(CalendarApp.class, MyPreloader.class, args);
    }


    @Override
    public void init() throws Exception {
        springContext = SpringApplication.run(CalendarApp.class);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/mainView.fxml"));
        fxmlLoader.setControllerFactory(springContext::getBean);
        rootNode = fxmlLoader.load();
    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        Scene scene = new Scene(rootNode);
        scene.getStylesheets().add("bootstrapfx.css");
        scene.getStylesheets().addAll("/css/CalendarStyle.css","/css/EventPopOverStyle.css");
        primaryStage.setScene(scene);
        primaryStage.show();

    }



    @Override
    public void stop() throws Exception {
        springContext.close();
    }




}