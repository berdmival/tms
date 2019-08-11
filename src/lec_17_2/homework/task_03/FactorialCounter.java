package lec_17_2.homework.task_03;

import java.math.BigInteger;
import java.util.concurrent.Callable;

public class FactorialCounter implements Callable<BigInteger> {
    private int numberForFinishCountingFactorial;
    private int numberForStartCountingFactorial;

    public FactorialCounter(int numberForStartCountingFactorial, int numberForFinishCountingFactorial) {
        this.numberForFinishCountingFactorial = numberForFinishCountingFactorial;
        this.numberForStartCountingFactorial = numberForStartCountingFactorial;
    }

    public FactorialCounter(int numberForFinishCountingFactorial) {
        this(1, numberForFinishCountingFactorial);
    }

    @Override
    public BigInteger call() throws Exception {
        BigInteger factorial = BigInteger.ONE;

        for (int i = this.numberForStartCountingFactorial; i <= this.numberForFinishCountingFactorial; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }
}
