package com.github.lucasrsa;

import java.util.Arrays;
import java.util.Scanner;

public class SubCollection extends Collection {

    private Product[] productList;

    public void addProduct(Product product){

    }

    public void listProducts(){
        System.out.println("Products: "+ Arrays.toString(this.productList));
    }

    public SubCollection(String name, Scanner sc) {
        super(name);

        System.out.print("Product description: ");
        this.setDescription(sc.next());

        this.setKeywords(sc);
    }
}
