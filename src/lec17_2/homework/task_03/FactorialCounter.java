package lec17_2.homework.task_03;

import java.util.concurrent.Callable;

public class FactorialCounter implements Callable<Long>{
    private int numberForCountingFactorial;

    public FactorialCounter(int numberForCountingFactorial) {
        this.numberForCountingFactorial = numberForCountingFactorial;
    }

    @Override
    public Long call() throws Exception {
        Long factorial = 1L;

        for (int i = 1; i < this.numberForCountingFactorial; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
