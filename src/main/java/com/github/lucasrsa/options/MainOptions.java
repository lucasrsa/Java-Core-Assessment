package com.github.lucasrsa.options;

public enum MainOptions {
    PRODUCT, COLLECTION, EXIT;

    private String describe(){
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

    public static void describeOptions(){
        System.out.println("Choose your option:");
        for (MainOptions val : MainOptions.values()) {
            System.out.println("\t" + val + " to " + val.describe());
        }
        System.out.print("-> ");
    }
}
