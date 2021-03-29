package com.github.lucasrsa;

public enum CollectionOptions {
    NEW, SUB, LIST, SEARCH, PRODUCTS, RETURN;

    private String describe(){
        switch (this){
            case NEW:
                return "create a new collection.";
            case SUB:
                return "create a new sub-collection.";
            case LIST:
                return "list all collections and its sub-collections.";
            case SEARCH:
                return "search for a product by name in a sub-collection.";
            case PRODUCTS:
                return "list all products in a collection or sub-collection.";
            case RETURN:
                return "return to main menu.";
            default:
                return ".";
        }
    }

    public static void describeOptions(){
        System.out.println("Choose your option:");
        for (CollectionOptions val : CollectionOptions.values()) {
            System.out.println("\t" + val + " to " + val.describe());
        }
        System.out.print("-> ");
    }
}
