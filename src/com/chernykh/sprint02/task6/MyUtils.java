package com.chernykh.sprint02.task6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyUtils {

    public List<Shape> maxAreas(List<Shape> shapes) {
        List<Shape> maxShapes = new ArrayList<>();
        if (shapes == null || shapes.isEmpty()) {
            return maxShapes;
        }

        shapes.removeAll(Collections.singletonList(null));

        for (Shape tempShape :
                shapes) {
            maxShapes.addAll(getMaxShapes(tempShape.getClass(), shapes));
        }

        return maxShapes;
    }

    private List<Shape> getMaxShapes(Class shapeClass, List<Shape> shapes) {
        List<Shape> tempShapes = shapes.stream().filter(
                p -> p.getClass().equals(shapeClass)
        ).collect(Collectors.toList());


        double maxArea = Collections.max(tempShapes, Comparator.comparingDouble(Shape::getArea)).getArea();

        return tempShapes.stream().distinct().filter(
                p -> p.getArea() == maxArea
        ).collect(Collectors.toList());
    }

}
