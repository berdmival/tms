package lec_17_2.homework.task_03;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Task_03 {
    public static void main(String[] args) {
        Scanner inputNumber = new Scanner(System.in);
        System.out.println("Enter the number of counting factorial: ");
        String inputString = inputNumber.next();
        Integer numberForCountingFactorial = Integer.parseInt(inputString);

        int firstPartOfNumberForCountingFactorial = numberForCountingFactorial / 2;

        FactorialCounter factorialCounterFirstPart = new FactorialCounter(firstPartOfNumberForCountingFactorial);
        FactorialCounter factorialCounterSecondPart = new FactorialCounter(firstPartOfNumberForCountingFactorial + 1,
                numberForCountingFactorial);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        BigInteger factorial = BigInteger.ONE;

        List<Future<BigInteger>> threadsToCalculeteFactorial = new ArrayList<>();
        threadsToCalculeteFactorial.add(executorService.submit(factorialCounterFirstPart));
        threadsToCalculeteFactorial.add(executorService.submit(factorialCounterSecondPart));

        for (Future<BigInteger> bigIntegerFuture : threadsToCalculeteFactorial) {
            try {
                factorial = factorial.multiply(bigIntegerFuture.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println("factorial = " + factorial);

        executorService.shutdown();
    }
}
