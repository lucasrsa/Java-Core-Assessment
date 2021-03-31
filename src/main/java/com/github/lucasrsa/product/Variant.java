package com.github.lucasrsa.product;

import java.util.Scanner;

public abstract class Variant {
    protected String color;
    protected String gender;

    protected void setData(Scanner sc) {
        System.out.println("Setting Data");
    }
}
