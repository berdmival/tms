package lec_17_2.homework.task_03;

import java.math.BigInteger;
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

        // newFixedThreadPool(6) - зачем тебе 6, когда считаешь в 2 потока?
        ExecutorService executorService = Executors.newFixedThreadPool(6);

        BigInteger factorial = BigInteger.ONE;

        /* firstPartOfFactorialThread.get() - метод get() блокирующий, т.е. главный поток будет ждать, пока get()
        не вернет результат, т.е. твой второй поток не будет запущен.
        Поэтому создаешь лист List<Future<BigInteger>> и добавляешь туда 
        executorService.submit(factorialCounterFirstPart)
        затем бежишь по этому листу, у каждого элемента вызываешь метод get() и перемноаешь результат
        */
        Future<BigInteger> firstPartOfFactorialThread = executorService.submit(factorialCounterFirstPart);
        try {
            factorial = factorial.multiply(firstPartOfFactorialThread.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        Future<BigInteger> secondPartOfFactorialThread = executorService.submit(factorialCounterSecondPart);
        try {
            factorial = factorial.multiply(secondPartOfFactorialThread.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("factorial = " + factorial);

        executorService.shutdown();
    }
}
