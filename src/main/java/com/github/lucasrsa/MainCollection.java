package com.github.lucasrsa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainCollection extends Collection {

    private final List<SubCollection> subCollectionList;

    public void addSubCollection(SubCollection subCollection) {
        this.subCollectionList.add(subCollection);
    }

    public List<SubCollection> getSubCollectionList() {
        return this.subCollectionList;
    }

    public void setData(Scanner sc) {
        System.out.print("Collection description: ");
        this.setDescription(sc.nextLine());

        this.setKeywords(sc);
    }

    @Override
    public String toString() {
        String aux;
        StringBuilder str = new StringBuilder("Collection " + this.name + ":");
        for (SubCollection sub : subCollectionList) {
            aux = "\n\t" + sub;
            str.append(aux);
        }
        return str.toString();
    }

    public MainCollection(String name) {
        super(name);

        this.subCollectionList = new ArrayList<>();
    }
}
