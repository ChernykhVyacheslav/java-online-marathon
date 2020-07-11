package com.chernykh.sprint02.task3;

import java.util.Comparator;
import java.util.Objects;

public class Worker extends Person implements Comparable<Person> {

    private String workPosition;
    private int experienceYears;

    public Worker(String name, String workPosition, int experienceYears) {
        super(name);
        this.workPosition = workPosition;
        this.experienceYears = experienceYears;
    }

    public String getWorkPosition() {
        return workPosition;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    @Override
    public String toString() {
        return "Worker [" +
                "name=" + getName() +
                ", workPosition=" + workPosition +
                ", experienceYears=" + experienceYears +
                ']';
    }

    public int compareTo(Worker o) {
        return Comparator.comparing(Worker::getName)
                .thenComparing(Worker::getWorkPosition)
                .thenComparing(Worker::getExperienceYears)
                .compare(this, o);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + getWorkPosition().hashCode() - getName().hashCode() + getExperienceYears();
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
        Worker other = (Worker) obj;
        if (!getName().equals(other.getName()))
            return false;
        if (getExperienceYears() != other.getExperienceYears())
            return false;
        return Objects.equals(getWorkPosition(), other.getWorkPosition());
    }
}
