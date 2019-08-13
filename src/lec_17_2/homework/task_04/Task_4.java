package lec_17_2.homework.task_04;

/*
 * Task 4
 * Написать программу, которая получает аргументом программы пути к файлам. Программа должна посчитать кол-во слов в каждом файле по отдельности,
 * затем общее кол-во файлов и вывести на экран.
 * На каждый файл используйте отдельный поток для вычислений.
 */

import java.io.*;
import java.util.ArrayList;

public class Task_4 {
    private static final String FILE_WITH_WORKING_PATHS = "./src/lec_17_2/homework/task_4/working_paths.txt";
    private static ArrayList<String> workingFilePaths = new ArrayList<>();
    private static int numberOfFiles;

    public static void main(String[] args) {
        extractFilePaths();

        for (String workingDirectoryPath : workingFilePaths) {
            File workingDirectory = new File(workingDirectoryPath);
            File[] listOfFilesForAnalysis = workingDirectory.listFiles((dir, name) -> (name.toLowerCase().endsWith(".txt")));
            numberOfFiles += listOfFilesForAnalysis.length;

            for (File fileForAnalysis : listOfFilesForAnalysis) {
                FileAnalyzer fileAnalyzer = new FileAnalyzer(fileForAnalysis);
                Thread thread = new Thread(fileAnalyzer);
                thread.start();
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.printf("Number of words in file \"%s\" is %d\n", fileForAnalysis.getName(), fileAnalyzer.getNumberOfWords());
            }
        }

        System.out.printf("\nNumber of files for analysis is %d\n", numberOfFiles);
    }

    private static void extractFilePaths() {
        try (FileReader fileReader = new FileReader(FILE_WITH_WORKING_PATHS);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String readingLine;

            while ((readingLine = bufferedReader.readLine()) != null) {
                workingFilePaths.add(readingLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
