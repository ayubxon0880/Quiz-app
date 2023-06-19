package uz.friendchallange.friendchallange.dto;

import java.util.ArrayList;
import java.util.List;

public class BooksCreationDto {
    private List<Book> books = new ArrayList<>();

    // default and parameterized constructor

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
