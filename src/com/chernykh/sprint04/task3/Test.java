package com.chernykh.sprint04.task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>() {{
            add("aa");
            add("bb");
            add("aa");
            add("cc");
        }};
        System.out.println(list);

        Map<String, String> map = new HashMap<>() {{
            put("1", "cc");
            put("2", "bb");
            put("3", "cc");
            put("4", "aa");
            put("5", "cc");
            put("6", "dd");
        }};
        System.out.println(map);

        System.out.println(new MyUtils().listMapCompare(list, map));

    }
}
