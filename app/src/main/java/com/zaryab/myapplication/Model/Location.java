package com.zaryab.myapplication.Model;

public class Location {

    private String Name, mapImage, Image,Description,Price,Discount,MenudId;

    public Location() {
    }

    public Location(String mapimage, String name, String image, String description, String price, String discount, String menudId) {
        Name = name;
        Image = image;
        Description = description;
        Price = price;
        Discount = discount;
        MenudId = menudId;
        mapImage = mapimage;
    }

    public String getMapImage() {
        return mapImage;
    }

    public void setMapImage(String mapimage) {
        this.mapImage = mapimage;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }

    public String getMenudId() {
        return MenudId;
    }

    public void setMenudId(String menudId) {
        MenudId = menudId;
    }
}
