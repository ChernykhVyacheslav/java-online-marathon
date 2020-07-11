package com.chernykh.sprint04.task6.Alternative;

import com.chernykh.sprint04.task6.Employee;
import com.chernykh.sprint04.task6.Person;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {

    static Comparator<Employee> COMPARATOR = Comparator.<Employee, Person>comparing(
            Person.class::cast, PersonComparator.COMPARATOR)
            .thenComparing(Employee::getSalary);

    @Override
    public int compare(Employee o1, Employee o2) {
        return COMPARATOR.compare(o1, o2);
    }
}
