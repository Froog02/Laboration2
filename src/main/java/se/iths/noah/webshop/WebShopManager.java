package se.iths.noah.webshop;


import se.iths.noah.webshop.model.Discount;
import se.iths.noah.webshop.model.HalfPriceDiscount;
import se.iths.noah.webshop.model.Product;
import se.iths.noah.webshop.model.TenPercentDiscount;

import java.io.IOException;
import java.util.List;

public class WebShopManager {
    private ProductStorage productStorage;

    public WebShopManager(ProductStorage productStorage) {
        this.productStorage = productStorage;
    }

    void saveProductToStorage(Product product) throws IOException {
        productStorage.saveProduct(product);

    }

    List<Product> getProductsFromStorage() throws IOException {
        return productStorage.getProducts();
    }

    Product getProductFromStorage(String articleNumber) throws IOException {
        return productStorage.getProduct(articleNumber);
    }


    void startWebshop() throws IOException {
        boolean haschosen = false;
        Product product;
        ProductFileStorage productFileStorage = new ProductFileStorage();
        String rabattKod = IO.readln("Enter your discount code: ");
        Discount discount;
        if (rabattKod.equals("halfprice")) {
            discount = new HalfPriceDiscount("You get a 50% discount. YAY!!!");
        } else {
            discount = new TenPercentDiscount("You get a 10% discount. BOOO!!!");
        }
        while (!haschosen) {
            IO.println(" 1. add product \n 2. see all products \n 3. show information about a product \n 4. end application.");
            switch (IO.readln("enter your choice 1 - 4: ")) {
                case "1":
                    String articleNumber = IO.readln("enter article number: ");
                    String title = IO.readln("enter title: ");
                    double price = Double.parseDouble(IO.readln("enter price: "));
                    String description = IO.readln("enter description: ");
                    product = new Product(articleNumber, title, price, description);
                    //productFileStorage.saveProduct(product);
                    saveProductToStorage(product);
                    break;

                case "2":
                    try {
                        //IO.println(getProductsFromStorage());
                        for (Product product1 : getProductsFromStorage()) {
                            product1.setPrice(discount.calculatePrice(product1.getPrice()));
                            IO.println(product1);
                        }
                        //productFileStorage.getProducts();
                    } catch (IOException _) {
                    }
                    break;

                case "3":
                    try {
                        productFileStorage.getProduct(IO.readln("Which product do you want to see?: "));
                    } catch (IOException _) {
                    }
                    break;

                case "4":
                    haschosen = true;
                    break;
                default:
                    IO.println("Please enter a valid option");
            }
        }


    }

}
