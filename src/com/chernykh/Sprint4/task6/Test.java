package com.chernykh.Sprint4.task6;

public class Test {

    public static void main(String[] args) {
        Person[] people = new Person[]{new Person("Ivan", 17), new Person("Ivan", 20), new Person("Inna", 19),
                new Employee("Vasiliy", 18, 2000), new Employee("Alexiy", 23, 1500)};

        Developer[] developers = new Developer[]{
                new Developer("Ivan", 18, 2500, Level.SENIOR),
                new Developer("Ivan", 18, 2500, Level.MIDDLE), new Developer("Ivan", 18, 2500, Level.JUNIOR),
                new Developer("Ivan", 19, 2500, Level.JUNIOR), new Developer("Ivan", 18, 2700, Level.JUNIOR)
        };
        for (Person p :
                developers) {
            System.out.print(p + ", ");
        }
        Utility.sortPeople(developers, new DeveloperComparator());
        System.out.println("------------------------------------------------------");
        for (Person p :
                developers) {
            System.out.print(p + ", ");
        }
        Double d;
    }
}
