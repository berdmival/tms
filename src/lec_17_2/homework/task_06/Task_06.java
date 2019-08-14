package lec_17_2.homework.task_06;

/*
 * Task 6
 * Написать программу, которая первым аргументом получает путь к папке, в которой создает 3 подпапки с именами "1", "2", "3"
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task_06 {
    public static void main(String[] args) {
        String currentDirectory = args[0];

        try {
            Files.createDirectory(Paths.get(currentDirectory + "./1"));
            Files.createDirectory(Paths.get(currentDirectory + "./2"));
            Files.createDirectory(Paths.get(currentDirectory + "./3"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
