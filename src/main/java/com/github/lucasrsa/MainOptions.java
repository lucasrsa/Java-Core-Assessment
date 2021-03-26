package com.github.lucasrsa;

public enum MainOptions {
    PRODUCT, COLLECTION, EXIT;

    public String describe(){
        switch (this){
            case PRODUCT:
                return "manage products.";
            case COLLECTION:
                return "manage collections.";
            case EXIT:
                return "exit the application.";
            default:
                return ".";
        }
    }
}
