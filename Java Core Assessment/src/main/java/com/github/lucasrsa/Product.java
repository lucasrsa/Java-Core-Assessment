package com.github.lucasrsa;

public class Product {
    private final String name;
    private double price;
    private String description;
    private int quantity;
    private String category;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Product(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return name.equalsIgnoreCase(product.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public String describe() {
        return "Product: " + this + "\n\tPrice: $ " + this.price
                + "\n\tDescription: " + this.description + "\n\tQuantity: "
                + this.quantity + "\n\tCategory: " + this.category;
    }
}
