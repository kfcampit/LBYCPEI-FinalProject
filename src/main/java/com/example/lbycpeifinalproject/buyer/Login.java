package com.example.lbycpeifinalproject.buyer;

import com.example.lbycpeifinalproject.HelloApplication;
import com.example.lbycpeifinalproject.MainHandler;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import javafx.application.Application;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Objects;

public class Login extends Application {
    protected static HashMap<String,String> userCredentials = new HashMap<>();
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("buyer/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        getCredentialsCSV();
    }
    private void getCredentialsCSV() throws Exception {
        String csvPath = "src/main/assets/usercredentials.csv";
        FileReader fileReader = new FileReader(csvPath);
        CSVReader csvReader = new CSVReader(fileReader);
        String[] recordLine;

        while ((recordLine = csvReader.readNext()) != null){
            // recordLine index 0 = username, index 1 = password.
            userCredentials.put(recordLine[0],recordLine[1]);
        }

        fileReader.close();
        System.out.println(userCredentials);
    }
    protected static boolean loginCredentials(String username, String password){
        return userCredentials.containsKey(username) &&
                (Objects.equals(userCredentials.get(username), password));
    }
    protected static boolean registerCredentials(String username, String password) throws Exception {
        if (userCredentials.containsKey(username)) {
            return false;
        } else {
            String csvPath = "src/main/assets/usercredentials.csv";
            FileWriter fileWriter = new FileWriter(csvPath,true);
            CSVWriter csvWriter = new CSVWriter(fileWriter);

            String[] writeLine = {username,password};
            csvWriter.writeNext(writeLine);

            userCredentials.put(username,password);

            fileWriter.close();
            return true;
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
