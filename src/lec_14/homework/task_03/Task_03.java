package lec_14.homework.task_03;

/*
 * Task 3 (map + filter)
 * Есть коллекция телефонов. Необходимо получить из нее коллекцию производителей (производитель - это строка) и оставить только те, которые входят в список:
 * Apple, Samsung, Xiaomi
 */

import java.util.*;
import java.util.stream.*;
import lec_14.homework.set_elements.*;

public class Task_03 {
    public static void main(String[] args) {
        List<Phone> setOfPhones = new ArrayList<>();

        setOfPhones.add(new Phone("XS", "Apple", 1000));
		setOfPhones.add(new Phone("s10", "Samsung", 700));
		setOfPhones.add(new Phone("4M", "Xiaomi", 400));
		setOfPhones.add(new Phone("3310", "Nokia", 50));
		setOfPhones.add(new Phone("8", "Apple", 900));
		
		Set<String> filterSet = new HashSet<>();
		filterSet.add("Apple");
		filterSet.add("Samsung");
		filterSet.add("Xiaomi");
		
		Set<String> producers = setOfPhones.stream()
			.map(Phone::getProducer)
			.filter(produser -> filterSet.contains(produser))
		.collect(Collectors.toSet());
		
		System.out.println("producers: " + producers);
    }
}
