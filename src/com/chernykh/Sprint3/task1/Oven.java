package com.chernykh.Sprint3.task1;

public class Oven {

    public static Pizza cook() {


        return Pizza.base()
                .addCheese("Random Cheese")
                .addMeat("Random Meat")
                .addMushroom("Random Mushrooms")
                .addSeafood("Pls no")
                .addVegetable("Just not tomatoes plz").build();
    }

}
