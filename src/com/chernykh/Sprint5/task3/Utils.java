package com.chernykh.Sprint5.task3;

import com.chernykh.Sprint5.task2.*;

public class Utils {


    public static Plant tryCreatePlant(String type, String color, String name) {
        Plant newPlant;
        try {
            newPlant = new Plant(type, color, name);
        } catch (ColorException e) {
            newPlant = tryCreatePlant(type, Color.RED.name(), name);
        } catch (TypeException e) {
            newPlant = tryCreatePlant(Type.ORDINARY.name(), color, name);
        }
        return newPlant;
    }
}
