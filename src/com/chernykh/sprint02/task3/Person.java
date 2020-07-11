package com.chernykh.sprint02.task3;

import java.util.Comparator;
import java.util.Objects;

public class Person implements Comparable<Person> {

    private String name;

    public String getName() {
        return name;
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person [" +
                "name=" + name +
                ']';
    }


    @Override
    public int compareTo(Person o) {
        return Comparator.comparing(Person::getName)
                .compare(this, o);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + getName().hashCode();
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
        Person other = (Person) obj;
        return Objects.equals(getName(), other.getName());
    }
}
