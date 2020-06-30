package com.chernykh.Sprint6.task1;

import java.util.function.Predicate;

public class MyUtils {

    public static int getCount(int[] array, Predicate<Integer> predicate) {
        int count = 0;
        for (int element :
                array) {
            if (predicate.test(element)) {
                count++;
            }
        }
        return count;
    }

}
