package com.epam.university.java.project.service;

import com.epam.university.java.project.domain.Book;

import java.time.LocalDate;
import java.util.Collection;

public class BookServiceImpl implements BookService {
    private BookDao dao = new BookDaoImpl();

    @Override
    public Book createBook() {
        return dao.createBook();
    }

    @Override
    public Book getBook(int id) {
        return dao.getBook(id);
    }

    @Override
    public Collection<Book> getBooks() {
        return dao.getBooks();
    }

    @Override
    public void remove(Book book) {
        dao.remove(book);
    }

    @Override
    public Book save(Book book) {
        return dao.save(book);
    }

    @Override
    public Book accept(Book book, String number) {
        return null;
    }

    @Override
    public Book issue(Book book, LocalDate returnDate) {
        return null;
    }

    @Override
    public Book returnFromIssue(Book book) {
        return null;
    }
}
