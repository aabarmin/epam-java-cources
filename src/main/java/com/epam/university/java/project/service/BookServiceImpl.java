package com.epam.university.java.project.service;

import com.epam.university.java.project.domain.Book;

import java.time.LocalDate;
import java.util.Collection;

/**
 * Implementation class for BookService.
 *
 * @author Sergei Titov
 */
public class BookServiceImpl implements BookService {

    /**
     * {@inheritDoc}
     */
    @Override
    public Book createBook() {
        return null;
    }

    /**
     * {@inheritDoc}
     */    @Override
    public Book getBook(int id) {
        return null;
    }

    /**
     * {@inheritDoc}
     */    @Override
    public Collection<Book> getBooks() {
        return null;
    }

    /**
     * {@inheritDoc}
     */    @Override
    public void remove(Book book) {

    }

    /**
     * {@inheritDoc}
     */    @Override
    public Book save(Book book) {
        return null;
    }

    /**
     * {@inheritDoc}
     */    @Override
    public Book accept(Book book, String number) {
        return null;
    }

    /**
     * {@inheritDoc}
     */    @Override
    public Book issue(Book book, LocalDate returnDate) {
        return null;
    }

    /**
     * {@inheritDoc}
     */    @Override
    public Book returnFromIssue(Book book) {
        return null;
    }
}
