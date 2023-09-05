package ru.geekbrains.lesson3;

import ru.geekbrains.lesson3.Comparators.EmployeeAgeComparator;
import ru.geekbrains.lesson3.Comparators.EmployeeNameComparator;
import ru.geekbrains.lesson3.Comparators.EmployeePositionComparator;
import ru.geekbrains.lesson3.Comparators.EmployeeSalaryComparator;

import java.util.*;

public class Company implements Iterable<Employee>{
    //region fields
    private List<Employee> employees;
    private Scanner scanner;
    private Random random;
    //endregion

    public Company() {
        this.employees = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.random = new Random();
    }

    //region adders

    /**
     * Добавляет работяг
     * @param count количество работяг
     */
    public void addWorkers(int count){
        employees.addAll(Worker.getEmployees(count));
    }

    /**
     * Добавляет фрилансеров
     * @param count количество фрилансеров
     */
    public void addFreelancers(int count){
        employees.addAll(Freelancer.getEmployees(count));
    }

    /**
     * Добавляет рандомных служащих
     * @param count количество душ
     */
    public void addRandomEmployees(int count){
        for (int i = 0; i < count; i++) {
            if (random.nextBoolean())
                employees.add(Worker.getInstance());
            else
                employees.add(Freelancer.getInstance());
        }
    }
    //endregion

    //region methods

    /**
     * Распечатать список служащих
     */
    public void print() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println();
    }

    /**
     * Отсортировать служащих
     */
    public void sortEmployee() {
        menu();
        int choice = enter();
        while (choice > 4 || choice < 1){
            System.out.println("Некорректный ввод");
            choice = enter();
        }
        switch (choice){
            case 1 -> Collections.sort(employees, new EmployeeSalaryComparator());
            case 2 -> Collections.sort(employees, new EmployeeNameComparator());
            case 3 -> Collections.sort(employees, new EmployeeAgeComparator());
            case 4 -> Collections.sort(employees, new EmployeePositionComparator());
        }
    }

    /**
     * Меню сортировки
     */
    private void menu(){
        System.out.print("Выберите тип сортировки:\n" +
                "1 - по зарплате\n" +
                "2 - по ФИО сотрудника\n" +
                "3 - по возрасту\n" +
                "4 - по должности\n>>> ");
    }

    /**
     * Ввод значения для выбора сортировки
     * @return
     */
    private int enter(){
        int num;
        while (true) {
            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out.println("Ошибка ввода");
                scanner.nextLine();
            }
        }
        return num;
    }

    @Override
    public Iterator<Employee> iterator() {
        return new Iterator<Employee>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < employees.size();
            }

            @Override
            public Employee next() {
                return employees.get(index++);
            }
        };
    }
    //endregion
}
