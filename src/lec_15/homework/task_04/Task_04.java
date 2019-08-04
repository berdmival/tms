package lec_15.homework.task_04;

/*
 * Написать StringUtils класс который умеет искать в тексте слова-полиндромы.
 * Результат работы программы - вывод на консоль всех полиндромов из текста.
 * Учесть что в тексте могут быть запятые,точки, вопросительные и восклицательные знаки.
 * Пример строка: камень, бакаб и пороороп! На экран должен быть вывод двух последних слов
 */

import java.io.*;

public class Task_04 {
    private static final String SOURCE_TEXT_FILE = "./src/lec_15/homework/task_04/source_text.txt";

    public static void main(String[] args) {
        try (FileReader inputFile = new FileReader(SOURCE_TEXT_FILE);
             BufferedReader inputFileBuffer = new BufferedReader(inputFile)) {

            String readingLine;

            while ((readingLine = inputFileBuffer.readLine()) != null) {
                StringUtils.showPalindroms(readingLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
