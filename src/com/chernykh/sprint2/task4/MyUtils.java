package com.chernykh.sprint2.task4;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class MyUtils {

    public List<Employee> largestEmployees(List<Employee> workers) {
        List<Employee> bestEmployees = new ArrayList<>();
        if(workers == null || workers.isEmpty()) {
            return bestEmployees;
        }

        workers.removeAll(Collections.singletonList(null));

        List<Employee> mostExperiencedEmployees = getTheMostExperiencedEmployees(workers);
        if (mostExperiencedEmployees != null && !mostExperiencedEmployees.isEmpty()) {
            bestEmployees.addAll(mostExperiencedEmployees);
        }

        List<Employee> mostProductiveEmployees = getTheMostProductiveEmployees(workers);
        if (mostProductiveEmployees != null && !mostProductiveEmployees.isEmpty()) {
            bestEmployees.addAll(mostProductiveEmployees);
        }

        return bestEmployees.stream().distinct().collect(Collectors.toList());
    }

    private List<Employee> getTheMostProductiveEmployees(List<Employee> workers) {
        if(workers.isEmpty()) {
            return null;
        }
        Employee bestEmployee = Collections.max(workers, new ProductivenessComparator());
        BigDecimal maxSalary = bestEmployee.getPayment();
        return workers.stream().distinct().filter(
                p -> p.getPayment().compareTo(maxSalary) == 0
        ).collect(Collectors.toList());
    }

    private List<Employee> getTheMostExperiencedEmployees(List<Employee> workers) {
        if(workers.isEmpty()) {
            return null;
        }
        Employee bestEmployee = Collections.max(workers, new ExperienceComparator());
        int maxExperience = bestEmployee.getExperience();

        return workers.stream().distinct().filter(
                p -> p.getExperience() == maxExperience
        ).collect(Collectors.toList());
    }

    private class ProductivenessComparator implements Comparator<Employee> {

        public int compare(Employee e1, Employee e2) {
            return e1.getPayment().compareTo(e2.getPayment());
        }
    }

    private class ExperienceComparator implements Comparator<Employee> {

        public int compare(Employee e1, Employee e2) {
            if(e1.getExperience() < e2.getExperience())
                return -1;
            if(e1.getExperience() > e2.getExperience())
                return 1;
            return 0;
        }
    }
}
