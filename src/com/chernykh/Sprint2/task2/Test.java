package com.chernykh.Sprint2.task2;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Caffee> coffees = new ArrayList<>();
        coffees.add(new Espresso("Espresso", 8));
        coffees.add(new Cappuccino("Cappuccino", 10));
        coffees.add(new Espresso("Espresso", 10));
        coffees.add(new Cappuccino("Cappuccino", 6));
        coffees.add(new Caffee("Caffee", 6));
        System.out.println(new MyUtils().averageRating(coffees));

        for (Caffee caffee:
             coffees) {
            System.out.println(caffee.makeDrink());
        }
    }
}
