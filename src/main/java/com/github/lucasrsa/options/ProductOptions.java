package com.github.lucasrsa.options;

public enum ProductOptions {
    SAVE, LIST, SEARCH, RETURN;

    private String describe(){
        switch (this){
            case SAVE:
                return "save a new product.";
            case LIST:
                return "list all products.";
            case SEARCH:
                return "search for a product by name.";
            case RETURN:
                return "return to main menu.";
            default:
                return ".";
        }
    }

    public static void describeOptions(){
        System.out.println("Choose your option:");
        for (ProductOptions val : ProductOptions.values()) {
            System.out.println("\t" + val + " to " + val.describe());
        }
        System.out.print("-> ");
    }
}
