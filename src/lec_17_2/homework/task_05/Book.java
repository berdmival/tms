package lec_17_2.homework.task_05;

import java.util.Objects;

public class Book {
    private String bookName;
    private int bookCreationYear;

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", bookCreationYear=" + bookCreationYear +
                '}';
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookCreationYear() {
        return bookCreationYear;
    }

    public void setBookCreationYear(int bookCreationYear) {
        this.bookCreationYear = bookCreationYear;
    }

    public Book(String bookName, int bookCreationYear) {
        this.bookName = bookName;
        this.bookCreationYear = bookCreationYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return getBookCreationYear() == book.getBookCreationYear() &&
                Objects.equals(getBookName(), book.getBookName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookName(), getBookCreationYear());
    }
}
