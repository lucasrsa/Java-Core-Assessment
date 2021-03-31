package com.github.lucasrsa.product;

import com.github.lucasrsa.Describable;
import com.github.lucasrsa.collection.SubCollection;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Product extends Describable {
    final private SubCollection collection;
    private double price = 0.0;
    private int quantity = 0;
    private final List<Image> imageList;
    private Variant variant;

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String describe() {
        return "Product: " + this.name + "\n\tPrice: $ " + String.format("%.2f", this.price)
                + "\n\tDescription: " + this.description;
    }

    public void setData(Scanner sc) {
        while (true) {
            try {
                System.out.print("Product price: ");
                this.setPrice(sc.nextDouble());
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please input a valid price.");
                sc.nextLine(); // Remove invalid input
            }
        }

        System.out.print("Product description: ");
        this.setDescription(sc.nextLine());

        while (true) {
            try {
                System.out.print("Product quantity: ");
                this.setQuantity(sc.nextInt());
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please input a valid quantity.");
                sc.nextLine(); // Remove invalid input
            }
        }
    }

    public Product(String name, SubCollection collection) {
        super(name);
        this.collection = collection;
        this.imageList = new ArrayList<>();
    }
}
