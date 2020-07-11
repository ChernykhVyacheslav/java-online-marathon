package com.chernykh.sprint02.task5;

public class Square extends Rectang {

    public Square(double width) {
        super(width);
    }

    public double getPerimeter() {
        return super.getPerimeter();
    }

    @Override
    public String toString() {
        return "Square [" +
                "width=" + getWidth() +
                ']';
    }
}
