package com.chernykh.Sprint3.task4;

public class MyUtils {

    public static String drawLine(LineType lineType) {
        return String.format("The line is %s type", lineType.toString().toLowerCase());
    }

}
