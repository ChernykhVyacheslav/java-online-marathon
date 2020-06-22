package com.chernykh.Sprint4.task4;

public class ArrayUtil {

    public static <T> T setAndReturn(T[] numbers, T value, int elementIndex) {
        numbers[elementIndex] = value;
        return value;
    }

}
