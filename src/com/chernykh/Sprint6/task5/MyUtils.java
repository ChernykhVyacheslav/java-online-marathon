package com.chernykh.Sprint6.task5;

import java.util.Set;
import java.util.function.Predicate;

public class MyUtils {

    static Predicate<Integer> getPredicateFromSet(Set<Predicate<Integer>> predicates) {
        Predicate<Integer> resultPredicate = (a) -> (true);
        for (Predicate<Integer> tempPredicate :
                predicates) {
            resultPredicate = resultPredicate.and(tempPredicate);
        }
        return resultPredicate;
    }
}
