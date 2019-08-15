package lec_17_2.homework.task_04;

import java.io.File;

// думаю этот класс имеет смысл удалить
public class Test_FileAnalyser {
    public static void main(String[] args) throws InterruptedException {
        FileAnalyzer fileAnalyzer = new FileAnalyzer(new File("./src/lec_17_2/homework/task_4/text_read.txt"));
        Thread thread = new Thread(fileAnalyzer);
        thread.start();
        thread.join();
        System.out.println(fileAnalyzer.getNumberOfWords());
    }
}
