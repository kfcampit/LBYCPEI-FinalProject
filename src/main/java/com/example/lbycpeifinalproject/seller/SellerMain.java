package com.example.lbycpeifinalproject.seller;

import com.example.lbycpeifinalproject.MainHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SellerMain extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(MainHandler.class.getResource("seller/seller-main.fxml"));
        Scene scene = new Scene((fxmlLoader.load()), 600, 400);
        stage.setTitle("Manage Products");
        stage.setScene(scene);
        stage.show();
    }
}
