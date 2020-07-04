package com.chernykh.sprint7.task3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestSuitHandler {

    public static void run(Class<?> clazz) {
        if (clazz.isAnnotationPresent(TestSuite.class)) {
            TestSuite testSuite = clazz.getAnnotation(TestSuite.class);
            String[] methodNames = testSuite.value();
            for (String methodName :
                    methodNames) {
                try {
                    Method currentMethod = clazz.getMethod(methodName);

                    System.out.println("\t -- Method " + clazz.getSimpleName() + "."
                            + currentMethod.getName() + " started --");

                    currentMethod.invoke(clazz.getDeclaredConstructor().newInstance());

                    System.out.println("\t -- Method " + clazz.getSimpleName() + "."
                            + currentMethod.getName() + " finished --");

                } catch (NoSuchMethodException | IllegalAccessException |
                        InvocationTargetException | InstantiationException e) {
                    System.out.println("Method with name " + methodName +
                            " doesn't exists or not public in class " + clazz.getSimpleName());
                }
            }
        } else {
            System.out.println("Class " + clazz.getSimpleName() + " isn't annotated");
        }
    }
}
