package com.chernykh.sprint3.task1;

public class Pizza {

    private String cheese;
    private String meat;
    private String seafood;
    private String vegetable;
    private String mushroom;

    private Pizza() {
    }

    public static PizzaBuilder base() {
        return new PizzaBuilder();
    }

    public static class PizzaBuilder {
        private Pizza pizza;

        private PizzaBuilder() {
            this.pizza = new Pizza();
        }

        PizzaBuilder addCheese(String cheese) {
            this.pizza.cheese = cheese;

            return this;
        }

        PizzaBuilder addMeat(String meat) {
            this.pizza.meat = meat;

            return this;
        }

        PizzaBuilder addSeafood(String seafood) {
            this.pizza.seafood = seafood;

            return this;
        }

        PizzaBuilder addVegetable(String vegetable) {
            this.pizza.vegetable = vegetable;

            return this;
        }

        PizzaBuilder addMushroom(String mushroom) {
            this.pizza.mushroom = mushroom;

            return this;
        }

        public Pizza build() {
            return this.pizza;
        }
    }
}
