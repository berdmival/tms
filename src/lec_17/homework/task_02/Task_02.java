package lec_17.homework.task_02;

public class Task_02 {
    public static void main(String[] args) {
        NumberShower numberShower = new NumberShower(20);
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
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}