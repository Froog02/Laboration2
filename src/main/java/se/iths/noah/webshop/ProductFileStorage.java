package se.iths.noah.webshop;

import se.iths.noah.webshop.model.Product;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ProductFileStorage implements ProductStorage {
    private Path file = Path.of("products.txt");

    @Override
    public void saveProduct(Product product) throws IOException {
        String fileLine = product.toFileLine();
        Files.writeString(file, fileLine, StandardOpenOption.CREATE, StandardOpenOption.APPEND);

    }

    @Override
    public List<Product> getProducts() throws IOException {
        List<Product> products = new ArrayList<>();
        if (!Files.exists(file)) {
            return products;
        }

        List<String> lines = Files.readAllLines(file);
        for (String line : lines) {
            Product product = Product.fromFileLine(line);
            products.add(product);
        }

        return products;
    }

    @Override
    public Product getProduct(String articleNumber) throws IOException {
        List<Product> products = getProducts();

        for (Product product : products) {
            if (product.getArticleNumber().equals(articleNumber)) {
                return product;
            }
        }
        return null;
    }
}
