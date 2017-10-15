package com.epam.university.java.project.service;

import com.epam.university.java.project.domain.Book;
import com.epam.university.java.project.domain.BookImpl;

import java.util.ArrayList;
import java.util.Collection;

public class BookDaoXmlImpl implements BookDao {

    private Collection<Book> books;
    private int bookId;

    public BookDaoXmlImpl() {
        books = new ArrayList<>();
    }

    @Override
    public Book createBook() {
        return new BookImpl();
    }

    @Override
    public Book getBook(int id) {
        return books.stream()
            .filter(n -> n.getId() == id)
            .findFirst()
            .orElse(null);
    }

    @Override
    public Collection<Book> getBooks() {
        return books;
    }

    @Override
    public void remove(Book book) {
        books.remove(book);
    }

    @Override
    public Book save(Book book) {
        book.setId(bookId + 1);
        books.add(book);
        return book;
    }

}
