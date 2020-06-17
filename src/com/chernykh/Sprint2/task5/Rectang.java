package com.chernykh.Sprint2.task5;

public class Rectang {

    private double height;
    private double width;

    public Rectang(double width) {
        this.height = width;
        this.width = width;
    }

    public Rectang(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getPerimeter() {
        return calculatePerimeter(height, width);
    }

    private double calculatePerimeter(double height, double width) {
        return Double.sum((2 * width), (2 * height));
    }

    @Override
    public String toString() {
        return "Rectang [" +
                "height=" + height +
                ", width=" + width +
                ']';
    }
}
