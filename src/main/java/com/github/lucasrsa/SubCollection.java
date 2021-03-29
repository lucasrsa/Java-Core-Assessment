package com.github.lucasrsa;

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
        this.setDescription(sc.next());

        this.setKeywords(sc);
    }

    public SubCollection(String name) {
        super(name);

        this.productList = new ArrayList<>();
    }
}
