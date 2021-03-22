package com.github.lucasrsa;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Options opt;
        do {
            System.out.println("Choose your option:");
            for (Options val : Options.values()) {
                System.out.println("\t"+val+" to "+val.describe());
            }
            System.out.print("-> ");
            opt = Options.valueOf(sc.next().toUpperCase());
            switch (opt) {
                case SAVE:
                    break;
                case LIST:
                    break;
                case SEARCH:
                    break;
                case EXIT:
                    System.out.println("Exiting application...");
                    break;
                default:
                    break;
            }
        }while (!opt.equals(Options.EXIT));
    }
}
