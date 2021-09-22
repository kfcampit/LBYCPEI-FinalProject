package com.example.lbycpeifinalproject.buyer;

import com.example.lbycpeifinalproject.misc.CartController;
import com.example.lbycpeifinalproject.misc.CartObject;
import com.example.lbycpeifinalproject.misc.DatabaseController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CheckoutController {
    CartController cc = new CartController();

    @FXML
    public Text finalPrice;

    @FXML
    public void onHome(ActionEvent actionEvent) {
        BuyerMain bm = new BuyerMain();
        finalPrice.getScene().getWindow().hide();

        try {
            Stage stage = new Stage();
            bm.start(stage);
        } catch (Exception ignore) {
        }
    }

    public void initialize() throws Exception {
        double totalNumPrice = Checkout.getFinalPrice();
        finalPrice.setText(String.format("Php %.2f", totalNumPrice));
    }
}
