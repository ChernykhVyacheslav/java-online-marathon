package com.chernykh.Sprint4.task2;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Student> list1 = new ArrayList<>() {{
            add(new Student(1, "Ivan"));
            add(new Student(2, "Petro"));
            add(new Student(3, "Stepan"));
        }};
        System.out.println(list1);

        List<Student> list2 = new ArrayList<>() {{
            add(new Student(1, "Ivan"));
            add(new Student(3, "Stepan"));
            add(new Student(4, "Andriy"));
        }};
        System.out.println(list2);

        System.out.println(new MyUtils().commonStudents(list1, list2));

    }
}
