package com.chernykh.sprint01.task6;

public class Product {

    private String name;
    private double price;
    private static int counter = 0;

    public Product() {
        this.name = null;
        this.price = 0;
        this.counter++;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.counter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static int count() {
        return counter;
    }
}
