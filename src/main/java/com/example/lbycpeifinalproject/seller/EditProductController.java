package com.example.lbycpeifinalproject.seller;

import com.example.lbycpeifinalproject.misc.DatabaseController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class EditProductController {
    DatabaseController dc = new DatabaseController();
    public int productIndex;

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
    protected void onSaveImageOne() {
        dc.products[productIndex].imageFileName[0] = imageTextBoxOne.getText();
    }
    @FXML
    protected void onSaveImageTwo() {
        dc.products[productIndex].imageFileName[1] = imageTextBoxOne.getText();
    }
    @FXML
    protected void onSaveImageThree() {
        dc.products[productIndex].imageFileName[2] = imageTextBoxOne.getText();
    }
    @FXML
    protected void onSaveImageFour() {
        dc.products[productIndex].imageFileName[3] = imageTextBoxOne.getText();
    }

    @FXML
    protected void onCancelButton() {

    }

    @FXML
    protected void onSaveButton() {

    }

    public void initialize() throws Exception {
        productIndex = EditProductApplication.getProductIndex();

        //productImage.setImage(new Image("src/main/assets/product-images/" + dc.products[productIndex].imageFileName[0]));
        dc.loadDatabase();

        try {
            imageTextBoxOne.setText(dc.products[productIndex].imageFileName[0]);
            imageTextBoxTwo.setText(dc.products[productIndex].imageFileName[1]);
            imageTextBoxThree.setText(dc.products[productIndex].imageFileName[2]);
            imageTextBoxFour.setText(dc.products[productIndex].imageFileName[3]);
        } catch (Exception ignored) {
        }


        inputProductName.setText(dc.products[productIndex].getName());
        inputPrice.setText(String.valueOf(dc.products[productIndex].getPrice()));
        inputQuantity.setText(String.valueOf(dc.products[productIndex].getQuantityInStock()));
        inputProductDescription.setText(dc.products[productIndex].getDescription());
        inputCategories.setText(String.join(", ", dc.products[productIndex].getCategory()));
    }
}
