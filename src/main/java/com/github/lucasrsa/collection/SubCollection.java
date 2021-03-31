package com.github.lucasrsa.collection;

import com.github.lucasrsa.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubCollection extends Collection {

    private final List<Product> productList;

    public void newProduct(Scanner sc) {
        System.out.print("Product name: ");
        String auxName = sc.nextLine();
        Product product = new Product(auxName);
        if (this.productList.contains(product)) {
            System.out.println("Product " + auxName + " already exists in " +
                    "Collection " + this + "/" + this + "!");
            return; // If a product with the same name already exists, return to main menu
        }
        product.setData(sc);
        this.productList.add(product);
        System.out.println("Product " + auxName + " added successfully.");
    }

    public void searchProduct(Scanner sc) {
        System.out.print("Choose a product to search: ");
        String auxName = sc.nextLine();
        for (Product product : this.productList) {
            if (product.toString().equalsIgnoreCase(auxName)) {
                System.out.print(product.describe());
                return;
            }
        }
        System.out.println("Product " + auxName + " not found!");
    }

    public List<Product> getProductList() {
        return this.productList;
    }

    public Product getProduct(String str){
        for (Product product : productList) {
            if (product.getName().equalsIgnoreCase(str)) {
                return product;
            }
        }
        return null;
    }

    public void setData(Scanner sc) {
        System.out.print("Sub-collection description: ");
        this.setDescription(sc.nextLine());

        this.setKeywords(sc);
    }

    @Override
    public String toString() {
        return this.name;
    }

    public SubCollection(String name) {
        super(name);

        this.productList = new ArrayList<>();
    }
}
