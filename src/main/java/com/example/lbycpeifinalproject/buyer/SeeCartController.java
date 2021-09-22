package com.example.lbycpeifinalproject.buyer;

import com.example.lbycpeifinalproject.misc.CartController;
import com.example.lbycpeifinalproject.misc.CartObject;
import com.example.lbycpeifinalproject.misc.DatabaseController;
import com.example.lbycpeifinalproject.misc.ProductObject;
import com.example.lbycpeifinalproject.seller.SellerMain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SeeCartController {
    DatabaseController dc = new DatabaseController();
    CartController cc = new CartController();
    private int currentPage = 0;
    private int totalPages;
    private double totalNumPrice = 0;

    @FXML
    public Text name1, name2, name3, name4, name5, name6, name7, name8, pageNum;

    @FXML
    public Text price1, price2, price3, price4, price5, price6, price7, price8, priceTotal;

    @FXML
    public Text quantity1, quantity2, quantity3, quantity4, quantity5, quantity6, quantity7, quantity8;
    
    @FXML
    public Button remove1, remove2, remove3, remove4, remove5, remove6, remove7, remove8, nextPage, prevPage;

    @FXML
    private void onHome() {
        BuyerMain bm = new BuyerMain();
        name1.getScene().getWindow().hide();

        try {
            Stage stage = new Stage();
            bm.start(stage);
        } catch (Exception ignore) {
        }
    }

    @FXML
    public void onCheckout(ActionEvent actionEvent) throws Exception {
        Checkout c = new Checkout();
        name1.getScene().getWindow().hide();
        cc.cart = new CartObject[cc.MAX_NUM];
        cc.updateCart(-1);

        try {
            Stage stage = new Stage();
            c.setFinalPrice(totalNumPrice);
            c.start(stage);
        } catch (Exception ignore) {
        }
    }

    @FXML
    public void onRemove1(ActionEvent actionEvent) {
        removeButton(0);
    }

    @FXML
    public void onRemove2(ActionEvent actionEvent) {
        removeButton(1);
    }

    @FXML
    public void onRemove3(ActionEvent actionEvent) {
        removeButton(2);
    }

    @FXML
    public void onRemove4(ActionEvent actionEvent) {
        removeButton(3);
    }

    @FXML
    public void onRemove5(ActionEvent actionEvent) {
        removeButton(4);
    }

    @FXML
    public void onRemove6(ActionEvent actionEvent) {
        removeButton(5);
    }

    @FXML
    public void onRemove7(ActionEvent actionEvent) {
        removeButton(6);
    }

    @FXML
    public void onRemove8(ActionEvent actionEvent) {
        removeButton(7);
    }

    private void removeButton(int i) {
        for (int j = i + (currentPage * 8); j < cc.numberCartItems; j++) {
            cc.cart[j] = cc.cart[j + 1];
        }
        cc.cart[cc.numberCartItems - 1] = new CartObject();
        cc.numberCartItems--;
        initContent();
        if (cc.numberCartItems < 8) {
            setVisibility((cc.numberCartItems) % 8);
        }

        try {
            cc.updateCart(cc.numberCartItems - 1);
        } catch (Exception ignored) {
        }
    }

    @FXML
    public void onPrevPage(ActionEvent actionEvent) {
        currentPage--;
        pageNum.setText((currentPage + 1) + "/" + totalPages);
        initContent();
    }

    @FXML
    public void onNextPage(ActionEvent actionEvent) {
        currentPage++;
        pageNum.setText((currentPage + 1) + "/" + totalPages);
        initContent();
    }

    private void setVisibility(int i) {
        switch (i) {
            case 0 -> {
                name1.setVisible(false);
                price1.setVisible(false);
                quantity1.setVisible(false);
                remove1.setVisible(false);
            }
            case 1 -> {
                name2.setVisible(false);
                price2.setVisible(false);
                quantity2.setVisible(false);
                remove2.setVisible(false);
            }
            case 2 -> {
                name3.setVisible(false);
                price3.setVisible(false);
                quantity3.setVisible(false);
                remove3.setVisible(false);
            }
            case 3 -> {
                name4.setVisible(false);
                price4.setVisible(false);
                quantity4.setVisible(false);
                remove4.setVisible(false);
            }
            case 4 -> {
                name5.setVisible(false);
                price5.setVisible(false);
                quantity5.setVisible(false);
                remove5.setVisible(false);
            }
            case 5 -> {
                name6.setVisible(false);
                price6.setVisible(false);
                quantity6.setVisible(false);
                remove6.setVisible(false);
            }
            case 6 -> {
                name7.setVisible(false);
                price7.setVisible(false);
                quantity7.setVisible(false);
                remove7.setVisible(false);
            }
            case 7 -> {
                name8.setVisible(false);
                price8.setVisible(false);
                quantity8.setVisible(false);
                remove8.setVisible(false);
            }
        }
    }

    public void initialize() throws Exception {
        dc.loadDatabase();
        cc.loadCart();
        totalPages = (int) Math.ceil(cc.numberCartItems / 8.0);
        pageNum.setText((currentPage + 1) + "/" + totalPages);
        initContent();
    }

    private int getIndexfromID(int id) {
        for (int i = 0; i < dc.numberProducts; i++) {
            System.out.println(id + " " + dc.products[i].getId());
            if (dc.products[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    private void initContent() {
        int currentIndex;

        if ((currentPage + 1) == totalPages) {
            nextPage.setVisible(false);
        }

        if ((currentPage + 1) == 1) {
            prevPage.setVisible(false);
        }

        totalNumPrice = 0;
        for (int i = 0; i < cc.numberCartItems; i++) {
            currentIndex = getIndexfromID(cc.cart[i].getId());
            totalNumPrice += dc.products[currentIndex].getPrice() * cc.cart[i].getQuantity();
        }

        priceTotal.setText(String.format("%.2f", totalNumPrice));

        if ((currentPage * 8) >= cc.numberCartItems) return;
        System.out.println(dc.products[(currentPage * 9)].getName() != null);
        name1.setVisible(true);
        price1.setVisible(true);
        quantity1.setVisible(true);
        remove1.setVisible(true);

        currentIndex = getIndexfromID(cc.cart[(currentPage * 8)].getId());
        name1.setText(dc.products[currentIndex].getName());
        price1.setText(String.valueOf(dc.products[currentIndex].getPrice()));
        quantity1.setText(String.valueOf(cc.cart[(currentPage * 8)].getQuantity()));

        if (1 + (currentPage * 8) >= cc.numberCartItems) return;
        name2.setVisible(true);
        price2.setVisible(true);
        quantity2.setVisible(true);
        remove2.setVisible(true);

        currentIndex = getIndexfromID(cc.cart[1 + (currentPage * 8)].getId());
        name2.setText(dc.products[currentIndex].getName());
        price2.setText(String.valueOf(dc.products[currentIndex].getPrice()));
        quantity2.setText(String.valueOf(cc.cart[1 + (currentPage * 8)].getQuantity()));


        if (2 + (currentPage * 8) >= cc.numberCartItems) return;
        name3.setVisible(true);
        price3.setVisible(true);
        quantity3.setVisible(true);
        remove3.setVisible(true);

        currentIndex = getIndexfromID(cc.cart[2 + (currentPage * 8)].getId());
        name3.setText(dc.products[currentIndex].getName());
        price3.setText(String.valueOf(dc.products[currentIndex].getPrice()));
        quantity3.setText(String.valueOf(cc.cart[2 + (currentPage * 8)].getQuantity()));

        if (3 + (currentPage * 8) >= cc.numberCartItems) return;
        name4.setVisible(true);
        price4.setVisible(true);
        quantity4.setVisible(true);
        remove4.setVisible(true);

        currentIndex = getIndexfromID(cc.cart[3 + (currentPage * 8)].getId());
        name4.setText(dc.products[currentIndex].getName());
        price4.setText(String.valueOf(dc.products[currentIndex].getPrice()));
        quantity4.setText(String.valueOf(cc.cart[3 + (currentPage * 8)].getQuantity()));

        if (4 + (currentPage * 8) >= cc.numberCartItems) return;
        name5.setVisible(true);
        price5.setVisible(true);
        quantity5.setVisible(true);
        remove5.setVisible(true);

        currentIndex = getIndexfromID(cc.cart[4 + (currentPage * 8)].getId());
        name5.setText(dc.products[currentIndex].getName());
        price5.setText(String.valueOf(dc.products[currentIndex].getPrice()));
        quantity5.setText(String.valueOf(cc.cart[4 + (currentPage * 8)].getQuantity()));

        if (5 + (currentPage * 8) >= cc.numberCartItems) return;
        name6.setVisible(true);
        price6.setVisible(true);
        quantity6.setVisible(true);
        remove6.setVisible(true);

        currentIndex = getIndexfromID(cc.cart[5 + (currentPage * 8)].getId());
        name6.setText(dc.products[currentIndex].getName());
        price6.setText(String.valueOf(dc.products[currentIndex].getPrice()));
        quantity6.setText(String.valueOf(cc.cart[5 + (currentPage * 8)].getQuantity()));

        if (6 + (currentPage * 8) >= cc.numberCartItems) return;
        name7.setVisible(true);
        price7.setVisible(true);
        quantity7.setVisible(true);
        remove7.setVisible(true);

        currentIndex = getIndexfromID(cc.cart[6 + (currentPage * 8)].getId());
        name7.setText(dc.products[currentIndex].getName());
        price7.setText(String.valueOf(dc.products[currentIndex].getPrice()));
        quantity7.setText(String.valueOf(cc.cart[6 + (currentPage * 8)].getQuantity()));

        if (7 + (currentPage * 8) >= cc.numberCartItems) return;
        name8.setVisible(true);
        price8.setVisible(true);
        quantity8.setVisible(true);
        remove8.setVisible(true);

        currentIndex = getIndexfromID(cc.cart[7 + (currentPage * 8)].getId());
        name8.setText(dc.products[currentIndex].getName());
        price8.setText(String.valueOf(dc.products[currentIndex].getPrice()));
        quantity8.setText(String.valueOf(cc.cart[7 + (currentPage * 8)].getQuantity()));
    }
}
