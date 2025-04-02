package model;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Product product = new Product("123", "Product 1", 100.0);
        Product product1 = new Product("124", "Product 4", 10.0);
        Product product2 = new Product("456", "Product 2", 40.0);
        Product product3 = new Product("789", "Product 3", 30.0);

        List<Product> productList = new ArrayList<>();
        productList.add(product);productList.add(product1);productList.add(product2);productList.add(product3);

        var sortedList = Collections.min(productList);
        System.out.println(sortedList);
    }
}
