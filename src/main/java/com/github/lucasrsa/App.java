package com.github.lucasrsa;

import com.github.lucasrsa.collection.MainCollection;
import com.github.lucasrsa.collection.SubCollection;
import com.github.lucasrsa.options.CollectionOptions;
import com.github.lucasrsa.options.MainOptions;
import com.github.lucasrsa.options.ProductOptions;
import com.github.lucasrsa.product.Product;

import java.util.*;

public class App {

    static private final List<Product> productList = new ArrayList<>();
    static private final List<MainCollection> collectionList = new ArrayList<>();

    private static String searchProduct(String name) {
        for (Product product : productList) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product.describe();
            }
        }
        return "Product not found!";
    }

    public static void productMenu(Scanner sc) {

        ProductOptions opt;

        while (true) {
            ProductOptions.describeOptions();
            opt = ProductOptions.valueOf(sc.nextLine().toUpperCase());
            try {
                switch (opt) {
                    case SAVE:
                        System.out.print("Product name: ");
                        final String name = sc.nextLine();
                        Product product = new Product(name);
                        if (productList.contains(product)) {
                            System.out.println("Product " + name + " already exists!");
                            return; // If a product with the same name already exists, return to main menu
                        }
                        product.setData(sc);
                        productList.add(product);
                        System.out.println("Product " + name + " added successfully.");
                        return;
                    case LIST:
                        System.out.println("Products: " + productList);
                        return;
                    case SEARCH:
                        System.out.print("Please insert product name: ");
                        final String str = sc.nextLine();
                        System.out.println(searchProduct(str));
                        return;
                    case RETURN:
                        return;
                    default:
                        throw new IllegalArgumentException("No option match");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Please input valid option.");
            } finally {
                System.out.println(); // Add new line for better visibility
            }
        }
    }

    public static void collectionMenu(Scanner sc) {

        CollectionOptions opt;
        MainCollection auxCollection;
        String auxName;

        while (true) {
            CollectionOptions.describeOptions();
            opt = CollectionOptions.valueOf(sc.nextLine().toUpperCase());
            try {
                switch (opt) {
                    case NEW:
                        System.out.print("Collection name: ");
                        auxName = sc.nextLine();
                        auxCollection = new MainCollection(auxName);
                        if (collectionList.contains(auxCollection)) {
                            System.out.println("Collection " + auxName + " already exists!");
                            return; // If a collection with the same name already exists, return to main menu
                        }
                        auxCollection.setData(sc);
                        collectionList.add(auxCollection);
                        System.out.println("Collection " + auxName + " added successfully.");
                        return;
                    case SUB:
                        System.out.print("Choose a collection to add sub-collection: ");
                        auxName = sc.nextLine();
                        for (MainCollection col : collectionList) {
                            if (col.toString().equalsIgnoreCase(auxName)) {
                                System.out.print("Sub-Collection name: ");
                                auxName = sc.nextLine();
                                SubCollection subCollection = new SubCollection(auxName);
                                if (col.getSubCollectionList().contains(subCollection)) {
                                    System.out.println("Sub-Collection " + auxName + " already exists in " +
                                            "Collection " + col + "!");
                                    return; // If a sub-collection with the same name already exists, return to main menu
                                }
                                subCollection.setData(sc);
                                col.addSubCollection(subCollection);
                                System.out.println("Sub-collection " + auxName + " added successfully.");
                                return;
                            }
                        }
                        System.out.println("Collection " + auxName + " not found!");
                        return;
                    case LIST:
                        for (MainCollection col : collectionList) {
                            System.out.println(col.listAll());
                        }
                        return;
                    case SEARCH:
                        return;
                    case PRODUCTS:
                        return;
                    case RETURN:
                        return;
                    default:
                        throw new IllegalArgumentException("No option match");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Please input valid option.");
            } finally {
//                // Cleanup auxiliary variables
//                auxCollection = null;
//                auxName = null;
                System.out.println(); // Add new line for better visibility
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.getDefault());
        MainOptions opt;

        while (true) {
            MainOptions.describeOptions();
            try {
                opt = MainOptions.valueOf(sc.nextLine().toUpperCase());
                switch (opt) {
                    case PRODUCT:
                        productMenu(sc);
                        break;
                    case COLLECTION:
                        collectionMenu(sc);
                        break;
                    case EXIT:
                        System.out.println("Exiting application...");
                        return;
                    default:
                        throw new IllegalArgumentException("No option match");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Please input valid option.");
            } finally {
                System.out.println(); // Add new line for better visibility
            }
        }
    }
}
