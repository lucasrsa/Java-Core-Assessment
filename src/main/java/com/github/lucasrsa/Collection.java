package com.github.lucasrsa;

import java.util.Scanner;

public abstract class Collection extends Describable {

    protected String[] keywords = new String[5];

    protected void setKeywords(Scanner sc) {
        int available = this.keywords.length;
        String opt;
        do {
            opt = sc.next();
        } while (!opt.equalsIgnoreCase("NO"));
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
