package lec_15.homework.task_03;

/*
 * Есть две HashMap<String, List<Integer>>, нужно сделать из них одну (смержить)
 */

import java.util.*;

public class Task_03 {
    public static void main(String[] args) {
        HashMap<String, List<Integer>> firstMap = new HashMap<>();
        HashMap<String, List<Integer>> secondMap = new HashMap<>();

        for (int i = 1; i < 10; i++) {
            List<Integer> tempList = new ArrayList<>();
            for (int j = 1; j < 10; j++) {
                tempList.add(i*j);
            }

            firstMap.put("key_"+i, tempList);
        }

        System.out.println("firstMap = " + firstMap);

        for (int i = 1; i < 10; i++) {
            List<Integer> tempList = new ArrayList<>();
            for (int j = 1; j < 10; j++) {
                tempList.add(i*j*10);
            }

            secondMap.put("key_"+i, tempList);
        }

        System.out.println("secondMap = " + secondMap);

        secondMap.forEach(
                (key, value) -> firstMap.merge(key, value, (v1, v2) -> {
                    List<Integer> merged = new ArrayList<>(v1);
                    merged.addAll(v2);
                    return merged;
                }));

        System.out.println("resultMap = " + firstMap);
    }
}
