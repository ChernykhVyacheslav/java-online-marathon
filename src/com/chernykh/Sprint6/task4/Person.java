package com.chernykh.Sprint6.task4;

public class Person {

    String name;

    Person(String name) {
        this.name = name;
    }

    DecisionMethod goShopping = ((name, discount) -> (name.equals("product1") && discount > 10));

}
