package com.github.lucasrsa;

import java.util.*;

public class App {

    static private final List<Product> productList = new ArrayList<>();

    private static String searchProduct(String name) {
        for (Product product : productList) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product.describe();
            }
        }
        return "Product not found!";
    }

    public static void productMenu(Scanner sc){

        ProductOptions opt;

        do {
            System.out.println("Choose your option:");
            for (ProductOptions val : ProductOptions.values()) {
                System.out.println("\t" + val + " to " + val.describe());
            }
            System.out.print("-> ");
            opt = ProductOptions.valueOf(sc.next().toUpperCase());
            try {
                switch (opt) {
                    case SAVE:
                        System.out.print("Product name: ");
                        final String name = sc.next();
                        // Product method .equals is implemented to also receive String
                        if (productList.contains(name)) {
                            System.out.println("Product " + name + " already exists!");
                            return; // If a product with the same name already exists, return to main menu
                        }
                        productList.add(new Product(name, sc));
                        System.out.println("Product " + name + " added successfully.");
                        break;
                    case LIST:
                        System.out.println("Products: " + productList);
                        break;
                    case SEARCH:
                        System.out.print("Please insert product name: ");
                        final String str = sc.next();
                        System.out.println(searchProduct(str));
                        break;
                    case RETURN:
                        break;
                    default:
                        throw new IllegalArgumentException("No option match");
                }
                opt = ProductOptions.RETURN; // If no exception was thrown, return to main menu
            }catch (IllegalArgumentException e){
                System.out.println("Please input valid option.");
                opt = ProductOptions.LIST; // Attribute random value to avoid returning to main menu
            }finally {
                System.out.println(); // Add new line for better visibility
            }
        } while (!opt.equals(ProductOptions.RETURN));
    }

    public static void collectionMenu(Scanner sc){
        System.out.println("collection");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        MainOptions opt;

        do {
            System.out.println("Choose your option:");
            for (MainOptions val : MainOptions.values()) {
                System.out.println("\t" + val + " to " + val.describe());
            }
            System.out.print("-> ");
            try {
                opt = MainOptions.valueOf(sc.next().toUpperCase());
                switch (opt) {
                    case PRODUCT:
                        productMenu(sc);
                        break;
                    case COLLECTION:
                        collectionMenu(sc);
                        break;
                    case EXIT:
                        System.out.println("Exiting application...");
                        break;
                    default:
                        throw new IllegalArgumentException("No option match");
                }
            }catch (IllegalArgumentException e){
                System.out.println("Please input valid option.");
                opt = MainOptions.PRODUCT; // Attribute random value to avoid exiting application
            }finally {
                System.out.println(); // Add new line for better visibility
            }
        } while (!opt.equals(MainOptions.EXIT));
    }
}
