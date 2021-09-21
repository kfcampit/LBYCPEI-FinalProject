package com.example.lbycpeifinalproject.seller;

import com.example.lbycpeifinalproject.misc.DatabaseController;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.File;

public class EditProductController {
    DatabaseController dc = new DatabaseController();
    public int productIndex = 0;

    @FXML
    public ImageView productImage;

    @FXML
    public TextField inputProductName;

    @FXML
    public TextField inputPrice;

    @FXML
    public TextField inputQuantity;

    @FXML
    public TextArea inputProductDescription;

    @FXML
    public TextField inputCategories;

    @FXML
    public Text errorMessage;

    @FXML
    public TextField imageTextBoxOne;

    @FXML
    public TextField imageTextBoxTwo;

    @FXML
    public TextField imageTextBoxThree;

    @FXML
    public TextField imageTextBoxFour;

    @FXML
    protected void showImageOne() {
        try {
            File file = new File("src/main/assets/product-images/" + imageTextBoxOne.getText());
            productImage.setImage(new Image(file.toURI().toString()));
        } catch (Exception e) {
            errorMessage.setText("Image Not Found");
            errorMessage.setVisible(true);
        }
    }

    @FXML
    protected void showImageTwo() {
        try {
            File file = new File("src/main/assets/product-images/" + imageTextBoxTwo.getText());
            productImage.setImage(new Image(file.toURI().toString()));
        } catch (Exception e) {
            errorMessage.setText("Image Not Found");
            errorMessage.setVisible(true);
        }
    }

    @FXML
    protected void showImageThree() {
        try {
            File file = new File("src/main/assets/product-images/" + imageTextBoxThree.getText());
            productImage.setImage(new Image(file.toURI().toString()));
        } catch (Exception e) {
            errorMessage.setText("Image Not Found");
            errorMessage.setVisible(true);
        }
    }

    @FXML
    protected void showImageFour() {
        try {
            File file = new File("src/main/assets/product-images/" + imageTextBoxFour.getText());
            productImage.setImage(new Image(file.toURI().toString()));
        } catch (Exception e) {
            errorMessage.setText("Image Not Found");
            errorMessage.setVisible(true);
        }
    }

    @FXML
    protected void onCancelButton() {
        Platform.exit();
    }

    @FXML
    protected void onSaveButton() {
        try {
            String[] imageName = new String[]{
                    imageTextBoxOne.getText(),
                    imageTextBoxTwo.getText(),
                    imageTextBoxThree.getText(),
                    imageTextBoxFour.getText()
            };
            String[] categories = inputCategories.getText().split(",");
            String name = inputProductName.getText();
            String description = inputProductDescription.getText();
            double price = Double.parseDouble(inputProductName.getText());
            int quantity = Integer.parseInt(inputQuantity.getText());

            dc.products[productIndex].setImageFileName(imageName);
            dc.products[productIndex].setName(name);
            dc.products[productIndex].setPrice(price);
            dc.products[productIndex].setQuantityInStock(quantity);
            dc.products[productIndex].setDescription(description);
            dc.products[productIndex].setCategory(categories);

            Platform.exit();
        } catch (Exception e) {
            errorMessage.setText("Invalid Input. Please Try Again");
            errorMessage.setVisible(true);
        }
    }

    public void initialize() throws Exception {
        dc.loadDatabase();
        productIndex = EditProductApplication.getProductIndex();

        try {
            imageTextBoxOne.setText(dc.products[productIndex].imageFileName[0]);
            imageTextBoxTwo.setText(dc.products[productIndex].imageFileName[1]);
            imageTextBoxThree.setText(dc.products[productIndex].imageFileName[2]);
            imageTextBoxFour.setText(dc.products[productIndex].imageFileName[3]);
        } catch (Exception ignored) {
        }

        try {
            File file = new File("src/main/assets/product-images/" + dc.products[productIndex].imageFileName[0]);
            productImage.setImage(new Image(file.toURI().toString()));
        } catch (Exception e) {
            errorMessage.setText("Image Not Found");
            errorMessage.setVisible(true);
        }

        inputProductName.setText(dc.products[productIndex].getName());
        inputPrice.setText(String.valueOf(dc.products[productIndex].getPrice()));
        inputQuantity.setText(String.valueOf(dc.products[productIndex].getQuantityInStock()));
        inputProductDescription.setText(dc.products[productIndex].getDescription());
        inputCategories.setText(String.join(", ", dc.products[productIndex].getCategory()));
    }
}
