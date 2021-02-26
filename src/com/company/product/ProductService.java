package com.company.product;

import com.company.size.Size;
import com.company.size.SizeRepository;
import com.company.stock.Stock;
import com.company.stock.StockRepository;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProductService {

    public static List<Product> getProductsInStockOrderBySequence() {

        List<Product> products = ProductRepository.getAll();

        List<Size> sizes = SizeRepository.getAll();

        List<Stock> stocks = StockRepository.getAll();

        return products.stream()
                .sorted(Comparator.comparing(Product::getSequence))
                .filter(product -> {
                    List<Size> productSizes = SizeRepository.getAllByProductId(product.getId(), sizes);

                    boolean isComposed = productSizes.stream().anyMatch(Size::isSpecial);
                    if (!isComposed) {
                        return productSizes.stream().anyMatch(isInStock(stocks));

                    } else {
                        return productSizes.stream().filter(Size::isSpecial).anyMatch(isInStock(stocks)) &&
                                productSizes.stream().filter(size -> !size.isSpecial()).anyMatch(isInStock(stocks));
                    }
                })
                .collect(Collectors.toList());
    }

    private static Predicate<Size> isInStock(List<Stock> stocks) {
        return size -> size.isBackSoon()
                || StockRepository.findStockBySize(size.getId(), stocks).getQuantity() > 0;
    }
}
