package lec_17_2.homework.task_4;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class FileAnalyzer implements Runnable {
    private File fileForAnalysis;
    private int numberOfWords;

    public FileAnalyzer(File fileForAnalysis) {
        this.fileForAnalysis = fileForAnalysis;
    }

    public int getNumberOfWords() {
        return numberOfWords;
    }

    @Override
    public void run() {
        ArrayList<String> wordsFromReadingLine = new ArrayList<>();

        try (FileReader fileReader = new FileReader(this.fileForAnalysis);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String readingLine;

            while ((readingLine = bufferedReader.readLine()) != null) {
                wordsFromReadingLine.addAll(new ArrayList<>(Arrays.asList(readingLine.split("\\w+"))));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.numberOfWords = wordsFromReadingLine.size();
    }
}
