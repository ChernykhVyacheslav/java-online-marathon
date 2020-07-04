package com.chernykh.sprint7.task2;

import java.lang.reflect.Method;

public class Test {

    public static void main(String[] args) {
        try {
            Method method = Util.class.getDeclaredMethod("review", String.class);
            method.invoke(new Util(), "Class3");
        }
        catch (Exception e) {
            System.out.println("Oops");
        }
    }
}

@Review(reviewer = "me")
class Class3 {
}