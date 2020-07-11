package com.chernykh.sprint01.task5;

public class Test {

    public static void main(String[] args) {
        Point p1 = new Point(4, 4);
        System.out.println(p1.getXYPair()[0] + " " + p1.getXYPair()[1]);
        System.out.println(p1.distance(3, 3));
        System.out.println(p1.distance(new Point(3, 3)));
    }

}
