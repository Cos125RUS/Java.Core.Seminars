package ru.geekbrains.lesson3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.addAll(Worker.getEmployees(15));
//        employees.addAll(Freelancer.getEmployees(15));
        print (employees);

        Collections.sort(employees, new EmployeeNameComparator());
        print (employees);

    }

    public static void print (List<Employee> employees) {
        for (Employee employee: employees) {
            System.out.println(employee);
        }
        System.out.println();
    }

}
