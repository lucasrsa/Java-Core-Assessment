package com.github.lucasrsa.product;

import com.github.lucasrsa.Describable;
import com.github.lucasrsa.collection.SubCollection;
import com.github.lucasrsa.options.ProductOptions;
import com.github.lucasrsa.options.VariantOptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Product extends Describable {
    final private SubCollection collection;
    private double price = 0.0;
    private int quantity = 0;
    private final Image[] imageList = new Image[5];
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
            } finally {
                sc.nextLine(); // Remove remaining possible characters from line
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
            } finally {
                sc.nextLine(); // Remove remaining possible characters from line
            }
        }

        String str;
        for (int i = 0; i < this.imageList.length; i++) {
            System.out.printf("Add image URL %d/%d (Leave empty to continue): ", i + 1, this.imageList.length);
            str = sc.nextLine();
            if (str.isEmpty()) {
                break;
            }
            this.imageList[i] = new Image(str);
        }

        while (true) {
            VariantOptions.describeOptions();
            str = sc.nextLine();
            if (str.isEmpty()) {
                break;
            }
            try {
                this.variant = VariantOptions.valueOf(str.toUpperCase()).getVariant();
                if (this.variant != null) {
                    this.variant.setData(sc);
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Please input valid option.");
            }
        }

    }

    public Product(String name, SubCollection collection) {
        super(name);
        this.collection = collection;
    }
}
