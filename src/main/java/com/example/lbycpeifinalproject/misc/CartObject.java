package com.example.lbycpeifinalproject.misc;

public class CartObject implements CartInterface{
    private int id;
    private int quantity;

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setQuantity(int num) {
        this.quantity = num;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }
}
