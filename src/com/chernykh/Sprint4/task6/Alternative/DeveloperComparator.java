package com.chernykh.Sprint4.task6.Alternative;

import com.chernykh.Sprint4.task6.Developer;
import com.chernykh.Sprint4.task6.Employee;

import java.util.Comparator;

public class DeveloperComparator implements Comparator<Developer> {

    static Comparator<Developer> COMPARATOR = Comparator.<Developer, Employee>comparing(
            Employee.class::cast, EmployeeComparator.COMPARATOR)
            .thenComparing(Developer::getLevel);

    @Override
    public int compare(Developer o1, Developer o2) {
        return COMPARATOR.compare(o1, o2);
    }
}
