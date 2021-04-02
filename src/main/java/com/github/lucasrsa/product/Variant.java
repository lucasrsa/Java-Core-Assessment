package com.github.lucasrsa.product;

import java.util.Scanner;

public abstract class Variant {
    protected String color;
    protected String gender;

    protected void setData(Scanner sc) {
        System.out.print("Product color: ");
        this.color = sc.nextLine();
        System.out.print("Gender product is destined for: ");
        this.gender = sc.nextLine();
    }
}
