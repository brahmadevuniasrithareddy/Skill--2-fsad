package com.inventory.main;

import com.inventory.dao.ProductDAO;
import com.inventory.entity.Product;

public class App {

    public static void main(String[] args) {

        Product product = new Product(
                "Laptop",
                "Gaming Laptop",
                72000,
                8
        );

        ProductDAO dao = new ProductDAO();
        dao.saveProduct(product);

    }
}