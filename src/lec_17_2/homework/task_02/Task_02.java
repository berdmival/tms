package lec_17_2.homework.task_02;

import lec_17_2.homework.task_01.ReentrantlockListFiller;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Random;

public class Task_02 {
    private static final int FILL_LIMIT = 100;

    public static void main(String[] args) {
        List<Integer> listForFilling = new ArrayList<>();

        fillIntList(listForFilling);

        OptionalDouble average = listForFilling.stream().mapToInt(Integer::intValue).average();

        System.out.println("average = " + average.getAsDouble());
    }

    private static void fillIntList(List<Integer> listForFilling) {
        ReentrantlockListFiller listFiller = new ReentrantlockListFiller(listForFilling, FILL_LIMIT);

        Runnable runnable = () -> {
            Random randomizer = new Random();
            for (int i = 0; i < FILL_LIMIT; i++) {
                listFiller.fillList(randomizer.nextInt(i + 1));
            }
        };

        Thread listFillerThread1 = new Thread(runnable);
        listFillerThread1.start();
        Thread listFillerThread2 = new Thread(runnable);
        listFillerThread2.start();
        Thread listFillerThread3 = new Thread(runnable);
        listFillerThread3.start();
        Thread listFillerThread4 = new Thread(runnable);
        listFillerThread4.start();
        Thread listFillerThread5 = new Thread(runnable);
        listFillerThread5.start();
        Thread listFillerThread6 = new Thread(runnable);
        listFillerThread6.start();

        try {
            listFillerThread1.join();
            listFillerThread2.join();
            listFillerThread3.join();
            listFillerThread4.join();
            listFillerThread5.join();
            listFillerThread6.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
