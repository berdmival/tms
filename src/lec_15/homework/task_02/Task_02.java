package lec_15.homework.task_02;

/*
 * Есть текстовый файл. Нужно скопировать из него только те строки, которые содержат слово pancakes и записать их в другой файл
 */

import java.io.*;

public class Task_02 {
    private static final String READ_FILE_PATH = "./src/lec_15/homework/task_02/test_read.txt";
    private static final String WRITE_FILE_PATH = "./src/lec_15/homework/task_02/test_write.txt";
    private static final String TEST_PHRASE = "pancakes";

    public static void main(String[] args) {
        try (FileReader inputFile = new FileReader(READ_FILE_PATH);
             BufferedReader inputFileBuffer = new BufferedReader(inputFile);
             FileWriter outputFile = new FileWriter(WRITE_FILE_PATH);
             BufferedWriter outputFileBuffer = new BufferedWriter(outputFile)) {
            String readingLine;

            while ((readingLine = inputFileBuffer.readLine()) != null) {
                if (readingLine.contains(TEST_PHRASE)) {
                    outputFileBuffer.write(readingLine);
                    outputFileBuffer.write("\n");
                    outputFileBuffer.flush();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Work with files completed!");
    }
}
