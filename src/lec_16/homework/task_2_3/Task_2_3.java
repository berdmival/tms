package lec_16.homework.task_2_3;

/*
 * Task 2
 * Есть студенты. Каждый студент записан в отдельном .json файле.
 * У каждого студента есть номер группы, имя, фамилия, факультет и список любимых предметов для изучения.
 * Прочитать студентов при помощи Jackson JSON парсера и добавить их в какой-нибудь лист.
 *
 * Task 3
 * Продолжение Task 2. Необходимо отсортировать студентов по фамилии и имени, а затем записать отсортированный список в файл
 */

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Objects;
import java.util.TreeSet;

public class Task_2_3 {
    private static final String STUDENTS_DIRECTORY = "./resources/json/students/";
    private static final String STUDENTS_ACCUMULATE_JSON = "./resources/json/students/all_students.json";

    public static void main(String[] args) {
        //Comparator for sorting by firstname and lastname
        Comparator<Student> studentComparator = ((Comparator<Student>) (a, b) -> a.getLastName().compareTo(b.getLastName()))
                .thenComparing((a, b) -> a.getFirstName().compareTo(b.getFirstName()));

        //TreeSet for accumulating and automatic sorting students
        TreeSet<Student> students = new TreeSet(studentComparator);

        File studentsDirectory = new File(STUDENTS_DIRECTORY);

        //array of json-files with each student
        File[] listOfJSONStudents = studentsDirectory.listFiles((dir, name) -> (name.toLowerCase().endsWith(".json")));

        ObjectMapper mapper = new ObjectMapper();

        for (File studentFile : Objects.requireNonNull(listOfJSONStudents)) {
            try {
                Student student = mapper.readValue(studentFile, Student.class);
                System.out.println(student);
                students.add(student);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println();
        students.forEach(Student -> System.out.println(Student));

        try (FileWriter fileWriter = new FileWriter(STUDENTS_ACCUMULATE_JSON)) {
            mapper.writeValue(fileWriter, Objects.requireNonNull(students));
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
