package com.example.lbycpeifinalproject.seller;

import com.example.lbycpeifinalproject.MainHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EditProductApplication extends Application {
    private static int productIndex;
    private static boolean isAdd = false;

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

    public void setProductIndex(int productIndex) {
        EditProductApplication.productIndex = productIndex;
    }

    public static boolean getAdd() {return isAdd;}

    public void setAddTrue() {
        isAdd = true;
    }

    public static void main(String[] args) {
        launch();
    }

}
