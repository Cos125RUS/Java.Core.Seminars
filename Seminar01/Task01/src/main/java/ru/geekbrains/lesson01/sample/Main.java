package ru.geekbrains.lesson01.sample;

import ru.geekbrains.lesson01.regular.Decorator;
import ru.geekbrains.lesson01.regular.OtherClass;

/**
 * Entry point
 */
public class Main {
    /**
     * Do methods
     */
    public static void main(String[] args) {
        int sum = OtherClass.sum(2,2);
        System.out.println(Decorator.decorate(sum));
        int div = OtherClass.div(2,2);
        System.out.println(Decorator.decorate(div));
        int mul = OtherClass.mul(2,2);
        System.out.println(Decorator.decorate(mul));
        int sub = OtherClass.sub(2,2);
        System.out.println(Decorator.decorate(sub));
    }
}