package com.chernykh.Sprint2.task5;

import java.util.Collections;
import java.util.List;

public class MyUtils {

    public double sumPerimeter(List<Rectang> figures) {
        if (figures == null || figures.isEmpty()) {
            return 0;
        }

        figures.removeAll(Collections.singletonList(null));

        double sum = 0;
        for (Rectang figure :
                figures) {
            sum += figure.getPerimeter();
        }
        return sum;
    }

}
