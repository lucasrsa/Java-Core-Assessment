package com.github.lucasrsa;

public enum ProductOptions {
    SAVE, LIST, SEARCH, RETURN;

    public String describe(){
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
}
