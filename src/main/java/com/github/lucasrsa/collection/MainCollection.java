package com.github.lucasrsa.collection;

import com.github.lucasrsa.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainCollection extends Collection {

    private final List<SubCollection> subCollectionList;

    public void addSubCollection(Scanner sc) {
        System.out.print("Sub-Collection name: ");
        String auxName = sc.nextLine();
        SubCollection subCollection = new SubCollection(auxName, this);
        if (this.subCollectionList.contains(subCollection)) {
            System.out.println("Sub-Collection " + auxName + " already exists in " +
                    "Collection " + this + "!");
            return; // If a sub-collection with the same name already exists, return to main menu
        }
        subCollection.setData(sc);
        this.subCollectionList.add(subCollection);
        System.out.println("Sub-collection " + auxName + " added successfully.");
    }

    public Boolean listProducts(String name) {
        for (SubCollection subCol : this.subCollectionList) {
            if (subCol.toString().equalsIgnoreCase(name)) {
                for (Product product : subCol.getProductList()) {
                    System.out.println(product.describe());
                }
                return true;
            }
        }
        return false;
    }

    public void searchProduct(Scanner sc) {
        System.out.print("Choose a sub-collection to search a product: ");
        String auxName = sc.nextLine();
        for (SubCollection subCol : this.subCollectionList) {
            if (subCol.toString().equalsIgnoreCase(auxName)) {
                subCol.searchProduct(sc);
                return;
            }
        }
        System.out.println("Sub-Collection " + auxName + " not found!");
    }

    public void newProduct(Scanner sc) {
        System.out.print("Choose a sub-collection to add product: ");
        String auxName = sc.nextLine();
        for (SubCollection subCol : this.subCollectionList) {
            if (subCol.toString().equalsIgnoreCase(auxName)) {
                subCol.newProduct(sc);
                return;
            }
        }
        System.out.println("Sub-Collection " + auxName + " not found!");
    }

    public List<Product> getProductList() {
        return this.subCollectionList.stream().flatMap(subCollection -> subCollection.getProductList().stream()).collect(Collectors.toList());
    }

    public void setData(Scanner sc) {
        System.out.print("Collection description: ");
        this.setDescription(sc.nextLine());

        this.setKeywords(sc);
    }

    public String listAllSubCollections() {
        String aux;
        StringBuilder str = new StringBuilder("Collection " + this.name + ":");
        for (SubCollection sub : subCollectionList) {
            aux = "\n\t" + sub;
            str.append(aux);
        }
        return str.toString();
    }

    public Product getProduct(String str) {
        for (SubCollection subCollection : subCollectionList) {
            Product product = subCollection.getProduct(str);
            if (product != null) {
                return product;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public MainCollection(String name) {
        super(name);

        this.subCollectionList = new ArrayList<>();
    }
}
