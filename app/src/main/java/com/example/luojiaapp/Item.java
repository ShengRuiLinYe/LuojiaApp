package com.example.luojiaapp;

public class Item {
    private String name;
    private int imageId;
    private int imageId2;
    private int price;
    private int sales;
    private int category;

    final static int book = 1;
    final static int electric = 2;
    final static int life = 3;
    final static int other = 0;

    public Item(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
        imageId2 = R.drawable.saber;
        this.price = -1;
        this.sales = -1;
        this.category = other;
    }

    public Item(String name, int imageId, int imageId2, int price, int sales, int category) {
        this.name = name;
        this.imageId = imageId;
        this.imageId2 = imageId2;
        this.price = price;
        this.sales = sales;
        this.category = category;
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
    public int getCategory() {return category;}

    public void setName(String name){this.name = name;}
    public void setPrice(int price) {this.price = price;}
    public void setSales(int sales) {this.sales = sales;}
    public void setCategory(int category) {this.category = category;}
    public void setImageId(int imageId) {this.imageId = imageId;}
    public void setImageId2(int imageId2) {this.imageId2 = imageId2;}

}
