package com.chernykh.sprint06.task5;

import java.util.Set;
import java.util.function.Predicate;

public class MyUtils {

    static Predicate<Integer> getPredicateFromSet(Set<Predicate<Integer>> predicates) {
        Predicate<Integer> resultPredicate = a -> (true);
        for (Predicate<Integer> tempPredicate :
                predicates) {
            resultPredicate = resultPredicate.and(tempPredicate);
        }
        return resultPredicate;
    }

    static Predicate<Integer> getPredicateFromSet2(Set<Predicate<Integer>> predicates) {
        Predicate<Integer> resultPredicate = null;
        for (Predicate<Integer> tempPredicate :
                predicates) {
            if(resultPredicate != null) {
                resultPredicate = resultPredicate.and(tempPredicate);
            } else {
                resultPredicate = tempPredicate;
            }
        }
        return resultPredicate;
    }
}
