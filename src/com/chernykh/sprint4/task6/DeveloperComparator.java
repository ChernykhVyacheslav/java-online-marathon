package com.chernykh.sprint4.task6;

import java.util.Comparator;

public class DeveloperComparator implements Comparator<Developer> {

    @Override
    public int compare(Developer d1, Developer d2) {
        int i = new EmployeeComparator().compare(d1, d2);
        if (i != 0) {
            return i;
        }

        return d1.getLevel().compareTo(d2.getLevel());
    }
}
