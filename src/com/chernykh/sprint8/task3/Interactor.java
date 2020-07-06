package com.chernykh.sprint8.task3;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class Interactor {

    int x;

    public void serve(UnaryOperator<Integer> uo, int initializer) throws InterruptedException {
        synchronized (this) {
            System.out.println("Serving thread running");
            System.out.println("Serving thread initializes the key");
            x = uo.apply(initializer);
            System.out.println("key = " + x);
            this.notify();
            this.wait();
            System.out.println("Serving thread resumed");
        }
    }

    public void consume(BinaryOperator<Integer> bo, int operand2) throws InterruptedException {
        synchronized (this) {
            this.wait(3000);
            System.out.println("Consuming thread received the key. key = " + x);
            x = bo.apply(x, operand2);
            System.out.println("Consuming thread changed the key. key = " + x);
            this.notify();
        }
    }
}
