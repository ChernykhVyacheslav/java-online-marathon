package com.chernykh.sprint2.task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MyUtils {

    public Map<String, Double> averageRating(List<Caffee> coffees) {
        Map<String, Double> averageRatings = new HashMap<>();
        for (Caffee tempCaffee :
                coffees) {
            averageRatings.put(tempCaffee.getName(),
                    getAverageRatingForOneItem(tempCaffee.getClass(), coffees));
        }
        return averageRatings;
    }

    private Double getAverageRatingForOneItem(Class caffeeClass, List<Caffee> coffees) {
        ArrayList<Caffee> tempArray = coffees.stream().filter(
                p -> p.getClass().equals(caffeeClass)
        ).collect(Collectors.toCollection(ArrayList::new));
        double sum = 0;
        for (Caffee tempCaffee :
                tempArray) {
            sum += tempCaffee.getRating();
        }
        return sum / tempArray.size();
    }

}
