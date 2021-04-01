package com.github.lucasrsa.options;

public enum ShirtSizeOptions {
    XS, S, M, L, XL, XXL, XXXL;

    public static void describeOptions() {
        System.out.print("Choose product size (");
        for (ShirtSizeOptions val : ShirtSizeOptions.values()) {
            System.out.print(val + ", ");
        }
        System.out.print("): ");
    }
}
