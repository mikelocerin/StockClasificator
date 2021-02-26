package com.company.product;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    /**
     * Simulation of Spring Data query method
     */
    static List<Product> getAll() {

        String csvFile = "path to product csv";
        BufferedReader br = null;
        String line;
        String cvsSplitBy = ",";

        List<Product> products = new ArrayList<>();

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                products.add(new Product(data));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return products;
    }
}
