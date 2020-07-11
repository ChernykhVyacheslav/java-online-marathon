package com.chernykh.sprint06.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class App {

    static BinaryOperator<String> greetingOperator = ((parameter1, parameter2) -> {
        return "Hello " + parameter1 + " " + parameter2 + "!!!";
    });

    public static List<String> createGreetings(List<Person> people, BinaryOperator<String> binaryOperator) {
        List<String> greetingsList = new ArrayList<>();
        for (Person person :
                people) {
            greetingsList.add(binaryOperator.apply(person.name, person.surname));
        }
        return greetingsList;
    }

}
