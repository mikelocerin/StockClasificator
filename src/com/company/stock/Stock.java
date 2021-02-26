package com.company.stock;


public class Stock {

    private long sizeId;

    private long quantity;

    Stock(String[] data) {
        this.sizeId = Long.parseLong(data[0]);
        this.quantity = Long.parseLong(data[1]);
    }
    Stock(){}

    long getSizeId() {
        return sizeId;
    }

    public long getQuantity() {
        return quantity;
    }
}
