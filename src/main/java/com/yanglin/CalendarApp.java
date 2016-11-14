package com.yanglin;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(AppConfig.class)
public class CalendarApp extends Application {

    private ConfigurableApplicationContext springContext;
    private Parent rootNode;


    public static void main(String[] args) {
        launch(args);
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
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    @Override
    public void stop() throws Exception {
        springContext.close();
    }




}