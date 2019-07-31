package lec_14.homework.task_02;

/*
*коллекция строк
* найти строку с максимальной длиной
 */

import java.util.*;

public class Task_02 {
    public static void main(String[] args) {
        List<String> ListOfStringsTask2 = new ArrayList<>();

        ListOfStringsTask2.add("First");
        ListOfStringsTask2.add("Second");
        ListOfStringsTask2.add("Else");
        ListOfStringsTask2.add("Sml");
        ListOfStringsTask2.add("one");
        ListOfStringsTask2.add("Long");

        Comparator<String> byLength = (x, y) -> Integer.valueOf(x.length()).compareTo(y.length());
        Comparator<String> byCase = Comparator.comparing(String::toLowerCase);

        Optional<String> finishString = ListOfStringsTask2.stream()
                .max(byLength.thenComparing(byCase));

        if (finishString.isPresent()) {
            System.out.println("finishString = " + finishString.get());
        }
    }
}
