package ru.geekbrains.lesson5;

import java.io.File;
import java.io.IOException;

public class Tree {

    public static void main(String[] args) throws IOException {
        print(new File("."), "");
    }

    /**
     * Рисует в консоли корень поиска
     * @param file
     * @param indent
     */
    public static void print(File file, String indent)
            throws IOException {
        String[] pathDirs = file.getCanonicalPath()
                .replace("\\", "/").split("/");
        System.out.println("\u001B[31m" + pathDirs[pathDirs.length - 1] + "\u001B[0m");

        root(file, indent);
    }

    /**
     * Рисует в консоли дерево файлов и папок относительно указанной директории
     *
     * @param file
     * @param indent
     * @param isLast
     */
    public static void print(File file, String indent, boolean isLast) throws IOException {
        System.out.print(indent);
        if (isLast) {
            System.out.print("└─");
            indent += "  ";
        } else {
            System.out.print("├─");
            indent += "│ ";
        }

        if (file.isDirectory())
            System.out.println("\u001B[32m" + file.getName() + "\u001B[0m");
        else
            System.out.println("\u001B[34m" + file.getName() + "\u001B[0m");

        root(file, indent);
    }

    /**
     * Анализ файловой системы в рамках директории
     * @param file
     * @param indent
     * @throws IOException
     */
    private static void root(File file, String indent) throws IOException {
        File[] files = file.listFiles();
        if (files == null)
            return;

        for (int i = 0; i < files.length - 1; i++) {
            print(files[i], indent, false);
        }
        if (files.length > 0)
            print(files[files.length - 1], indent, true);
    }

}
