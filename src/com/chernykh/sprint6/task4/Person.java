package com.chernykh.sprint6.task4;

public class Person {

    String name;

    Person(String name) {
        this.name = name;
    }

    DecisionMethod goShopping = ((product, discount) -> (product.equals("product1") && discount > 10));

}
