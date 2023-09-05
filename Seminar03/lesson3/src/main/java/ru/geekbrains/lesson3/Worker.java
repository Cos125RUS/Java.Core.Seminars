package ru.geekbrains.lesson3;

import java.util.ArrayList;
import java.util.List;

public class Worker extends Employee{

    private Worker(String surName, String name, int age, double salary){
        super(surName, name, age, 1, "Работяга", salary);
    }

    public static Employee getInstance(){
        return new Worker(
                surNames[random.nextInt(surNames.length)],
                names[random.nextInt(surNames.length)],
                random.nextInt(18,90),
                random.nextInt(30, 250) * 1000);
    }

    public static List<Employee> getEmployees(int count){
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < count; i++)
            employees.add(getInstance());
        return employees;
    }

    @Override
    public double calculateSalary() {
        return salary;
    }

    @Override
    public String viewSalaryInfo() {
        return String.format("Зарплата (фиксированная месячная оплата): %.2f руб./мес.", salary);
    }

}
