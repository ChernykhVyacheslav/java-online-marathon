package com.chernykh.sprint02.task2;

import java.util.HashMap;
import java.util.Map;

public class Caffee implements DrinkReceipt, DrinkPreparation, Rating {

    private String name;
    private int rating;
    private Map<String, Integer> ingredients;

    public Caffee(String name, int rating) {
        this.name = name;
        this.rating = rating;
        this.ingredients = new HashMap<>();
    }

    @Override
    public Map<String, Integer> makeDrink() {
        if (ingredients.isEmpty()) {
            ingredients.put("Water", 100);
            ingredients.put("Arabica", 20);
        }
        return ingredients;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public DrinkReceipt addComponent(String componentName, int componentCount) {
        if (!ingredients.containsKey(componentName)) {
            ingredients.put(componentName, componentCount);
        }
        return this;
    }

    @Override
    public int getRating() {
        return this.rating;
    }
}
