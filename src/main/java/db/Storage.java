package db;

import java.util.ArrayList;
import java.util.List;
import model.Product;

public class Storage {
    public static final List<Product> products = new ArrayList<>();
    private static long productId = 0;

    public static void addProduct(Product product) {
        productId++;
        product.setId(productId);
        products.add(product);
    }
}
