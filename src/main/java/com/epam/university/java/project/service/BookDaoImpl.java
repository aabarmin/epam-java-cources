package com.epam.university.java.project.service;

import com.epam.university.java.project.domain.Book;
import com.epam.university.java.project.domain.BookImpl;

import java.util.ArrayList;
import java.util.Collection;

public class BookDaoImpl implements BookDao {
    Collection<Book> books = new ArrayList<>();

    @Override
    public Book createBook() {
        return new BookImpl();
    }

    @Override
    public Book getBook(int id) {
        for (Book book:
             books) {
            if (book.getId() == id){
                return book;
            }
        }
        return null;
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
        books.add(book);
        return book;
    }
}
