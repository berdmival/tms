package lec_15.homework.task_05;

/*
 * создать лист элементов (типа cat) заполнить лист элементами и null,
 * сериализовать лист в файл и десериализовать из файла. проверить наличие null элементов
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task_05 {
// SERIALIZED_LIST - это не сам  лист, а путь к нему
    private static final String SERIALIZED_LIST = "./src/lec_15/homework/task_05/serializedList";

    public static void main(String[] args) {
        List<Cat> kennel = new ArrayList<>();
        kennel.add(new Cat("Vaska", "Maincun", 5));
        kennel.add(null);
        kennel.add(new Cat("Zuzia", "Sphinks"));
        kennel.add(new Cat("Murka"));

        System.out.println("kennel = " + kennel);

        try (FileOutputStream fileOutputStream = new FileOutputStream(SERIALIZED_LIST);
             ObjectOutputStream streamForSerializingList = new ObjectOutputStream(fileOutputStream)) {
            streamForSerializingList.writeObject(kennel);
            streamForSerializingList.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Cat> secondKennel = new ArrayList<>();

        try (FileInputStream fileInputStream = new FileInputStream(SERIALIZED_LIST);
             ObjectInputStream streamForDeserializingList = new ObjectInputStream(fileInputStream)) {
            secondKennel = (List<Cat>) streamForDeserializingList.readObject();

            secondKennel.forEach(Cat -> {
                if (Cat == null) System.out.println("secondKennel contains null");
            });

            System.out.println("secondKennel = " + secondKennel);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
