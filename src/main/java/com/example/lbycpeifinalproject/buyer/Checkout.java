package com.example.lbycpeifinalproject.buyer;

import com.example.lbycpeifinalproject.MainHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Checkout extends Application {
    private static double finalPrice;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(MainHandler.class.getResource("buyer/checkout.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Checkout");
        stage.setScene(scene);
        stage.show();
    }

    public void setFinalPrice(double finalPrice) {
        Checkout.finalPrice = finalPrice;
    }

    public static double getFinalPrice() {
        return finalPrice;
    }
}
