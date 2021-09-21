package com.example.lbycpeifinalproject.seller;

import com.example.lbycpeifinalproject.misc.DatabaseController;
import com.example.lbycpeifinalproject.misc.ProductObject;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ManageProductsController {
    private final DatabaseController dc = new DatabaseController();
    private int currentPage = 0;
    private int totalPages;
    private ManageProducts mp = new ManageProducts();

    @FXML
    public Text id1, id2, id3, id4, id5, id6, id7, id8, id9, pageNum;

    @FXML
    public Text name1, name2, name3, name4, name5, name6, name7, name8, name9;

    @FXML
    public Text price1, price2, price3, price4, price5, price6, price7, price8, price9;

    @FXML
    public Button edit1, edit2, edit3, edit4, edit5, edit6, edit7, edit8, edit9;

    @FXML
    public Button remove1, remove2, remove3, remove4, remove5, remove6, remove7, remove8, remove9, prevPage, nextPage;

    @FXML
    public GridPane gridPane;

    @FXML
    private void onNextPage() {
        currentPage++;
        pageNum.setText((currentPage + 1) + "/" + totalPages);
        initContent();
    }

    @FXML
    private void onPrevPage() {
        currentPage--;
        pageNum.setText((currentPage + 1) + "/" + totalPages);
        initContent();
    }

    @FXML
    private void onHome() {
        SellerMain smc = new SellerMain();
        edit1.getScene().getWindow().hide();

        try {
            Stage stage = new Stage();
            smc.start(stage);
        } catch (Exception ignore) {
        }
    }

    @FXML
    private void onAddProduct() {
        AddProductApplication apa = new AddProductApplication();
        edit1.getScene().getWindow().hide();

        try {
            Stage stage = new Stage();
            apa.start(stage);
        } catch (Exception ignore) {
        }
    }

    @FXML
    private void onEdit1() {
        editButton(0);
    }

    @FXML
    private void onEdit2() {
        editButton(1);
    }

    @FXML
    private void onEdit3() {
        editButton(2);
    }

    @FXML
    private void onEdit4() {
        editButton(3);
    }

    @FXML
    private void onEdit5() {
        editButton(4);
    }

    @FXML
    private void onEdit6() {
        editButton(5);
    }

    @FXML
    private void onEdit7() {
        editButton(6);
    }

    @FXML
    private void onEdit8() {
        editButton(7);
    }

    @FXML
    private void onEdit9() {
        editButton(8);
    }

    private void editButton(int i) {
        EditProductApplication epa = new EditProductApplication();
        edit1.getScene().getWindow().hide();

        try {
            Stage stage = new Stage();
            epa.setProductIndex(i);
            epa.start(stage);

        } catch (Exception ignore) {
        }
    }

    @FXML
    private void onRemove1() {
        removeButton(0);
    }

    @FXML
    private void onRemove2() {
        removeButton(1);
    }

    @FXML
    private void onRemove3() {
        removeButton(2);
    }

    @FXML
    private void onRemove4() {
        removeButton(3);
    }

    @FXML
    private void onRemove5() {
        removeButton(4);
    }

    @FXML
    private void onRemove6() {
        removeButton(5);
    }

    @FXML
    private void onRemove7() {
        removeButton(6);
    }

    @FXML
    private void onRemove8() {
        removeButton(7);
    }

    @FXML
    private void onRemove9() {
        removeButton(8);
    }

    private void removeButton(int i) {
        for (int j = i; j < dc.numberProducts; j++) {
            dc.products[i] = dc.products[i + 1];
        }
        dc.products[dc.numberProducts - 1] = new ProductObject();
        dc.numberProducts--;
        initContent();
        if (dc.numberProducts < 9) {
            setVisibility((dc.numberProducts) % 9);
        }

        try {
            dc.updateDatabase(dc.numberProducts - 1);
        } catch (Exception ignored) {
        }


    }

    private void setVisibility(int i) {
        switch (i) {
            case 0 -> {
                id1.setVisible(false);
                name1.setVisible(false);
                price1.setVisible(false);
                edit1.setVisible(false);
                remove1.setVisible(false);
            }
            case 1 -> {
                id2.setVisible(false);
                name2.setVisible(false);
                price2.setVisible(false);
                edit2.setVisible(false);
                remove2.setVisible(false);
            }
            case 2 -> {
                id3.setVisible(false);
                name3.setVisible(false);
                price3.setVisible(false);
                edit3.setVisible(false);
                remove3.setVisible(false);
            }
            case 3 -> {
                id4.setVisible(false);
                name4.setVisible(false);
                price4.setVisible(false);
                edit4.setVisible(false);
                remove4.setVisible(false);
            }
            case 4 -> {
                id5.setVisible(false);
                name5.setVisible(false);
                price5.setVisible(false);
                edit5.setVisible(false);
                remove5.setVisible(false);
            }
            case 5 -> {
                id6.setVisible(false);
                name6.setVisible(false);
                price6.setVisible(false);
                edit6.setVisible(false);
                remove6.setVisible(false);
            }
            case 6 -> {
                id7.setVisible(false);
                name7.setVisible(false);
                price7.setVisible(false);
                edit7.setVisible(false);
                remove7.setVisible(false);
            }
            case 7 -> {
                id8.setVisible(false);
                name8.setVisible(false);
                price8.setVisible(false);
                edit8.setVisible(false);
                remove8.setVisible(false);
            }
            case 8 -> {
                id9.setVisible(false);
                name9.setVisible(false);
                price9.setVisible(false);
                edit9.setVisible(false);
                remove9.setVisible(false);
            }
        }
    }

    public void initialize() throws Exception {
        dc.loadDatabase();
        totalPages = (int) Math.ceil(dc.numberProducts / 9.0);
        pageNum.setText((currentPage + 1) + "/" + totalPages);
        initContent();
    }

    private void initContent() {
        if ((currentPage + 1) == totalPages) {
            nextPage.setVisible(false);
        }

        if ((currentPage + 1) == 1) {
            prevPage.setVisible(false);
        }

        if ((currentPage * 9) >= dc.numberProducts) return;
        System.out.println(dc.products[(currentPage * 9)].getName() != null);
        id1.setVisible(true);
        name1.setVisible(true);
        price1.setVisible(true);
        edit1.setVisible(true);
        remove1.setVisible(true);

        id1.setText(String.valueOf(dc.products[(currentPage * 9)].getId()));
        name1.setText(dc.products[(currentPage * 9)].getName());
        price1.setText(String.valueOf(dc.products[(currentPage * 9)].getPrice()));

        if (1 + (currentPage * 9) >= dc.numberProducts) return;
        id2.setVisible(true);
        name2.setVisible(true);
        price2.setVisible(true);
        edit2.setVisible(true);
        remove2.setVisible(true);

        id2.setText(String.valueOf(dc.products[1 + (currentPage * 9)].getId()));
        name2.setText(dc.products[1 + (currentPage * 9)].getName());
        price2.setText(String.valueOf(dc.products[1 + (currentPage * 9)].getPrice()));

        if (2 + (currentPage * 9) >= dc.numberProducts) return;
        id3.setVisible(true);
        name3.setVisible(true);
        price3.setVisible(true);
        edit3.setVisible(true);
        remove3.setVisible(true);

        id3.setText(String.valueOf(dc.products[2 + (currentPage * 9)].getId()));
        name3.setText(dc.products[2 + (currentPage * 9)].getName());
        price3.setText(String.valueOf(dc.products[2 + (currentPage * 9)].getPrice()));

        if (3 + (currentPage * 9) >= dc.numberProducts) return;
        id4.setVisible(true);
        name4.setVisible(true);
        price4.setVisible(true);
        edit4.setVisible(true);
        remove4.setVisible(true);

        id4.setText(String.valueOf(dc.products[3 + (currentPage * 9)].getId()));
        name4.setText(dc.products[3 + (currentPage * 9)].getName());
        price4.setText(String.valueOf(dc.products[3 + (currentPage * 9)].getPrice()));

        if (4 + (currentPage * 9) >= dc.numberProducts) return;
        id5.setVisible(true);
        name5.setVisible(true);
        price5.setVisible(true);
        edit5.setVisible(true);
        remove5.setVisible(true);

        id5.setText(String.valueOf(dc.products[4 + (currentPage * 9)].getId()));
        name5.setText(dc.products[4 + (currentPage * 9)].getName());
        price5.setText(String.valueOf(dc.products[4 + (currentPage * 9)].getPrice()));

        if (5 + (currentPage * 9) >= dc.numberProducts) return;
        id6.setVisible(true);
        name6.setVisible(true);
        price6.setVisible(true);
        edit6.setVisible(true);
        remove6.setVisible(true);

        id6.setText(String.valueOf(dc.products[5 + (currentPage * 9)].getId()));
        name6.setText(dc.products[5 + (currentPage * 9)].getName());
        price6.setText(String.valueOf(dc.products[5 + (currentPage * 9)].getPrice()));

        if (6 + (currentPage * 9) >= dc.numberProducts) return;
        id7.setVisible(true);
        name7.setVisible(true);
        price7.setVisible(true);
        edit7.setVisible(true);
        remove7.setVisible(true);

        id7.setText(String.valueOf(dc.products[6 + (currentPage * 9)].getId()));
        name7.setText(dc.products[6 + (currentPage * 9)].getName());
        price7.setText(String.valueOf(dc.products[6 + (currentPage * 9)].getPrice()));

        if (7 + (currentPage * 9) >= dc.numberProducts) return;
        id8.setVisible(true);
        name8.setVisible(true);
        price8.setVisible(true);
        edit8.setVisible(true);
        remove8.setVisible(true);

        id8.setText(String.valueOf(dc.products[7 + (currentPage * 9)].getId()));
        name8.setText(dc.products[7 + (currentPage * 9)].getName());
        price8.setText(String.valueOf(dc.products[7 + (currentPage * 9)].getPrice()));

        if (8 + (currentPage * 9) >= dc.numberProducts) return;
        id9.setVisible(true);
        name9.setVisible(true);
        price9.setVisible(true);
        edit9.setVisible(true);
        remove9.setVisible(true);

        id9.setText(String.valueOf(dc.products[8 + (currentPage * 9)].getId()));
        name9.setText(dc.products[8 + (currentPage * 9)].getName());
        price9.setText(String.valueOf(dc.products[8 + (currentPage * 9)].getPrice()));
    }



}
