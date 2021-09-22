package com.example.lbycpeifinalproject.buyer;

import com.example.lbycpeifinalproject.MainHandler;
import com.example.lbycpeifinalproject.seller.EditProductApplication;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewProduct extends Application {
    private static int productIndex = 1;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(MainHandler.class.getResource("buyer/view-product.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("View Product");
        stage.setScene(scene);
        stage.show();
    }

    public static int getProductIndex() {
        return productIndex;
    }
    public void setProductIndex(int productIndex) {
        ViewProduct.productIndex = productIndex;
    }
}
