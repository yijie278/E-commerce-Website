package org.example.project;

public class CartItem {
    private ProductProfile product;
    private int quantity;

    public CartItem(ProductProfile product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public ProductProfile getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubtotal() {
        // Remove "RM" and "/" from price string and convert to double
        String priceStr = product.getPrice().replaceAll("[^0-9.]", "");
        return Double.parseDouble(priceStr) * quantity;
    }
}