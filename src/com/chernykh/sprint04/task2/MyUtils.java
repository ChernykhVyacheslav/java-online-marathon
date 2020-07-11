package com.chernykh.sprint04.task2;

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


    public Set<Student> commonStudents2(List<Student> list1, List<Student> list2) {
        Set<Student> students = new HashSet<>(list1);

        Set<Student> sub1 = new HashSet<>(list1);
        sub1.removeAll(list2);
        Set<Student> sub2 = new HashSet<>(list2);
        sub2.removeAll(list1);

        students.removeAll(sub1);
        students.removeAll(sub2);

        return students;
    }

    public Set<Student> commonStudents3(List<Student> list1, List<Student> list2) {
        Set<Student> students = new HashSet<>(list1);

        students.retainAll(list2);

        return students;
    }
}
