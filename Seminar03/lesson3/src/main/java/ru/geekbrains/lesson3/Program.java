package ru.geekbrains.lesson3;

public class Program {

    public static void main(String[] args) {

        Company company = new Company();
        company.addRandomEmployees(20);
        company.print();
        company.sortEmployee();
//        company.print();
        for (Employee e: company) {
            System.out.println(e);
        }
    }
}
