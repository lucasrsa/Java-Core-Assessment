package com.github.lucasrsa;

import java.util.Locale;

public class App {

    public static void main(String[] args) {
        System.out.println("Running...");
        Options opt;
        do {
            System.out.println("Choose your option:");
            for (Options val : Options.values()) {
                System.out.println("\t"+val+" or "+val.ordinal()+" to "+val.toString().toLowerCase());
            }
            opt = Options.valueOf("EXIT");
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
