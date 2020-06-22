package com.chernykh.Sprint4.task2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyUtils {

    public Set<Student> commonStudents(List<Student> list1, List<Student> list2) {
        Set<Student> students = new HashSet<>();

        for (Student studentOfList1 :
                list1) {
            for (Student studentOfList2 :
                    list2) {
                if (studentOfList1.equals(studentOfList2)) {
                    students.add(studentOfList1);
                }
            }
        }
        return students;
    }
}
