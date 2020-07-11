package com.chernykh.sprint02.task5;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        List<Rectang> figures = new ArrayList<>();
        figures.add(new Square(4.0));
        figures.add(new Square(5.0));
        figures.add(new Rectang(2.0, 3.0));

        System.out.println(figures);

        System.out.println(new MyUtils().sumPerimeter(figures));
    }
}
