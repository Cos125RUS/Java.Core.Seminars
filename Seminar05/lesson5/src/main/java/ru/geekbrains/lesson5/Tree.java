package ru.geekbrains.lesson5;

import java.io.File;

public class Tree {

    public static void main(String[] args) {

        print(new File("."), "", true, true);

    }

    /**
     * TODO: Доработать метод print, необходимо распечатывать директории и файлы
     *
     * @param file
     * @param indent
     * @param isLast
     */
    public static void print(File file, String indent, boolean isLast, boolean isFirst) {
        if (isFirst) {
            String[] pathDirs = file.getAbsolutePath()
                    .replace("\\", "/").split("/");
            System.out.println("\u001B[31m" + pathDirs[pathDirs.length-2] + "\u001B[0m");
        } else {
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
        }

        File[] files = file.listFiles();
        if (files == null)
            return;

        for (int i = 0; i < files.length - 1; i++) {
            print(files[i], indent, false, false);
        }
        if (files.length > 0)
            print(files[files.length - 1], indent, true, false);

//        int subTotal = 0;
//        for (int i = 0; i < files.length; i++) {
//            if (files[i].isDirectory())
//                subTotal++;
//        }
//
//        int subDirCounter = 0;
//        for (int i = 0; i < files.length; i++) {
//            if (files[i].isDirectory()) {
//                subDirCounter++;
//                print(files[i], indent, subDirCounter == subTotal, false);
//            }
//        }

    }

}
