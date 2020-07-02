package com.chernykh.sprint1.task4;

public class Circle {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public void draw() {
        // Draw Sqaure with default color and radius
    }


    public void draw(String color) {
        // Draw Sqaure with provided color and default radius
    }

    public void draw(float scale) {
        // Draw Sqaure with default color and scaled radius
    }


    public void draw(String color, float scale) {
        // Draw Sqaure with provided color and scaled radius
    }
}
