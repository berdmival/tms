package lec_17_2.homework.task_05;

import java.util.*;
import java.util.stream.Collectors;

/*
 * Task 5
 * Есть коллекция студентов. У каждого студента есть список любимых книг (книга - это отдельный класс с полями "название" и "год".
 * Написать программу которая бы выводила на экран топ-3 самых популярных книг среди студентов
 */


public class Task_05 {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        TreeMap<Integer, String> sortedFaworiteBooks = new TreeMap<>(Collections.reverseOrder());

        students.add(new Student("Vasya").addFavoriteBook(new Book("Book1", 1992)));
        students.add(new Student("Dmitry").addFavoriteBook(new Book("Book1", 1992)));
        students.add(new Student("Alex").addFavoriteBook(new Book("Book2", 1994)));
        students.add(new Student("Lena").addFavoriteBook(new Book("Book3", 2000)));
        students.add(new Student("Kolya").addFavoriteBook(new Book("Book2", 1994)));
        students.add(new Student("Pupkin").addFavoriteBook(new Book("Book2", 1994)));
        students.add(new Student("Petr").addFavoriteBook(new Book("Book2", 1994)));
        students.add(new Student("Masha").addFavoriteBook(new Book("Book3", 2000)));
        students.add(new Student("Sanya").addFavoriteBook(new Book("Book5", 1900)));
        students.add(new Student("Sanya").addFavoriteBook(new Book("Book3", 2000)));

        /*
        Map<String, Long> collect = students.stream()
                .flatMap(student -> student.getFavoriteBooks().stream())
                .collect(Collectors.groupingBy(Book::getBookName, Collectors.counting()));
        
        поищи сам как красиво отсортировать, можно поменять местами ключ и значение, чтобы сортировать по ключу (кол-ву книг)
        */
        students.stream()
                .flatMap(student -> student.getFavoriteBooks().stream())
                .collect(Collectors.groupingBy(Book::getBookName))
                .forEach((name, list) -> sortedFaworiteBooks.put(list.size(), name));

        sortedFaworiteBooks.entrySet().stream()
                .limit(3)
                .collect(TreeMap::new, (m, e) -> m.put(e.getKey(), e.getValue()), Map::putAll)
                .entrySet().stream()
                .sorted(new Comparator<Map.Entry<Object, Object>>() {
                    @Override
                    public int compare(Map.Entry<Object, Object> o1, Map.Entry<Object, Object> o2) {

                        return (Integer) o2.getKey() - (Integer) o1.getKey();
                    }
                })
                .forEach(System.out::println);
    }
}
