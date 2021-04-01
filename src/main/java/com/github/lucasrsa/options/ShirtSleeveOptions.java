package com.github.lucasrsa.options;

public enum ShirtSleeveOptions {
    SHORT, LONG;

    public static void describeOptions() {
        System.out.print("Choose sleeve length (");
        for (ShirtSleeveOptions val : ShirtSleeveOptions.values()) {
            System.out.print(val + ", ");
        }
        System.out.print("): ");
    }
}
