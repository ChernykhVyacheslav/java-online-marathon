package com.chernykh.Sprint4.task6;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee e1, Employee e2) {
        int i = new PersonComparator().compare(e1, e2);
        if (i != 0) {
            return i;
        }

        return Double.compare(e1.getSalary(), e2.getSalary());
    }
}
