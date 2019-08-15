package lec_17_2.homework.task_02;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class Task_02 {
    private static final int FILL_LIMIT = 100;

    public static void main(String[] args) {
        List<Integer> listForFilling = new ArrayList<>();

       // ты мог просто переиспользовать класс из предыдущей задачи. Так было бы лучше + у тебя в этом же пакете еще один класс
        fillIntList(listForFilling);

        //mapToInt(Integer::intValue)
        OptionalDouble average = listForFilling.stream().mapToInt(e -> e).average();

        System.out.println("average = " + average.getAsDouble());
    }

    private static void fillIntList(List<Integer> listForFilling) {
        ReentrantlockListFiller listFiller = new ReentrantlockListFiller(listForFilling, FILL_LIMIT);

        Runnable runnable = () -> {
            for (int i = 0; i < FILL_LIMIT; i++) {
                listFiller.fillList();
            }
        };

        Thread listFillerThread = new Thread(runnable);
        listFillerThread.start();
        try {
            listFillerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
