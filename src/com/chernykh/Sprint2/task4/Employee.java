package com.chernykh.Sprint2.task4;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Objects;

public class Employee implements Comparable<Employee> {

    private String name;
    private int experience;
    private BigDecimal basePayment;

    public Employee(String name, int experience, BigDecimal basePayment) {

        this.name = Objects.requireNonNullElse(name, "");

        this.basePayment = Objects.requireNonNullElseGet(basePayment, () -> new BigDecimal(0.0));

        this.experience = Math.max(experience, 0);
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public BigDecimal getPayment() {
        return basePayment;
    }

    @Override
    public String toString() {
        return "Employee [" +
                "name=" + name +
                ", experience=" + experience +
                ", basePayment=" + basePayment +
                ']';
    }

    @Override
    public int compareTo(Employee o) {
        return Comparator.comparing(Employee::getName)
                .thenComparing(Employee::getExperience)
                .thenComparing(Employee::getPayment)
                .compare(this, o);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + getName().hashCode() + getExperience() + getPayment().hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (getName() != other.getName())
            return false;
        if (getExperience() != other.getExperience())
            return false;
        if (getPayment().compareTo(other.getPayment()) != 0) {
            return false;
        }
        return true;
    }
}
