package com.example.lbycpeifinalproject.seller;

import com.example.lbycpeifinalproject.MainHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EditProductApplication extends Application {
    private static int productIndex = 1;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(MainHandler.class.getResource("seller/edit-product.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 420);
        stage.setTitle("Edit Product");

        stage.setScene(scene);
        stage.show();
    }

    public static int getProductIndex() {
        return productIndex;
    }

    public static void setProductIndex(int productIndex) {
        EditProductApplication.productIndex = productIndex;
    }

    public static void main(String[] args) {
        launch();
    }

}
