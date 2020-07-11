package com.chernykh.sprint02.task3;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();

        people.add(new Person("Ivan"));
        people.add(new Student("Petro", "University", 3));
        people.add(new Worker("Andriy", "Developer", 12));
        people.add(new Worker("Andriy", "Developer", 12));
        people.add(new Student("Stepan", "College", 4));
        people.add(new Worker("Ira", "Manager", 8));
        people.add(new Student("Ihor", "University", 4));
        people.add(new Student("Ihor", "University", 4));
        Worker worker = new Worker("Ira", "Manager", 12);
//        people.add(worker);
//        people.add(worker);
//        for (Person person:
//                people) {
//            System.out.println(person);
//        }
//
        System.out.println(people);
        System.out.println("--------------------------");
        System.out.println(new MyUtils().maxDuration(people));
//
//        List<Person> mostExperiencedPeople = new MyUtils().maxDuration(people);
//
//        for (Person person:
//             mostExperiencedPeople) {
//            System.out.println(person);
//        }

        MyUtils myUtils = new MyUtils();
//        ArrayList<Person> personArrayList = new ArrayList<>();
//        System.out.println(myUtils.maxDuration(personArrayList));
//        people.add(new Student("Ihor", "University", 4));
//        people.add(null);
//        people.add(new Student("Ihor2", "University", 4));
//        people.add(null);
//        people.add(new Student("Ihor", "Universitye", 4));
//        people.add(null);
//        people.add(new Student("Ihor", "University", 3));
//        people.add(null);
//        System.out.println(myUtils.maxDuration(people));

        System.out.println("[Worker [name=Andriy, workPosition=Developer, experienceYears=12], Student [name=Stepan, studyPlace=College, studyYears=4], Student [name=Ihor, studyPlace=University, studyYears=4]]");
    }
}
