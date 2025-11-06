package org.example.project;

import java.util.Collection;

public class DisplayProducts {
    public static void main(String[] args) {
        try {
            System.out.println("Loading all products...");

            // Load products using ProductProfileManager
            Collection<ProductProfile> products = ProductProfileManager.getAllProducts();
            ProductProfile selectedProduct = ProductProfileManager.getProductById("1");
            System.out.printf("%-10s %-20s %-10s %-15s %-15s\n",
                    selectedProduct.getId(),
                    selectedProduct.getName(),
                    selectedProduct.getPrice(),
                    selectedProduct.getCategory(),
                    selectedProduct.getOrigin());

            if (products.isEmpty()) {
                System.out.println("No products found.");
            } else {
                System.out.println("Products available:");
                System.out.println("-------------------------------------------------------------");
                System.out.printf("%-10s %-20s %-10s %-15s %-15s\n", "ID", "Name", "Price", "Category", "Origin");
                System.out.println("-------------------------------------------------------------");

                // Loop through and display products
                for (ProductProfile product : products) {
                    System.out.printf("%-10s %-20s %-10s %-15s %-15s\n",
                            product.getId(),
                            product.getName(),
                            product.getPrice(),
                            product.getCategory(),
                            product.getOrigin());
                }
                System.out.println("-------------------------------------------------------------");
            }
        } catch (Exception e) {
            System.err.println("Error displaying products: " + e.getMessage());
        }
    }
}
