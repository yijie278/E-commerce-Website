package org.example.project;

import java.io.*;
import java.util.*;

public class ProductProfileManager {
    private static final String FILE_NAME = "products.csv";
    private static Map<String, ProductProfile> productMap = new HashMap<>();
    private static Collection<ProductProfile> products;

    // Static block to load all products at startup
    static {
        try {
            loadAllProducts();
        } catch (IOException e) {
            System.err.println("Error loading product profiles: " + e.getMessage());
        }
    }

    static{
            products = ProductProfileManager.getAllProducts();
    }


    // Load all products from the CSV file
    public static void loadAllProducts() throws IOException {
        // Use getResourceAsStream() instead of getFile() to work in JAR/WAR deployments
        try (InputStream is = ProductProfileManager.class.getClassLoader().getResourceAsStream(FILE_NAME);
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            if (is == null) {
                throw new IOException("Resource not found: " + FILE_NAME);
            }
            String line;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                try {
                    if (!line.trim().isEmpty()) {
                        ProductProfile product = ProductProfile.fromString(line);
                        productMap.put(product.getId(), product);
                    }
                } catch (IllegalArgumentException e) {
                    System.err.println("Skipping malformed line " + lineNumber + ": " + line);
                }
            }
        }
    }



    // Get all products as a collection
    public static Collection<ProductProfile> getAllProducts() {
        Collection<ProductProfile> products = productMap.values();
        System.out.println("Number of products: " + products.size()); // Debugging
        return products;
    }

    public static ProductProfile getProductById(String productId) {
        // Ensure the productId is not null
        if (productId == null || products == null) {
            return null;
        }

        // Find the product with the matching ID
        for (ProductProfile product : products) {
            if (productId.equals(product.getId())) {
                return product;
            }
        }

        // If no product is found, return null
        return null;
    }

//    // Find a product by its ID
//    public static ProductProfile findProductById(String id) {
//        return productMap.get(id);
//    }
//
//    // Save a new product to the CSV file
//    public static void saveProduct(ProductProfile product) {
//        // Save product profile
//        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
//            writer.append(product.toString()).append("\n");
//            productMap.put(product.getId(), product); // Add to in-memory map
//            System.out.println("Product saved successfully.");
//        } catch (IOException e) {
//            System.err.println("Error saving product profile: " + e.getMessage());
//        }
//    }

//    public static void updateProduct(ProductProfile updatedProduct) {
//        if (productMap.containsKey(updatedProduct.getId())) {
//            productMap.put(updatedProduct.getId(), updatedProduct);
//
//            // Rewrite the CSV file
//            try (FileWriter writer = new FileWriter(FILE_NAME)) {
//                for (ProductProfile product : productMap.values()) {
//                    writer.append(product.toString()).append("\n");
//                }
//                System.out.println("Product updated successfully.");
//            } catch (IOException e) {
//                System.err.println("Error updating product profile: " + e.getMessage());
//            }
//        } else {
//            System.err.println("Product not found: " + updatedProduct.getId());
//        }
//    }

//    public static List<ProductProfile> searchProducts(String query, String category) {
//        List<ProductProfile> result = new ArrayList<>();
//        for (ProductProfile product : productMap.values()) {
//            if ((category == null || product.getCategory().equalsIgnoreCase(category)) &&
//                    product.getName().toLowerCase().contains(query.toLowerCase())) {
//                result.add(product);
//            }
//        }
//        return result;
//    }

//    public static boolean validateProductData(ProductProfile product) {
//        return product.getId() != null && !product.getId().isBlank() &&
//                product.getName() != null && !product.getName().isBlank() &&
//                product.getPrice() != null && !product.getPrice().isBlank() &&
//                product.getImage() != null && !product.getImage().isBlank();
//    }

}
