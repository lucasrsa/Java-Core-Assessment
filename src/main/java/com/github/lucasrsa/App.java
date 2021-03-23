package com.github.lucasrsa;

import java.util.*;

public class App {

    static private final List<Product> productList = new ArrayList<>();

    private static void save(Scanner sc) {

        System.out.print("Product name: ");
        final Product product = new Product(sc.next());
        if (productList.contains(product)) {
            System.out.println("Product " + product.getName() + " already exists!");
            return; // If a product with the same name already exists, return to main menu
        }

        while (true) {
            try {
                System.out.print("Product price: ");
                product.setPrice(sc.nextDouble());
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please input a valid price.");
                sc.next(); // Remove invalid input
            }
        }

        System.out.print("Product description: ");
        product.setDescription(sc.next());

        while (true) {
            try {
                System.out.print("Product quantity: ");
                product.setQuantity(sc.nextInt());
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please input a valid quantity.");
                sc.next(); // Remove invalid input
            }
        }

        System.out.print("Product category: ");
        product.setCategory(sc.next());

        productList.add(product);
        System.out.println("Product " + product.getName() + " added successfully.");
    }

    private static String search(String name) {
        for (Product product : productList) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product.describe();
            }
        }
        return "Product not found!";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        Options opt;
        do {
            System.out.println("Choose your option:");
            for (Options val : Options.values()) {
                System.out.println("\t" + val + " to " + val.describe());
            }
            System.out.print("-> ");

            try {
                opt = Options.valueOf(sc.next().toUpperCase());
                switch (opt) {
                    case SAVE:
                        save(sc);
                        break;
                    case LIST:
                        System.out.println("Products: " + productList);
                        break;
                    case SEARCH:
                        System.out.print("Please insert product name: ");
                        final String str = sc.next();
                        System.out.println(search(str));
                        break;
                    case EXIT:
                        System.out.println("Exiting application...");
                        break;
                    default:
                        break;
                }
            }catch (IllegalArgumentException e){
                System.out.println("Please input valid option.");
                opt = Options.LIST; // Assign placeholder Option to avoid exit
            }finally {
                System.out.println(); // Add new line for better visibility
            }
        } while (!opt.equals(Options.EXIT));
    }
}
