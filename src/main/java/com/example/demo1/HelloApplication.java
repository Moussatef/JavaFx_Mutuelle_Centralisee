package com.example.demo1;

import com.example.demo1.mail.MaileSend;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloApplication extends Application {
    private static Stage stg;

    @Override
    public void start(Stage stage) throws IOException {

        stg = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("forms/login-form.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().addAll(HelloApplication.class.getResource("assets/style.css").toExternalForm());
        //stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Welcome");
        stage.setScene(scene);
        stage.show();
    }
    public void changeScene(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("forms/" + fxml));
        stg.setScene(new Scene(fxmlLoader.load()));
    }

    public static void main(String[] args) {
        launch();
    }
}