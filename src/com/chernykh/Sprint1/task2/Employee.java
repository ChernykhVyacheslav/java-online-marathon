package com.chernykh.Sprint1.task2;

public class Employee {

    public String fullName;
    public float salary;

    public static void main(String[] args) {
        Employee emp1 = new Employee();
        Employee emp2 = new Employee();

        emp1.fullName = "Employee1";
        emp1.salary = 999.99f;

        emp2.fullName = "Employee2";
        emp2.salary = 1002.0f;

        Employee[] employees = {emp1, emp2};

        String employeesInfo = "[";

        for(Employee tempEmployee : employees) {
            employeesInfo += String.format("{fullName: \"%s\", salary: %s}",
                    tempEmployee.fullName, Float.toString(tempEmployee.salary));
        }

        employeesInfo = employeesInfo.replace("}{", "}, {").concat("]");

        System.out.println(employeesInfo);
    }

}
