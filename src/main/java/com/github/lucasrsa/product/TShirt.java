package com.github.lucasrsa.product;

import com.github.lucasrsa.options.ShirtSizeOptions;
import com.github.lucasrsa.options.ShirtSleeveOptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TShirt extends Variant {
    private ShirtSizeOptions size;
    private ShirtSleeveOptions sleeve;

    public void setData(Scanner sc) {
        super.setData(sc);

        while (true) {
            try {
                ShirtSizeOptions.describeOptions();
                this.size = ShirtSizeOptions.valueOf(sc.nextLine().toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Please input a valid product size.");
//            } finally {
//                sc.nextLine(); // Remove remaining possible characters from line
            }
        }

        while (true) {
            try {
                ShirtSleeveOptions.describeOptions();
                this.sleeve = ShirtSleeveOptions.valueOf(sc.nextLine().toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Please input a valid product sleeve length.");
//            } finally {
//                sc.nextLine(); // Remove remaining possible characters from line
            }
        }
    }
}
