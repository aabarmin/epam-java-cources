package com.epam.university.java.project.service;

import com.epam.university.java.project.domain.Book;
import com.epam.university.java.project.domain.BookImpl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BookDaoXmlImpl implements BookDao {
    private int next = 1;
    private Map<Integer, Book> books = new HashMap<>();

    @Override
    public Book createBook() {
        return new BookImpl();
    }

    @Override
    public Book getBook(int id) {
        return books.getOrDefault(id, null);
    }

    @Override
    public Collection<Book> getBooks() {
        return books.values();
    }

    @Override
    public void remove(Book book) {
        books.remove(book.getId());
    }

    @Override
    public Book save(Book book) {
        book.setId(next + 1);
        books.put(book.getId(), book);
        return book;
    }
}