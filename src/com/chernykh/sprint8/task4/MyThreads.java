package com.chernykh.sprint8.task4;

public class MyThreads {

    public static final Object obj = new Object();

    public static int n;
    public static int m;

    public static Thread t1 = new Thread() {
        @Override
        public void run() {
            try {
                synchronized (obj) {
                    for (int i = 0; i < 5; i++, n++) {
                        System.out.println("Thread1 n = " + n);
                    }
                    obj.wait(3000);
                    for (int i = 0; i < 5; i++, m++) {
                        System.out.println("Thread1 m = " + m);
                    }
                    System.out.println("Thread1 success!");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    public static Thread t2 = new Thread() {
        @Override
        public void run() {
            synchronized (obj) {
                for (int i = 0; i < 5; i++, m++) {
                    System.out.println("Thread2 m = " + m);
                }
                for (int i = 0; i < 5; i++, n++) {
                    System.out.println("Thread2 n = " + n);
                }
                System.out.println("Thread2 success!");
                obj.notify();
            }
        }
    };
}
