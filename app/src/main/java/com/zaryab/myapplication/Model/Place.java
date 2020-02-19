package com.zaryab.myapplication.Model;

public class Place {
    private String name;
    private String Image;

    public Place() {
    }

    public Place(String name, String image) {
        this.name = name;
        Image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
