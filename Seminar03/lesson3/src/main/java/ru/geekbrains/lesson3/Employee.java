package ru.geekbrains.lesson3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Employee  {

    //region Public Methods

    /**
     * Расчет среднемесячной заработной платы
     * @return
     */
    public abstract double calculateSalary();

    /**
     * Вся информация о зарплате сотрудника
     * @return
     */
    public abstract String viewSalaryInfo();

    @Override
    public String toString() {
        return String.format("%d; %s %s; Возраст: %d; %s; %s",
                id, surName, name, age, position, viewSalaryInfo());
    }

    //endregion

    //region Constructors And Initializers

    {
        id = ++counter;
    }

    private Employee(){
        this("#Surnane#", "#Name#");
    }

    private Employee(String surName, String name){
        this(surName, name, 500);
    }

    private Employee(String surName, String name, double salary){
        if (salary < 500){
            throw new RuntimeException("Ставка заработной платы должна быть не менее 500");
        }
        this.surName = surName;
        this.name = name;
        this.salary = salary;
    }

    private Employee(String surName, String name, int age, double salary){
        this(surName, name, salary);
        if (age < 18){
            throw new RuntimeException("Детский труд в стране запрешён!");
        } else if (age > 90) {
            throw new RuntimeException("Дай деду пожить перед смертью!");
        }
        this.age = age;
    }

    protected Employee(String surName, String name, int age, int posID, String position, double salary) {
        this(surName, name, age, salary);
        this.posID = posID;
        this.position = position;
    }

    //endregion

    //region Getters and Setters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public int getPosID() {
        return posID;
    }

    public void setSalary(double salary) {
        if (salary < 30000){
            throw new RuntimeException("Уровень заработной платы должен быть не менее 30000");
        }
        this.salary = salary;
    }

    //endregion

    //region Fields

    protected int id;

    /**
     * Имя
     */
    protected String name;

    /**
     * Фамилия
     */
    protected String surName;

    /**
     * Ставка заработной платы
     */
    protected double salary;

    /**
     * Возраст
     */
    protected int age;

    /**
     * Должность
     */
    protected String position;

    /**
     * ID должности
     */
    protected int posID;


    //endregion

    //region Static Fields

    protected static String[] names = new String[] { "Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман" };
    protected static String[] surNames = new String[] { "Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов" };
    protected static Random random = new Random();
    private static int counter = 1000;


    //endregion

}
