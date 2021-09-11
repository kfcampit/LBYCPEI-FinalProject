package com.example.lbycpeifinalproject;

import com.example.lbycpeifinalproject.misc.DatabaseController;
import com.example.lbycpeifinalproject.seller.EditProductApplication;
import com.example.lbycpeifinalproject.seller.EditProductController;

public class MainHandler {
    private static final DatabaseController databaseController = new DatabaseController();

    public static void main(String[] args) throws Exception {
        databaseController.loadDatabase();
       // HelloApplication.main(null);
        EditProductApplication.main(null);
    }
}
