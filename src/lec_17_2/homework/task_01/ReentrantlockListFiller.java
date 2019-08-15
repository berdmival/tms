package lec_17_2.homework.task_01;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantlockListFiller {
    private List<Integer> integerList;
    private int fillLimit;

    ReentrantLock locker = new ReentrantLock();

    public ReentrantlockListFiller(List<Integer> integerList, int fillLimit) {
        this.integerList = integerList;
        this.fillLimit = fillLimit;
    }

    public void fillList (Integer addValue) {
        locker.lock();
        integerList.add(addValue);
        locker.unlock();
    }

    public List<Integer> getIntegerList() {
        return integerList;
    }
}
