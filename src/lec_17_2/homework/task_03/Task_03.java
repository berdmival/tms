package lec_17_2.homework.task_03;

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

        int firstPartOfNumberForCountingFactorial = numberForCountingFactorial/2;
        int secondPartOfNumberForCountingFactorial = numberForCountingFactorial - firstPartOfNumberForCountingFactorial;

        FactorialCounter factorialCounterFirstPart = new FactorialCounter(firstPartOfNumberForCountingFactorial);
        FactorialCounter factorialCounterSecondPart = new FactorialCounter(secondPartOfNumberForCountingFactorial);

        ExecutorService executorService = Executors.newFixedThreadPool(6);

        Long factorial = 1L;

        Future<Long> firstPartOfFactorialThread = executorService.submit(factorialCounterFirstPart);
        try {
            factorial *= firstPartOfFactorialThread.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        Future<Long> secondPartOfFactorialThread = executorService.submit(factorialCounterSecondPart);
        try {
            factorial *= secondPartOfFactorialThread.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("factorial = " + factorial);

        executorService.shutdown();
    }
}
