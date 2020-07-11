package com.chernykh.sprint06.task2;

import java.util.function.Consumer;

public class App {

    private static Consumer<double[]> cons = (array -> {
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 2) {
                array[i] *= 0.8;
            } else {
                array[i] *= 0.9;
            }
        }
    });

    public static double[] getChanged(double[] initialArray, Consumer<double[]> cons) {
        double[] tempArray = initialArray.clone();
        cons.accept(tempArray);
        return tempArray;
    }

    public static void main(String[] args) {
        double[] arr = getChanged(new double[]{1.0, 2.0, 3.0}, cons);
        for (double d :
                arr) {
            System.out.println(d);
        }
    }
}
