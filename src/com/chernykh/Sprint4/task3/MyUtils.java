package com.chernykh.Sprint4.task3;

import java.util.List;
import java.util.Map;

public class MyUtils {

    public boolean listMapCompare(List<String> list, Map<String, String> map) {
        boolean result = true;
        for (String valueToCompare :
                list) {
            if (!map.containsValue(valueToCompare)) {
                result = false;
                break;
            }
        }

        for (Map.Entry entryToCompare :
                map.entrySet()) {
            if (!list.contains(entryToCompare.getValue())) {
                result = false;
                break;
            }
        }

        return result;
    }

}
