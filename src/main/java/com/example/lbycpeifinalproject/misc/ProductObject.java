package com.example.lbycpeifinalproject.misc;

public class ProductObject implements ProductInterface{
    private int id = 0;
    private String name = "";
    private double price = 0;
    private int quantityInStock = 0;
    public String[] imageFileName;
    private String description = "";
    public String[] category;
    private double rating = 0;

    @Override
    public int getId() {
        return id;
    }
    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getPrice() {
        return price;
    }
    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int getQuantityInStock() {
        return quantityInStock;
    }
    @Override
    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    @Override
    public String[] getImageFileName() {
        return imageFileName;
    }
    @Override
    public void setImageFileName(String[] imageFileName) {
        this.imageFileName = imageFileName;
    }

    @Override
    public String getDescription() {
        return description;
    }
    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String[] getCategory() {
        return category;
    }
    @Override
    public void setCategory(String[] category) {
        this.category = category;
    }

    @Override
    public double getRating() {
        return rating;
    }
    @Override
    public void setRating(double rating) {
        this.rating = rating;
    }
}
