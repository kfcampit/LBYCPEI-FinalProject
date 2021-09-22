package com.example.lbycpeifinalproject.buyer;

import com.example.lbycpeifinalproject.misc.CartController;
import com.example.lbycpeifinalproject.misc.CartObject;
import com.example.lbycpeifinalproject.misc.DatabaseController;
import com.example.lbycpeifinalproject.seller.ManageProducts;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;

public class ViewProductController {
    DatabaseController dc = new DatabaseController();
    CartController cc = new CartController();
    private int productIndex;

    @FXML
    public Text nameText;

    @FXML
    public Text priceText;

    @FXML
    public Text stockText;

    @FXML
    public Text categoriesText;

    @FXML
    public Button addToCartButton;

    @FXML
    public ImageView productImage;

    @FXML
    public Text descriptionText;

    @FXML
    public TextField quantityText;

    @FXML
    private void onAddToCart() throws Exception {
        boolean inCart = false;
        int indexInCart = 0;
        if (Integer.parseInt(quantityText.getText()) > 0 && Integer.parseInt(quantityText.getText()) < dc.products[productIndex].getQuantityInStock()) {

            for (int i = 0; i < cc.numberCartItems ; i++) {
                if (cc.cart[i].getId() == dc.products[productIndex].getId()) {
                    indexInCart = i;
                    inCart = true;
                    break;
                }
            }

            dc.products[productIndex].setQuantityInStock(dc.products[productIndex].getQuantityInStock() - Integer.parseInt(quantityText.getText()));

            if (inCart) {
                int currentQuantity = cc.cart[indexInCart].getQuantity();
                cc.cart[indexInCart].setQuantity(currentQuantity + Integer.parseInt(quantityText.getText()));
                System.out.println(cc.cart[indexInCart].getId());
                System.out.println(currentQuantity + Integer.parseInt(quantityText.getText()));
            } else {
                cc.cart[cc.numberCartItems] = new CartObject();
                cc.cart[cc.numberCartItems].setId(dc.products[productIndex].getId());
                cc.cart[cc.numberCartItems].setQuantity(Integer.parseInt(quantityText.getText()));
            }

            dc.updateDatabase(dc.numberProducts - 1);

            try {
                cc.updateCart(cc.numberCartItems - 1);
                addToCartButton.getScene().getWindow().hide();
                if (ViewProduct.getFromSearch()) {
                    SearchForProduct sfp = new SearchForProduct();

                    try {
                        Stage stage = new Stage();
                        sfp.start(stage);
                    } catch (Exception ignore) {
                    }
                } else {
                    Catalogue c = new Catalogue();
                    try {
                        Stage stage = new Stage();
                        c.start(stage);
                    } catch (Exception ignore) {
                    }
                }
            } catch (Exception ignore) {
            }
        }


    }

    @FXML
    private void onHome() {
        addToCartButton.getScene().getWindow().hide();
        if (ViewProduct.getFromSearch()) {
            SearchForProduct sfp = new SearchForProduct();

            try {
                Stage stage = new Stage();
                sfp.start(stage);
            } catch (Exception ignore) {
            }
        } else {
            Catalogue c = new Catalogue();
            try {
                Stage stage = new Stage();
                c.start(stage);
            } catch (Exception ignore) {
            }
        }

    }

    public void initialize() throws Exception {
        dc.loadDatabase();
        cc.loadCart();
        productIndex = ViewProduct.getProductIndex();

        try {
            File file = new File("src/main/assets/product-images/" + dc.products[productIndex].imageFileName[0]);
            productImage.setImage(new Image(file.toURI().toString()));
        } catch (Exception e) {
        }

        if (dc.products[productIndex].getQuantityInStock() <= 0) {
            addToCartButton.setVisible(false);
        }

        nameText.setText(dc.products[productIndex].getName());
        priceText.setText(String.valueOf(dc.products[productIndex].getPrice()));
        stockText.setText(String.valueOf(dc.products[productIndex].getQuantityInStock()));
        descriptionText.setText(dc.products[productIndex].getDescription());
        categoriesText.setText(String.join(", ", dc.products[productIndex].getCategory()));
    }
}
