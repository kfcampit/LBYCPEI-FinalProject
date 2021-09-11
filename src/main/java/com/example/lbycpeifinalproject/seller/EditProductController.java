package com.example.lbycpeifinalproject.seller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class EditProductController {

    @FXML
    public ImageView productImage;
    @FXML
    public Button saveImageButtonOne;
    @FXML
    public Button saveImageButtonTwo;
    @FXML
    public Button saveImageButtonThree;
    @FXML
    public Button saveImageButtonFour;
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
    public Button editProductCancel;
    @FXML
    public Button editProductSave;
    @FXML
    public Text errorMessage;
}
