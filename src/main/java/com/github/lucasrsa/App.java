package com.github.lucasrsa;

import com.github.lucasrsa.collection.MainCollection;
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
                col.newProduct(sc);
                return;
            }
        }
        System.out.println("Collection " + auxName + " not found!");
    }

    public static void productMenu(Scanner sc) {

        while (true) {
            ProductOptions.describeOptions();
            try {
                switch (ProductOptions.valueOf(sc.nextLine().toUpperCase())) {
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

        String auxName;

        while (true) {
            CollectionOptions.describeOptions();
            try {
                switch (CollectionOptions.valueOf(sc.nextLine().toUpperCase())) {
                    case NEW:
                        System.out.print("Collection name: ");
                        auxName = sc.nextLine();
                        MainCollection auxCollection = new MainCollection(auxName);
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
                            System.out.println(col.listAllSubCollections());
                        }
                        return;
                    case SEARCH:
                        System.out.print("Choose a collection to search a product: ");
                        auxName = sc.nextLine();
                        for (MainCollection col : collectionList) {
                            if (col.toString().equalsIgnoreCase(auxName)) {
                                col.searchProduct(sc);
                                return;
                            }
                        }
                        System.out.println("Collection " + auxName + " not found!");
                        return;
                    case PRODUCTS:
                        System.out.print("Choose a collection or sub-collection to list all products: ");
                        auxName = sc.nextLine();
                        for (MainCollection col : collectionList) {
                            if (col.toString().equalsIgnoreCase(auxName)) {
                                for (Product product : col.getProductList()) {
                                    System.out.println(product.describe());
                                }
                                return;
                            } else if (col.listProducts(auxName)){
                                return;
                            }
                        }
                        System.out.println("Collection or sub-collection " + auxName + " not found!");
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

        while (true) {
            MainOptions.describeOptions();
            try {
                switch (MainOptions.valueOf(sc.nextLine().toUpperCase())) {
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
