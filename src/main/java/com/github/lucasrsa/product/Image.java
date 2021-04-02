package com.github.lucasrsa.product;

public class Image {
    private String name;
    private int size;
    private String extension;
    private String path;

    public Image(String url){
        this.path = url;
        this.extension = ".png";
        this.size = 0;
        this.name = "Image";
    }
}
