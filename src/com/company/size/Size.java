package com.company.size;

public class Size {

    private long id;

    private long productId;

    private boolean backSoon;

    private boolean special;

    Size(String[] data){
        this.id = Long.parseLong(data[0]);
        this.productId = Long.parseLong(data[1]);
        this.backSoon = Boolean.parseBoolean(data[2]);
        this.special = Boolean.parseBoolean(data[3]);
    }

    public long getId() {
        return id;
    }

    long getProductId() {
        return productId;
    }

    public boolean isBackSoon() {
        return backSoon;
    }

    public boolean isSpecial() {
        return special;
    }
}
