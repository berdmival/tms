package lec_17_1.homework.task_03;

public class Task_03 {
    public static void main(String[] args) throws InterruptedException {
        ToysStore toysStore = new ToysStore();

        ToysProducer firstToysProducer = new ToysProducer(100, toysStore);
        ToysProducer secondToysProducer = new ToysProducer(50, toysStore);

        Thread firstToysProduserThread = new Thread(firstToysProducer);
        Thread secondToysProduserThread = new Thread(secondToysProducer);

        firstToysProduserThread.start();
        secondToysProduserThread.start();

        firstToysProduserThread.join();
        secondToysProduserThread.join();

        System.out.println("Numbers of toys in store: " + toysStore.getNumberOfToys());
    }
}

class ToysStore {
    private int numberOfToys;

    public int getNumberOfToys() {
        return numberOfToys;
    }

    public void addToy() {
        synchronized (this) {
            this.numberOfToys++;
        }
    }
}

    class ToysProducer implements Runnable {
        private int countOfAddedToys;
        ToysStore toysStore;

        public ToysProducer(int countOfAddedToys, ToysStore toysStore) {
            this.countOfAddedToys = countOfAddedToys;
            this.toysStore = toysStore;
        }

        public void addToy() {
            for (int i = 0; i < countOfAddedToys; i++) {
                this.toysStore.addToy();
            }
        }

        @Override
        public void run() {
            addToy();
        }
    }
