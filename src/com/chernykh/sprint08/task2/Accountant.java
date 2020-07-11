package com.chernykh.sprint08.task2;

import com.chernykh.sprint08.task1.ParallelCalculator;

public class Accountant {

    public static int sum(int x, int y) {
        ParallelCalculator sumCalculator = new ParallelCalculator(Integer::sum, x, y);
        Thread thread = new Thread(sumCalculator);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return sumCalculator.result;
    }
}