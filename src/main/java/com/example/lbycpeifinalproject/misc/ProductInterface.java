package com.example.lbycpeifinalproject.misc;

public interface ProductInterface {
    int getId();
    void setId(int id);

    String getName();
    void setName(String name);

    double getPrice();
    void setPrice(double price);

    int getQuantityInStock();
    void setQuantityInStock(int quantityInStock);

    String getImageFileName();
    void setImageFileName(String imageFileName);

    String getDescription();
    void setDescription(String description);

    String[] getCategory();
    void setCategory(String[] category);

    double getRating();
    void setRating(double rating);
}
