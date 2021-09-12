package com.example.lbycpeifinalproject.buyer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    public Button registerButton;
    public Button loginButton;
    public TextField usernameField;
    public PasswordField passwordField;
    public void loginPressed(ActionEvent actionEvent) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        // TODO: Implement actions on each login state.
        if (Login.loginCredentials(username,password)){
            System.out.println("Login success");
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
}
