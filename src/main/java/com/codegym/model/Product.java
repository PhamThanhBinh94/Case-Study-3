package com.codegym.model;

public class Product {
    public String id;
    public String type;
    public String name;
    public String brand;
    public int price;
    public String image;
    public int amount;

    public Product() {
    }

    public Product(String id, String type, String name, String brand, int price, String image, int amount) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.image = image;
        this.amount = amount;
    }

    public Product(String id, String type, String name, String brand) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.brand = brand;
    }

    public Product(String type, String name, String brand, int price, String image, int amount) {
        this.type = type;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.image = image;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
