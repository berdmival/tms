package lec_15.homework.task_05;

import java.io.Serializable;

public class Cat implements Serializable {
	private String name;
	private String breed;
	private int age;

	public Cat(String name, String breed, int age) {
		this.name = name;
		this.breed = breed;
		this.age = age;
	}

	public Cat(String name, String breed) {
		this.name = name;
		this.breed = breed;
		this.age = 0;
	}

	public Cat(String name) {
		this.name = name;
		this.breed = null;
		this.age = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Cat{" +
				"name='" + name + '\'' +
				", breed='" + breed + '\'' +
				", age=" + age +
				'}';
	}
}
