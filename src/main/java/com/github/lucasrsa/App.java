package com.github.lucasrsa;

import com.github.lucasrsa.collection.MainCollection;
import com.github.lucasrsa.collection.SubCollection;
import com.github.lucasrsa.options.CollectionOptions;
import com.github.lucasrsa.options.MainOptions;
import com.github.lucasrsa.options.ProductOptions;
import com.github.lucasrsa.product.Product;

import java.util.*;
import java.util.stream.Collectors;

public class App {

    static private final List<MainCollection> collectionList = new ArrayList<>();

    private static String searchProduct(String name) {
        for (MainCollection collection : collectionList) {
            Product product = collection.getProduct(name);
            if (product != null) {
                return product.describe();
            }
        }
        return "Product not found!";
    }

    private static void saveProduct(Scanner sc) {
        System.out.print("Choose a collection to add product: ");
        String auxName = sc.nextLine();
        for (MainCollection col : collectionList) {
            if (col.toString().equalsIgnoreCase(auxName)) {
                System.out.print("Choose a sub-collection to add product: ");
                auxName = sc.nextLine();
                for (SubCollection subCol : col.getSubCollectionList()) {
                    if (subCol.toString().equalsIgnoreCase(auxName)) {
                        System.out.print("Product name: ");
                        auxName = sc.nextLine();
                        Product product = new Product(auxName);
                        if (subCol.getProductList().contains(product)) {
                            System.out.println("Product " + auxName + " already exists in " +
                                    "Collection " + col + "/" + subCol + "!");
                            return; // If a product with the same name already exists, return to main menu
                        }
                        product.setData(sc);
                        subCol.addProduct(product);
                        System.out.println("Product " + auxName + " added successfully.");
                        return;
                    }
                }
                System.out.println("Sub-Collection " + auxName + " not found!");
                return;
            }
        }
        System.out.println("Collection " + auxName + " not found!");
    }

    public static void productMenu(Scanner sc) {

        ProductOptions opt;

        while (true) {
            ProductOptions.describeOptions();
            opt = ProductOptions.valueOf(sc.nextLine().toUpperCase());
            try {
                switch (opt) {
                    case SAVE:
                        saveProduct(sc);
                        return;
                    case LIST:
                        System.out.print("Products: ");
                        System.out.println(collectionList.stream().flatMap(collection -> collection.getProductList().stream()).collect(Collectors.toList()));
                        return;
                    case SEARCH:
                        System.out.print("Please insert product name: ");
                        System.out.println(searchProduct(sc.nextLine()));
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
                                col.addSubCollection(sc);
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
