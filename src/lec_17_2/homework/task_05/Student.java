package lec_17_2.homework.task_05;

import java.util.ArrayList;

public class Student {
    private String name;
    // private List<Book> favoriteBooks;
    private ArrayList<Book> favoriteBooks = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Book> getFavoriteBooks() {
        return favoriteBooks;
    }

    public void setFavoriteBooks(ArrayList<Book> favoriteBooks) {
        this.favoriteBooks = favoriteBooks;
    }

    public Student(String name) {
        this.name = name;
    }

    public Student addFavoriteBook(Book book) {
        this.favoriteBooks.add(book);
        return this;
    }

    // конструктор идет сразу после полей класса
    public Student(String name, ArrayList<Book> favoriteBooks) {
        this.name = name;
        this.favoriteBooks = favoriteBooks;
    }
}
