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
        SubCollection subCollection = new SubCollection(auxName);
        if (this.subCollectionList.contains(subCollection)) {
            System.out.println("Sub-Collection " + auxName + " already exists in " +
                    "Collection " + this + "!");
            return; // If a sub-collection with the same name already exists, return to main menu
        }
        subCollection.setData(sc);
        this.subCollectionList.add(subCollection);
        System.out.println("Sub-collection " + auxName + " added successfully.");
    }

    public List<SubCollection> getSubCollectionList() {
        return this.subCollectionList;
    }

    public List<Product> getProductList() {
        return this.subCollectionList.stream().flatMap(subCollection -> subCollection.getProductList().stream()).collect(Collectors.toList());
    }

    public void setData(Scanner sc) {
        System.out.print("Collection description: ");
        this.setDescription(sc.nextLine());

        this.setKeywords(sc);
    }

    public String listAll() {
        String aux;
        StringBuilder str = new StringBuilder("Collection " + this.name + ":");
        for (SubCollection sub : subCollectionList) {
            aux = "\n\t" + sub;
            str.append(aux);
        }
        return str.toString();
    }

    public Product getProduct(String str){
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
