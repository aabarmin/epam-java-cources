package com.epam.university.java.project.service;

import com.epam.university.java.project.domain.Book;
import com.epam.university.java.project.domain.BookImpl;

import java.util.Map;
import java.util.Collection;
import java.util.LinkedHashMap;

/**
 * Class implements <code>BookDao</code>.
 * */
public class BookDaoXmlImpl implements BookDao {
    private Map<Integer, Book> books = new LinkedHashMap<>();
    private int nextId = 1;

    @Override
    public Book createBook() {
        return new BookImpl();
    }

    @Override
    public Book getBook(int id) {
        return this.books.getOrDefault(
                id, null);
    }

    @Override
    public Collection<Book> getBooks() {
        return this.books.values();
    }

    @Override
    public void remove(Book book) {
        this.books.remove(book.getId());
    }

    @Override
    public Book save(Book book) {
        book.setId(nextId++);
        this.books.put(book.getId(), book);
        return book;
    }
}