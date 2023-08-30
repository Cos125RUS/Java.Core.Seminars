package ru.geekbrains.lesson01.regular;

/**
 * Decoration exit text
 */
public class Decorator {
    /**
     * Decoration func
     * @param a num
     * @return exit text
     */
    public static String decorate(int a){
        return String.format("Your num: %d", a);
    }
}
