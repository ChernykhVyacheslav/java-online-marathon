package com.chernykh.sprint02.task4;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Objects;

public class Manager extends Employee implements Comparable<Employee> {

    private double coefficient;

    public Manager(String name, int experience, BigDecimal basePayment, double coefficient) {
        super(name, experience, basePayment);
        this.coefficient = coefficient;
    }

    public double getCoefficient() {
        return coefficient;
    }

    @Override
    public BigDecimal getPayment() {
        return super.getPayment().multiply(BigDecimal.valueOf(coefficient));
    }

    @Override
    public String toString() {
        return "Manager [" +
                "name=" + getName() +
                ", experience=" + getExperience() +
                ", basePayment=" + super.getPayment() +
                ", coefficient=" + getCoefficient() +
                ']';
    }


    public int compareTo(Manager o) {
        return Comparator.comparing(Manager::getName)
                .thenComparing(Manager::getExperience)
                .thenComparing(Employee::getPayment)
                .thenComparing(Manager::getCoefficient)
                .compare(this, o);
    }

    @Override
    public int hashCode() {
        final int prime = 17;
        int result = 1;
        result = prime * result + getName().hashCode() + getExperience() +
                getPayment().hashCode() + Double.hashCode(getCoefficient());
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
        Manager other = (Manager) obj;
        if (!Objects.equals(getName(), other.getName()))
            return false;
        if (getExperience() != other.getExperience())
            return false;
        if (getPayment().divide(BigDecimal.valueOf(getCoefficient())).compareTo(
                other.getPayment().divide(BigDecimal.valueOf(other.getCoefficient()))) != 0) {
            return false;
        }
        return Double.compare(getCoefficient(), other.getCoefficient()) == 0;
    }
}
