package com.chernykh.sprint6.task1;

import java.util.function.IntPredicate;

public class MyUtils {

    public static int getCount(int[] array, IntPredicate predicate) {
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
