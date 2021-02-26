package com.company.product;


public class Product {

    private long id;

    private long sequence;

    Product(String[] data) {
        this.id = Long.parseLong(data[0]);
        this.sequence = Long.parseLong(data[1]);
    }

    public long getId() {
        return id;
    }

    long getSequence() {
        return sequence;
    }
}
