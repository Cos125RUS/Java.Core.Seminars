package ru.geekbrains.lesson3;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Доработать в рамках домашней работы
 */
public class Freelancer extends Employee {

    private Freelancer(String surName, String name, int age, double salary){
        super(surName, name, age, 2, "Фрилансер", salary);
    }

    public static Employee getInstance(){
        return new Freelancer(
                surNames[random.nextInt(surNames.length)],
                names[random.nextInt(surNames.length)],
                random.nextInt(18,90),
                random.nextInt(5, 50) * 100);
    }

    public static List<Employee> getEmployees(int count){
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < count; i++)
            employees.add(getInstance());
        return employees;
    }

    @Override
    public double calculateSalary() {
        return 20.8 * 8 * salary;
    }

    @Override
    public String viewSalaryInfo() {
        return String.format("Зарплата (почасовая оплата): %.2f руб./мес. (%.0f руб./час)",
                calculateSalary(), salary);
    }

}
