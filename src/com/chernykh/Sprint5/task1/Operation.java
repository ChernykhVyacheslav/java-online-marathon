package com.chernykh.Sprint5.task1;

public class Operation {

    public static int squareRectangle(int a, int b) {
        if(a <= 0 || b <= 0) {
            throw new IllegalArgumentException("both arguments should be more than zero");
        }
        return a * b;
    }

    public static int trySquareRectangle(int a, int b) {
        int result = -1;
        try {
            result = squareRectangle(a, b);
        } finally {
            return result;
        }
    }


}
