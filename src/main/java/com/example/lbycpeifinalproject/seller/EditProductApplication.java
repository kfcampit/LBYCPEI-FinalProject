package com.example.lbycpeifinalproject.seller;

import com.example.lbycpeifinalproject.HelloApplication;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EditProductApplication extends Application {
    private static int productIndex = 0;

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("seller/edit-product.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 420);
        stage.setTitle("Edit Product");


        stage.setScene(scene);
        stage.show();
    }

    public static int getProductIndex() {
        return productIndex;
    }

    public static void main(String[] args) {
        launch();
    }

}
