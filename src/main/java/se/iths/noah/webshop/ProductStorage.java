package se.iths.noah.webshop;

import se.iths.noah.webshop.model.Product;

import java.io.IOException;
import java.util.List;

public interface ProductStorage {
    void saveProduct(Product product) throws IOException;

    List<Product> getProducts() throws IOException;

    Product getProduct(String articleNumber) throws IOException;
}
