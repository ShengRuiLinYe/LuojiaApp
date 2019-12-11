package com.example.luojiaapp;

public class Item {
    private String name;
    private int imageId;
    private int imageId2;
    private int price;
    private int sales;

    public Item(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
        imageId2 = R.drawable.saber;
        price = 100;
        sales = 0;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
    public int getImageId2() {return imageId2;}
    public int getPrice(){return price;}
    public int getSales(){return sales;}

}
