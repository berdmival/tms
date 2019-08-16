package lec_17_2.homework.task_05;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Book> favoriteBooks = new ArrayList<>();

    public Student(String name, ArrayList<Book> favoriteBooks) {
        this.name = name;
        this.favoriteBooks = favoriteBooks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getFavoriteBooks() {
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
}
