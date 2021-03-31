package com.github.lucasrsa.options;

import com.github.lucasrsa.product.Pants;
import com.github.lucasrsa.product.Sneakers;
import com.github.lucasrsa.product.TShirt;
import com.github.lucasrsa.product.Variant;

public enum VariantOptions {
    TSHIRT, SNEAKERS, PANTS;

    public Variant getVariant(){
        switch (this){
            case TSHIRT:
                return new TShirt();
            case SNEAKERS:
                return new Sneakers();
            case PANTS:
                return new Pants();
            default:
                return null;
        }
    }

    public static void describeOptions(){
        System.out.println("Choose a variant (Leave empty if none).");
        System.out.print("Options available: ");
        for (VariantOptions val : VariantOptions.values()) {
            System.out.print(val + " ");
        }
        System.out.print("\n-> ");
    }
}
