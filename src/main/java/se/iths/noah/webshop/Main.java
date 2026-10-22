package se.iths.noah.webshop;


import java.io.IOException;

public class Main {
    static void main() {
        ProductFileStorage productFileStorage = new ProductFileStorage();
        WebShopManager webShopManager = new WebShopManager(productFileStorage);
        try {
            webShopManager.startWebshop();
        } catch (IOException _) {

        }


    }
}
