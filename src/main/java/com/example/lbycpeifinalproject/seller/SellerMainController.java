package com.example.lbycpeifinalproject.seller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SellerMainController {
    @FXML
    public Button manageProducts;

    @FXML
    private void onManageProducts() {
        ManageProducts mp = new ManageProducts();
        manageProducts.getScene().getWindow().hide();

        try {
            Stage stage = new Stage();
            mp.start(stage);
        } catch (Exception ignore) {
        }
    }

    @FXML
    private void onExit() {
        Platform.exit();
    }
}
