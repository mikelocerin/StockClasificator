package com.company;

import com.company.product.ProductService;

public class Main {

    public static void main(String[] args) {
        ProductService.getProductsInStockOrderBySequence().forEach(product -> System.out.println(product.getId()));
    }
}
