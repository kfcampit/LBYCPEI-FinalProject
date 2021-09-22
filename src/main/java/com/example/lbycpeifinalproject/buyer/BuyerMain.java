package com.example.lbycpeifinalproject.buyer;

import com.example.lbycpeifinalproject.MainHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BuyerMain extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(MainHandler.class.getResource("buyer/buyer-main.fxml"));
        Scene scene = new Scene((fxmlLoader.load()), 600, 400);
        stage.setTitle("Main Menu");
        stage.setScene(scene);
        stage.show();
    }
}
