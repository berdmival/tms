package lec17_2.homework.task_01;

import java.util.ArrayList;
import java.util.List;

public class Task_01 {
    private static final int FILL_LIMIT = 100;
    public static void main(String[] args) {
        List<Integer> listForFilling = new ArrayList<>();

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

        listForFilling.forEach(listForFillingElement -> System.out.println(listForFillingElement));
    }
}
