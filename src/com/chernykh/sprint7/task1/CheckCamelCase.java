package com.chernykh.sprint7.task1;

import java.lang.reflect.Method;
import java.util.Objects;

public class CheckCamelCase {

    public static final String CAMELCASE_PATTERN = "^[a-z]+([A-Z][a-z0-9]+)*";

    public static boolean checkAndPrint(Class<?> clazz) {
        if(Objects.isNull(clazz)) {
            return false;
        }
        boolean isEveryMethodCamelCase = true;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m:
             methods) {
            if(m.isAnnotationPresent(CamelCase.class) && !m.getName().matches(CAMELCASE_PATTERN)) {
                System.out.println("method " + clazz.getSimpleName() + "." +
                        m.getName() + " doesn't satisfy camelCase naming convention");
                isEveryMethodCamelCase = false;
            }
        }
        return isEveryMethodCamelCase;
    }

}
