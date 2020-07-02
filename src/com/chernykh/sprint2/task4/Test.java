package com.chernykh.sprint2.task4;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {

        ArrayList<Employee> workers = new ArrayList<>();

//        workers.add(new Employee("Ivan", 10, new BigDecimal(3000.00)));
//        workers.add(new Manager("Petro", 9, new BigDecimal(3000.00), 1.5));
//        workers.add(new Manager("Petro", 9, new BigDecimal(3000.00), 1.5));
//        workers.add(new Manager("Petro", 9, new BigDecimal(3000.00), 1.5));
//        workers.add(new Employee("Andriy", 7, new BigDecimal(3500.00)));
//        workers.add(new Employee("Ihor", 5, new BigDecimal(4500.00)));
//        workers.add(new Employee("Ihor", 5, new BigDecimal(4500.00)));
//        workers.add(new Manager("Vasyl", 8, new BigDecimal(2000.00), 2.0));
//        workers.add(new Employee("Ivan", 10, new BigDecimal(3000.00)));
//        workers.add(new Employee("Ivan", 10, new BigDecimal(3000.00)));
//        workers.add(new Employee("Ivan", 10, new BigDecimal(3000.00)));
//        workers.add(new Manager("Petro", 9, new BigDecimal(3000.00), 1.5));
//        workers.add(new Employee("Stepan", 8, new BigDecimal(4000.00)));
//        workers.add(new Employee("Andriy", 7, new BigDecimal(3500.00)));
//        workers.add(new Employee("Ihor", 5, new BigDecimal(3500.00)));
//        workers.add(new Manager("Vasyl", 8, new BigDecimal(2000.00), 2.0));
//        workers.add(new Employee(null, 0, null));
        workers.add(new Manager(null, 0, null, 0));
        workers.add(null);

        System.out.println(workers);

        System.out.println(new MyUtils().largestEmployees(workers));
    }
}
