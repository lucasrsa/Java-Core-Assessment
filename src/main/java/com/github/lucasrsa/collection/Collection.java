package com.github.lucasrsa.collection;

import com.github.lucasrsa.Describable;

import java.util.Scanner;

public abstract class Collection extends Describable {

    protected String[] keywords = new String[6];

    protected void setKeywords(Scanner sc) {
        String str;
        for (int i = 0; i < this.keywords.length; i++) {
            System.out.printf("Add keyword %d/%d (Leave empty to continue): ", i+1, this.keywords.length);
            str = sc.nextLine();
            if (str.isEmpty()){
                break;
            }
            this.keywords[i] = str;
        }
    }

    public Collection(String name) {
        super(name);
    }
}
