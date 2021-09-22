package com.example.lbycpeifinalproject.buyer;

import com.example.lbycpeifinalproject.MainHandler;
import com.example.lbycpeifinalproject.misc.DatabaseController;
import com.example.lbycpeifinalproject.misc.ProductObject;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.*;

public class SearchForProduct extends Application {
    static DatabaseController dc = new DatabaseController();
    @Override
    public void start(Stage stage) throws Exception {
        dc.loadDatabase();
        FXMLLoader fxmlLoader = new FXMLLoader(MainHandler.class.getResource("buyer/search-product.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Chopee - Search");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
