package lec_14.homework.task_01;

/*
 * Task 1. (filter)
 * Есть коллекция строк, нужно убрать все элементы, длина которых меньше 5 символов
 */

import java.util.*;
import java.util.stream.*;

public class Task_01 {
    public static void main(String[] args) {
        List<String> ListOfStringsTask1 = new ArrayList<>();

        ListOfStringsTask1.add("First");
        ListOfStringsTask1.add("Second");
        ListOfStringsTask1.add("Else");
        ListOfStringsTask1.add("Sml");
        ListOfStringsTask1.add("one");
        ListOfStringsTask1.add("Long");

        List<String> finishCollect = ListOfStringsTask1.stream()
                .filter(stringElement -> stringElement.length() >= 5)
                .collect(Collectors.toList());

        System.out.println("finishCollect = " + finishCollect);

    }
}
