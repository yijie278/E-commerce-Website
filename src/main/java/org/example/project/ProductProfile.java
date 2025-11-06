package org.example.project;

public class ProductProfile {
    private String id;
    private String name;
    private String price; // Use String to match "RM5/-" format
    private String image;
    private String origin;
    private String description;
    private String category;

    public ProductProfile(String id, String name, String price, String image, String origin, String description, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.origin = origin;
        this.description = description;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return id + "|" + name + "|" + price + "|" + image + "|" + origin + "|" + description + "|" + category;
    }

    public static ProductProfile fromString(String csvLine) {
        String[] parts = csvLine.split("\\|");
        if (parts.length != 7) {  // Adjusted for 4 parts
            throw new IllegalArgumentException("Invalid CSV format.");
        }
        return new ProductProfile(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6]);
    }
}
