package com.github.lucasrsa.product;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Footwear extends ActivityVariant {
    private int size;

    public void setData(Scanner sc) {
        super.setData(sc);

        while (true) {
            try {
                System.out.print("Footwear size: ");
                this.size = sc.nextInt();
                if (this.size > 99){
                    throw new InputMismatchException("Size too big!");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please input a valid footwear size.");
            } finally {
                sc.nextLine(); // Remove remaining possible characters from line
            }
        }

    }
}
