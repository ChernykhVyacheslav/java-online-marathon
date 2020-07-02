package com.chernykh.sprint4.task6;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        int i = p1.getName().compareTo(p2.getName());
        if (i != 0) {
            return i;
        }

        return Integer.compare(p1.getAge(), p2.getAge());
    }
}
