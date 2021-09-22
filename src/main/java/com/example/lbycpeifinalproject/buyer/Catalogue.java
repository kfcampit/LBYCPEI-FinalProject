package com.example.lbycpeifinalproject.buyer;

import com.example.lbycpeifinalproject.misc.DatabaseController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.io.IOException;

public class Catalogue extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    public Scene scene;
    public Pane pane;
    private int page=1;
    public static Stage pStage;

    public void start(Stage primaryStage) throws Exception {
        pStage = primaryStage;
        pStage.setScene(ProductDetails());
        pStage.show();
    }

    public Scene ProductDetails() throws Exception {
        DatabaseController productinfo = new DatabaseController();
        productinfo.loadDatabase();
        pane = new Pane();
        pane.setPadding(new Insets(8, 8, 8, 8));
        scene = new Scene(pane,1000,1250);
        page = getPage(getMaxPage(productinfo));
        for(int i = (page-1)*6;i < (page*6);i++) {
            try {
                //Product name
                Text name = new Text(scene.getWidth()/2,30 + (i * 200),productinfo.products[i].getName());
                name.setTextAlignment(TextAlignment.CENTER);
                name.setUnderline(true);
                name.setFont(Font.font("Calibri", FontWeight.NORMAL, FontPosture.REGULAR, 30));

                //Product picture
                ImageView pic = new ImageView("file:assets/" + productinfo.products[i].getImageFileName());
                pic.setX(30);
                pic.setY(50 + (i * 150));

                //Product description
                Text desc = new Text(scene.getWidth()/2,50 + (i * 200),productinfo.products[i].getDescription());
                desc.setTextAlignment(TextAlignment.RIGHT);
                desc.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 14));

                //Product Quantity, Price, and Rating
                Text quantity = new Text(scene.getWidth()/2,150 + (i * 200),"Quantity Available:" + productinfo.products[i].getQuantityInStock());
                quantity.setTextAlignment(TextAlignment.RIGHT);
                Text price = new Text(scene.getWidth()/2,165 + (i * 200),"PHP" + productinfo.products[i].getPrice());
                price.setTextAlignment(TextAlignment.RIGHT);
                Text rating = new Text(scene.getWidth()/2,180 + (i * 200),productinfo.products[i].getRating() + "/5");
                rating.setTextAlignment(TextAlignment.RIGHT);
                Line border = new Line(0,190+(i*200),scene.getWidth(),190+(i*200));
                Text pagenumber = new Text(scene.getWidth()-100,scene.getHeight()-35,"Page "+page);

                pane.getChildren().add(name);
                pane.getChildren().add(pic);
                pane.getChildren().add(desc);
                pane.getChildren().add(quantity);
                pane.getChildren().add(price);
                pane.getChildren().add(rating);
                pane.getChildren().add(border);
                pane.getChildren().add(pagenumber);

            } catch (Exception e) {break;}
        }

        return scene;
    }

    public int getPage(int max_page) throws Exception{
        if (page != max_page) {
            Button next = new Button("Next");
            next.setLayoutX(scene.getWidth()-50); next.setLayoutY(scene.getHeight()-50);
            next.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    page = page + 1;
                    try {
                        pStage.setScene(ProductDetails());
                        pStage.show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            pane.getChildren().add(next);
        }
        if (page > 1){
            Button prev = new Button("Prev");
            prev.setLayoutX(scene.getWidth()-150); prev.setLayoutY(scene.getHeight()-50);
            prev.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    page = page - 1;
                    try {
                        pStage.setScene(ProductDetails());
                        pStage.show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            });
            pane.getChildren().add(prev);
        }
        return page;
    }

    public int getMaxPage(DatabaseController productinfo){
        int max=0;
        for(int i = 0;i<100;i++){
            try{
                String name = productinfo.products[i].getName();
                max++;
            }catch (Exception e){break;}
        }
        max = Math.floorDiv(max,6)+1;
        return max;
    }

}
