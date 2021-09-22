package com.example.lbycpeifinalproject.buyer;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BuyerMainController {
    @FXML
    public Button viewCatalogueButton;

    @FXML
    private void onViewCatalogue() {
        //TODO: insert view catalogue
        Catalogue catalogue = new Catalogue();
        try {
            Stage stage = new Stage();
            catalogue.start(stage);
        } catch (Exception ignore) {}
    }

    @FXML
    private void onSearchProduct() {
        //TODO: insert search product
    }
    @FXML
    private void onSeeCart() {
        SeeCart dc = new SeeCart();
        viewCatalogueButton.getScene().getWindow().hide();

        try {
            Stage stage = new Stage();
            dc.start(stage);
        } catch (Exception ignore) {
        }
    }

    @FXML
    private void onExit() {
        Platform.exit();
    }

}
