package com.github.lucasrsa;

import java.util.Scanner;

public abstract class Collection extends Describable {

    protected String[] keywords = new String[6];

    protected void setKeywords(Scanner sc) {
        String str;
        for (int i = 0; i < this.keywords.length; i++) {
            System.out.printf("Add keyword %d/%d (Leave empty to continue): ", i+1, this.keywords.length);
            str = sc.next();
            if (str.isEmpty()){
                break;
            }
            this.keywords[i] = str;
        }
    }

    public String[] getKeywords() {
        return this.keywords;
    }

    public void setKeywords(String[] keywords) {
        this.keywords = keywords;
    }

    public Collection(String name) {
        super(name);
    }
}
