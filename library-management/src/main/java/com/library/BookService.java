package com.library;

import java.util.ArrayList;
import java.util.List;

public class BookService {

    private List<String> books = new ArrayList<>();

    public void addBook(String book) {
        books.add(book);
    }

    public boolean findBook(String book) {
        return books.contains(book);
    }

    public void removeBook(String book) {
        books.remove(book);
    }

    public int getBookCount() {
        return books.size();
    }
}