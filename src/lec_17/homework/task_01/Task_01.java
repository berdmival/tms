package lec_17.homework.task_01;

public class Task_01 {
    public static void main(String[] args) {
        NumberShower numberShower = new NumberShower(10);
        Thread numberShowerThread = new Thread(numberShower);
        numberShowerThread.start();
        try {
            numberShowerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class NumberShower implements Runnable {
    private int maxNumberOfShowing;

    public NumberShower(int maxNumberOfShowing) {
        this.maxNumberOfShowing = maxNumberOfShowing;
    }

    @Override
    public void run() {
        for (int i = 0; i <= maxNumberOfShowing; i++) {
            System.out.println(i);
        }
    }
}