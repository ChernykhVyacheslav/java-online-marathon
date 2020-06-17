package com.chernykh.Sprint2.task3;

import java.util.Comparator;
import java.util.Objects;

public class Student extends Person implements Comparable<Person> {

    private String studyPlace;
    private int studyYears;

    public Student(String name, String studyPlace, int studyYears) {
        super(name);
        this.studyPlace = studyPlace;
        this.studyYears = studyYears;
    }

    public String getStudyPlace() {
        return studyPlace;
    }

    public int getStudyYears() {
        return studyYears;
    }

    @Override
    public String toString() {
        return "Student [" +
                "name=" + getName() +
                ", studyPlace=" + studyPlace +
                ", studyYears=" + studyYears +
                ']';
    }

    public int compareTo(Student o) {
        return Comparator.comparing(Student::getName)
                .thenComparing(Student::getStudyPlace)
                .thenComparing(Student::getStudyYears)
                .compare(this, o);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + getStudyPlace().hashCode() - getName().hashCode() + getStudyYears();
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
        Student other = (Student) obj;
        if (!Objects.equals(getName(), other.getName()))
            return false;
        if (getStudyYears() != other.getStudyYears())
            return false;
        return Objects.equals(getStudyPlace(), other.getStudyPlace());
    }
}
