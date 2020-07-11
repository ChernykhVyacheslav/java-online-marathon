package com.chernykh.sprint05.task3;

import com.chernykh.sprint05.task2.*;

public class Utils {


    public static Plant tryCreatePlant(String type, String color, String name) {
        try {
            return new Plant(type, color, name);
        } catch (ColorException e) {
            return tryCreatePlant(type, Color.RED.name(), name);
        } catch (TypeException e) {
            return tryCreatePlant(Type.ORDINARY.name(), color, name);
        }
    }
}
