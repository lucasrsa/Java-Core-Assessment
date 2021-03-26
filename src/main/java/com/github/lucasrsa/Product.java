package com.github.lucasrsa;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Product extends Describable {
    private double price = 0.0;
    private int quantity = 0;

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String describe() {
        return "Product: " + this.name + "\n\tPrice: $ " + String.format("%.2f", this.price)
                + "\n\tDescription: " + this.description + "\n\tQuantity: "
                + this.quantity;
    }

    public Product(String name, Scanner sc) {
        super(name);

        while (true) {
            try {
                System.out.print("Product price: ");
                this.setPrice(sc.nextDouble());
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please input a valid price.");
                sc.next(); // Remove invalid input
            }
        }

        System.out.print("Product description: ");
        this.setDescription(sc.next());

        while (true) {
            try {
                System.out.print("Product quantity: ");
                this.setQuantity(sc.nextInt());
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please input a valid quantity.");
                sc.next(); // Remove invalid input
            }
        }
    }
}
