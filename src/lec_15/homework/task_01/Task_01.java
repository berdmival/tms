package lec_15.homework.task_01;

/*
 * Форматирование строк. Подставить в прредложение имя и язык программирования
 * строка "Hello, my name is [name]. I'm [language] developer and I'm glad to become a part of your company."
 */

import java.util.Scanner;

public class Task_01 {
    private static final String MESSAGE = "Hello, my name is %s. I'm %s developer and I'm glad to become a part of your company.";

    public static void main(String[] args) {
        Scanner inputSourse = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String userName = inputSourse.next();

        System.out.print("Enter your programming language: ");
        String userProgramLanguage = inputSourse.next();
        System.out.println("Your message is: ");

        String massageString = String.format(MESSAGE, userName, userProgramLanguage);
        System.out.println(massageString);
    }
}
