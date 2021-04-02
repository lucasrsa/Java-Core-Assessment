package com.github.lucasrsa.product;

import java.util.Scanner;

public class Pants extends ActivityVariant {
    private String size;
    private String material;

    public void setData(Scanner sc) {
        super.setData(sc);

        System.out.print("Product size: ");
        this.size = sc.nextLine();

        System.out.print("Product material: ");
        this.material = sc.nextLine();
    }
}
