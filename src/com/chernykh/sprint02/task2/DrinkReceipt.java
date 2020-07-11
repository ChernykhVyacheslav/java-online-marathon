package com.chernykh.sprint02.task2;

public interface DrinkReceipt {

    String getName();

    DrinkReceipt addComponent(String componentName, int componentCount);

}
