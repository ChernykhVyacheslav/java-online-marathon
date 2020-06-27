package com.chernykh.Sprint4.task6.Alternative;

import com.chernykh.Sprint4.task6.Person;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {

    static Comparator<Person> COMPARATOR = Comparator.comparing(Person::getName)
            .thenComparing(Person::getAge);

    @Override
    public int compare(Person o1, Person o2) {
        return COMPARATOR.compare(o1, o2);
    }
}
