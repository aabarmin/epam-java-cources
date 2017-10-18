package com.epam.university.java.project.service;

import com.epam.university.java.project.domain.Book;
import com.epam.university.java.project.domain.BookImpl;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ilya on 24.09.17.
 */
public class BookDaoXmlImpl implements BookDao {
    private Map<Integer, Book> books = new HashMap<>();
    private int counter;

    @Override
    public Book createBook() {
        Book book = new BookImpl();
        book.setId(++counter);
        books.put(book.getId(), book);
        return book;
    }

    @Override
    public Book getBook(int id) {
        return books.get(id);
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
        return books.put(book.getId(), book);
    }
}
