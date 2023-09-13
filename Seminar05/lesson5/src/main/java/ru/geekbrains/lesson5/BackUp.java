package ru.geekbrains.lesson5;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BackUp {
    public static void main(String[] args) throws IOException {
        File copy = new File(".");
        File paste = new File("./../backup");
        Files.createDirectories(Paths.get("./../backup"));
        backUp(copy, paste);
    }

    public static void backUp(File copy, File paste) throws IOException {
        String rootWay = paste.getAbsolutePath() + "/" + getName(copy);
        Files.createDirectories(Paths.get(rootWay));
        analysis(copy, rootWay);
    }

    private static void backUp(File file, String rootWay) throws IOException {
        rootWay += "/" + getName(file);
        if (file.isDirectory()){
            Files.createDirectories(Paths.get(rootWay));
            analysis(file, rootWay);
        } else {
            Files.createFile(Paths.get(rootWay));
            copy(file, rootWay);
        }
    }

    private static void analysis(File file, String rootWay) throws IOException {
        File[] files = file.listFiles();
        if (files == null)
            return;

        if (files.length > 0) {
            for (int i = 0; i < files.length; i++) {
                backUp(files[i], rootWay);
            }
        }
    }

    private static String getName(File file) throws IOException {
        String[] way = file.getCanonicalPath()
                .replace("\\", "/").split("/");
        return way[way.length - 1];
    }

    private static void copy(File file, String rootWay) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file.getAbsolutePath())) {
            int c;
            try (FileInputStream fileInputStream = new FileInputStream(rootWay)) {
                while ((c = fileInputStream.read()) != -1)
                    fileOutputStream.write(c);
            }
        }
    }
}
