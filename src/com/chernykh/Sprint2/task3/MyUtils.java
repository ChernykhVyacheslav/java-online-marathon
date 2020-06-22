package com.chernykh.Sprint2.task3;

import java.util.*;
import java.util.stream.Collectors;

public class MyUtils {

    public List<Person> maxDuration(List<Person> people) {
        List<Person> mostExperiencedWorkersAndStudents = new ArrayList<>();
        if (people == null || people.isEmpty()) {
            return mostExperiencedWorkersAndStudents;
        }
        List<Person> mostExperiencedWorkers = getMostExperiencedWorkers(people);
        if (mostExperiencedWorkers != null && !mostExperiencedWorkers.isEmpty()) {
            mostExperiencedWorkersAndStudents.addAll(mostExperiencedWorkers);
        }
        List<Person> mostExperiencedStudents = getMostExperiencedStudents(people);
        if (mostExperiencedStudents != null && !mostExperiencedStudents.isEmpty()) {
            mostExperiencedWorkersAndStudents.addAll(mostExperiencedStudents);
        }
        return mostExperiencedWorkersAndStudents;
    }

    private List<Person> getMostExperiencedWorkers(List<Person> persons) {
        List<Worker> workers = new ArrayList<>();
        for (Person person : persons) {
            if (person instanceof Worker) {
                workers.add((Worker) person);
            }
        }

        if (workers.isEmpty()) {
            return null;
        }

        int maxExperience = Collections.max(workers, new WorkersComparator()).getExperienceYears();

        return workers.stream().distinct().filter(
                p -> p.getExperienceYears() == maxExperience
        ).collect(Collectors.toList());
    }

    private List<Person> getMostExperiencedStudents(List<Person> persons) {
        List<Student> students = new ArrayList<>();
        for (Person person : persons) {
            if (person instanceof Student) {
                students.add((Student) person);
            }
        }

        if (students.isEmpty()) {
            return null;
        }

        int maxYears = Collections.max(students, new StudentsComparator()).getStudyYears();

        return students.stream().distinct().filter(
                p -> p.getStudyYears() == maxYears
        ).collect(Collectors.toList());
    }

    class WorkersComparator implements Comparator<Worker> {
        public int compare(Worker w1, Worker w2) {
            if (w1.getExperienceYears() < w2.getExperienceYears()) return -1;
            if (w1.getExperienceYears() > w2.getExperienceYears()) return 1;
            else return 0;
        }
    }

    class StudentsComparator implements Comparator<Student> {
        public int compare(Student s1, Student s2) {
            if (s1.getStudyYears() < s2.getStudyYears()) return -1;
            if (s1.getStudyYears() > s2.getStudyYears()) return 1;
            else return 0;
        }
    }
}
