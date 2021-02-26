package com.company.stock;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StockRepository {

    /**
     * Simulation of Spring Data query method
     */
    public static List<Stock> getAll() {

        String csvFile = "path to stock csv";
        BufferedReader br = null;
        String line;
        String cvsSplitBy = ",";

        List<Stock> stocks = new ArrayList<>();

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                stocks.add(new Stock(data));
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
        return stocks;
    }

    /**
     * Simulation of Spring Data query method
     */
    public static Stock findStockBySize(long sizeId, List<Stock> stocks) {

        return stocks.stream().filter(stock -> sizeId == stock.getSizeId())
                .findFirst().orElse(new Stock());

    }
}
