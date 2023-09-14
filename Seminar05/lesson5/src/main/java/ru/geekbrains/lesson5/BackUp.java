package ru.geekbrains.lesson5;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Класс для создания BackUp-ов
 */
public class BackUp {
    public static void main(String[] args) throws IOException {
        File copy = new File(".");
        File paste = new File("./../backup");

        backUp(copy, paste);
    }

    /**
     * Подготавливает новую директорию для BackUp-а, запускает обход
     * @param copy
     * @param paste
     * @throws IOException
     */
    public static void backUp(File copy, File paste) throws IOException {
        Files.createDirectories(Paths.get(paste.getAbsolutePath()));
        String rootPath = paste.getAbsolutePath() + "/" + getName(copy);
        Files.createDirectories(Paths.get(rootPath));
        analysis(copy, rootPath);
    }

    /**
     * Создаёт новые директории в папке BackUp-а или запускает копирование файла
     * @param file
     * @param rootPath
     * @throws IOException
     */
    private static void backUp(File file, String rootPath) throws IOException {
        rootPath += "/" + file.getName();
        Path path= Paths.get(rootPath);
        if (file.isDirectory()){
            Files.createDirectories(path);
            analysis(file, rootPath);
        } else {
            if (path.toFile().exists())
                path.toFile().delete();
            Files.createFile(path);
            copy(file, rootPath);
        }
    }

    /**
     * Проверяет является ли файл директорией и запускает новый уровень рекурсии
     * @param file
     * @param rootPath
     * @throws IOException
     */
    private static void analysis(File file, String rootPath) throws IOException {
        File[] files = file.listFiles();
        if (files == null)
            return;

        if (files.length > 0) {
            for (int i = 0; i < files.length; i++) {
                backUp(files[i], rootPath);
            }
        }
    }

    /**
     * Возвращает корректное имя корневой директории
     * @param file
     * @return
     * @throws IOException
     */
    private static String getName(File file) throws IOException {
        return (new File(file.getCanonicalPath())).getName();
    }

    /**
     * Копирование файлов
     * @param file
     * @param path
     * @throws IOException
     */
    public static void copy(File file, String path) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(path)) {
            int c;
            try (FileInputStream fileInputStream = new FileInputStream(file)) {
                while ((c = fileInputStream.read()) != -1)
                    fileOutputStream.write(c);
            }
        }
    }
}
