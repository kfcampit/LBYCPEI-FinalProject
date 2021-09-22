package com.example.lbycpeifinalproject.buyer;

import com.example.lbycpeifinalproject.MainHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SeeCart extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(MainHandler.class.getResource("buyer/see-cart.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("SeeCart");
        stage.setScene(scene);
        stage.show();
    }
}
