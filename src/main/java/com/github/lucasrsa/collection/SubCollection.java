package com.github.lucasrsa.collection;

import com.github.lucasrsa.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubCollection extends Collection {

    private final List<Product> productList;

    public void addProduct(Product product) {
        this.productList.add(product);
    }

    public List<Product> getProductList() {
        return this.productList;
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
