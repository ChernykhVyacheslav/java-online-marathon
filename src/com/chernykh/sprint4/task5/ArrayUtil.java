package com.chernykh.sprint4.task5;

public class ArrayUtil {

    static <T extends Number> double averageValue(Array<T> numbers) {
        double sum = 0;

        for (int i = 0; i < numbers.length(); i++) {
            sum += numbers.get(i).doubleValue();
        }

        return sum / numbers.length();
    }

}
