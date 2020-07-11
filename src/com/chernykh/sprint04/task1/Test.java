package com.chernykh.sprint04.task1;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        //{0967654321=Petro, 0677654321=Petro, 0501234567=Ivan, 0970011223=Stepan, 0631234567=Ivan}

        Map<String, String> testMap = new HashMap<String, String>() {{
            put("0967654321", "Petro");
            put("0677654321", "Petro");
            put("0501234567", "Ivan");
            put("0970011223", "Stepan");
            put("0631234567", "Ivan");
        }};

        System.out.println(new MyUtils().createNotebook(testMap));
    }
}
