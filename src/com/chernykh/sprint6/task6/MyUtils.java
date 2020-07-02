package com.chernykh.sprint6.task6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class MyUtils {

    public static int findMaxByCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        List<Integer> tempNumbers = new ArrayList<>(numbers);
        tempNumbers.removeIf(predicate.negate());
        return Collections.max(tempNumbers);
    }
}
