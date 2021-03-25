package com.github.lucasrsa;

public enum ProductOptions {
    SAVE, LIST, SEARCH, EXIT;

    public String describe(){
        switch (this){
            case SAVE:
                return "save a new product.";
            case LIST:
                return "list all products.";
            case SEARCH:
                return "search for a product by name.";
            case EXIT:
                return "exit the application.";
            default:
                return ".";
        }
    }
}
