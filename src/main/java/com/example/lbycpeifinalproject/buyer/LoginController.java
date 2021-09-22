package com.example.lbycpeifinalproject.buyer;

import com.example.lbycpeifinalproject.seller.SellerMain;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    @FXML
    public Button registerButton;
    public Button loginAsBuyerButton;
    public TextField usernameField;
    public PasswordField passwordField;
    // TODO: Implement actions on each login state.
    public void loginAsBuyerPressed(ActionEvent actionEvent) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        if (Login.loginCredentials(username,password)){
            System.out.println("Login as buyer, success");
            // TODO: Enter way to call other windows as Buyer.
            toBuyerMain();
        } else {
            System.out.println("Login failed");
        }
    }
    public void loginAsSellerPressed(ActionEvent actionEvent) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        if (Login.loginCredentials(username,password)){
            System.out.println("Login as seller, success");
            // TODO: Enter way to call other windows as Seller.
            toSellerMain();
        } else {
            System.out.println("Login failed");
        }
    }
    public void registerPressed(ActionEvent actionEvent) throws Exception {
        String username = usernameField.getText();
        String password = passwordField.getText();
        // Set TextFields to null to show PromptText.
        usernameField.setText(null);
        passwordField.setText(null);
        // Call registerCredentials() then check resulting boolean value.
        if (Login.registerCredentials(username,password)){
            usernameField.setPromptText("Successfully registered an account!");
            passwordField.setPromptText("Enter username and password to login");
        } else {
            usernameField.setPromptText("Username already exists!");
            passwordField.setPromptText("Login or choose a new username");
        }
    }

    private void toSellerMain() {
        SellerMain sm = new SellerMain();
        registerButton.getScene().getWindow().hide();

        try {
            Stage stage = new Stage();
            sm.start(stage);
        } catch (Exception ignore) {

        }
    }

    private void toBuyerMain() {
        BuyerMain bm = new BuyerMain();
        registerButton.getScene().getWindow().hide();

        try {
            Stage stage = new Stage();
            bm.start(stage);
        } catch (Exception ignore) {

        }
    }
}
