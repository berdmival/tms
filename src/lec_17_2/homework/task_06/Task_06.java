package lec_17_2.homework.task_06;

/*
 * Task 6
 * Написать программу, которая первым аргументом получает путь к папке, в которой создает 3 подпапки с именами "1", "2", "3"
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task_06 {
    private static final int NUMBER_OF_CREATED_FOLDERS = 3;

    public static void main(String[] args) {
        String currentDirectory;
        if (args.length > 0) {
            currentDirectory = args[0];

            try {
                for (int i = 1; i <= NUMBER_OF_CREATED_FOLDERS; i++) {
                    if (Files.notExists(Paths.get(currentDirectory + "/" + i))) {
                        Files.createDirectory(Paths.get(currentDirectory + "/" + i));
                        System.out.printf("Directory \"%s\" created\n", currentDirectory + "/" + i);
                    } else {
                        System.out.printf("Directory \"%s\" is already exists\n", currentDirectory + "/" + i);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Enter parent folder in program start arguments");
        }
    }
}
