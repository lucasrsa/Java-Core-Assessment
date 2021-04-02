package com.github.lucasrsa.product;

import java.util.Scanner;

public abstract class ActivityVariant extends Variant {
    protected String activity;

    protected void setData(Scanner sc) {
        super.setData(sc);

        System.out.print("Activity this product is destined to: ");
        this.activity = sc.nextLine();
    }
}
