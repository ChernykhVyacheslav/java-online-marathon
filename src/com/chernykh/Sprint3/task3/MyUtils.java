package com.chernykh.Sprint3.task3;

public class MyUtils {

    public static void execute(int a, int b, Strategy strategy) {
        double result = strategy.doOperation(a, b);
        System.out.println(result);
    }

    public static void addAtoB(int a, int b) {

        Strategy strategy = new Strategy() {
            @Override
            public double doOperation(int a, int b) {
                return a + b;
            }
        };
        execute(a, b, strategy);

    }

    public static void subtractBfromA(int a, int b) {

        Strategy strategy = new Strategy() {
            @Override
            public double doOperation(int a, int b) {
                return a - b;
            }
        };
        execute(a, b, strategy);


    }

    public static void multiplyAbyB(int a, int b) {

        Strategy strategy = new Strategy() {
            @Override
            public double doOperation(int a, int b) {
                return a * b;
            }
        };
        execute(a, b, strategy);

    }

    public static void divideAbyB(int a, int b) {

        Strategy strategy = new Strategy() {
            @Override
            public double doOperation(int a, int b) {
                return (double)a / (double)b;
            }
        };
        execute(a, b, strategy);

    }

}
