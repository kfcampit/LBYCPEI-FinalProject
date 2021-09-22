package com.example.lbycpeifinalproject.buyer;

import com.example.lbycpeifinalproject.misc.ProductObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.Objects;
import java.util.stream.IntStream;

public class SearchForProductController {
    @FXML public Button searchButton;
    @FXML public TextField searchField;
    @FXML public Button homeButton;
    @FXML public TableColumn<ProductObject, String[]> imageColumn;
    @FXML public TableColumn<ProductObject, String> nameColumn;
    @FXML public TableColumn<ProductObject, String[]> categoryColumn;
    @FXML public TableColumn<ProductObject, Double> priceColumn;
    @FXML public TableColumn<ProductObject, Double> ratingColumn;
    @FXML public TableColumn<ProductObject, Integer> stocksColumn;
    @FXML public TableView<ProductObject> tableView;

    // TODO: Implement the following:
    //  - Method to set image column to display an image (or remove)
    //  - Method to select from list.
    private void setTable(ObservableList<ProductObject> productsToShow){
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        ratingColumn.setCellValueFactory(new PropertyValueFactory<>("rating"));
        stocksColumn.setCellValueFactory(new PropertyValueFactory<>("QuantityInStock"));

        tableView.getItems().setAll(productsToShow);
    }
    private ObservableList<ProductObject> getItemDetails(String itemName) throws Exception {
        ObservableList<ProductObject> productsToShow = FXCollections.observableArrayList();
        ProductObject[] productsToCheck = SearchForProduct.dc.products;
        int numOfProducts = SearchForProduct.dc.numberProducts;

        for (int i = 0; i < numOfProducts; i++){
            if (Objects.equals(productsToCheck[i].getName().toUpperCase(Locale.ROOT), itemName)){
                productsToShow.add(productsToCheck[i]);
                System.out.println("Added object.");
            } else {
                System.out.println("No object added.");
            }
        }
        return productsToShow;
    }
    public void OnSearchPressed(ActionEvent actionEvent) throws Exception {
        String searchQuery = searchField.getText().toUpperCase(Locale.ROOT);
        setTable(getItemDetails(searchQuery));
    }

    public void goToItem(MouseEvent mouseEvent) {
        tableView.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
                    ProductObject selectedNode = tableView.getSelectionModel().getSelectedItem();
                    if (selectedNode != null){
                        ViewProduct vp = new ViewProduct();
                        tableView.getScene().getWindow().hide();
                        int productIndex = 0;

                        for (int i = 0; i < SearchForProduct.dc.numberProducts; i++){
                            if (SearchForProduct.dc.products[i].getId() == selectedNode.getId()){productIndex = i;}
                        }

                        try {
                            Stage stage = new Stage();
                            vp.setProductIndex(productIndex);
                            vp.start(stage);
                        } catch (Exception ignore) {
                        }
                    }
                }
            }
        });
    }
}
