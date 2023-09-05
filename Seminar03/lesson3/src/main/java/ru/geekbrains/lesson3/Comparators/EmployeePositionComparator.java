package ru.geekbrains.lesson3.Comparators;

import ru.geekbrains.lesson3.Employee;

import java.util.Comparator;

public class EmployeePositionComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return Integer.compare(o1.getPosID(), o2.getPosID());
    }
}
