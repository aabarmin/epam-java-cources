package com.epam.university.java.project.service;

import com.epam.university.java.project.domain.Book;

import java.time.LocalDate;
import java.util.Collection;

/**
 * Service for book management.
 */
public interface BookService {
    /**
     * Create new draft book instance.
     * @return new book instance
     */
    Book createBook();

    /**
     * Get the book by id.
     * @param id book id
     * @return book instance
     */
    Book getBook(int id);

    /**
     * Get all books.
     * @return books collection
     */
    Collection<Book> getBooks();

    /**
     * Remove book from library.
     * @param book book to remove
     */
    void remove(Book book);

    /**
     * Save book to library.
     * @param book book to save
     * @return saved book instance
     */
    Book save(Book book);

    /**
     * Accept book into the account with the following <code>number</code>.
     * @param book book to accept
     * @param number book number
     * @return accounted book
     */
    Book accept(Book book, String number);

    /**
     * Issue book and set return date.
     * @param book book to issue
     * @param returnDate return date
     * @return issued book
     */
    Book issue(Book book, LocalDate returnDate);

    /**
     * Return book from issue.
     * @param book book to return
     * @return accounted book
     */
    Book returnFromIssue(Book book);
}
