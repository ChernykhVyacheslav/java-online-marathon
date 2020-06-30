package com.chernykh.Sprint6.task1;

import java.util.function.Function;

public class MyUtils2 {

    public static int getCount(int[] array, Function<Integer, Boolean> function) {
        int count = 0;
        for (int element :
                array) {
            if (function.apply(element)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(getCount(new int[]{1, 2, 3}, (a -> a % 2 == 0)));
    }

}
