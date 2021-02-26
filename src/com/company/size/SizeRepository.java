package com.company.size;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SizeRepository {

    /**
     * Simulation of Spring Data query method
     */
    public static List<Size> getAll() {

        String csvFile = "path to Size csv";
        BufferedReader br = null;
        String line;
        String cvsSplitBy = ",";

        List<Size> sizes = new ArrayList<>();

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                sizes.add(new Size(data));
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
        return sizes;
    }

    /**
     * Simulation of Spring Data query method
     */
    public static List<Size> getAllByProductId(long productId, List<Size> sizes) {
        return sizes.stream()
                .filter(size -> productId == size.getProductId())
                .collect(Collectors.toList());
    }
}
