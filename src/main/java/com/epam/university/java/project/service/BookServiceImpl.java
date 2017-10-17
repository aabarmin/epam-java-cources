package com.epam.university.java.project.service;

import com.epam.university.java.project.domain.Book;
import com.epam.university.java.project.domain.BookImpl;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Implementation class for BookService.
 *
 * @author Sergei Titov
 */
public class BookServiceImpl implements BookService {

    private int newBookIndex = 1;
    Map<Integer, Book> booksMap = new HashMap<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public Book createBook() {

        return new BookImpl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Book getBook(int id) {

        return booksMap.get(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<Book> getBooks() {

        return booksMap.values();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(Book book) {

        booksMap.remove(book.getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Book save(Book book) {

        if (0 == book.getId()) {
            book.setId(newBookIndex++);
            booksMap.put(book.getId(), book);
        }
        return book;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Book accept(Book book, String number) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Book issue(Book book, LocalDate returnDate) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Book returnFromIssue(Book book) {
        return null;
    }
}
