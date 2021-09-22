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
        Catalogue catalogue = new Catalogue();
        viewCatalogueButton.getScene().getWindow().hide();

        try {
            Stage stage = new Stage();
            catalogue.start(stage);
        } catch (Exception ignore) {}
    }

    @FXML
    private void onSearchProduct() {
        SearchForProduct sfp = new SearchForProduct();
        viewCatalogueButton.getScene().getWindow().hide();

        try {
            Stage stage = new Stage();
            sfp.start(stage);
        } catch (Exception ignore) {}
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
