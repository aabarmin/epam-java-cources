package com.epam.university.java.project.service;

import com.epam.university.java.project.domain.Book;

import java.util.Collection;

/**
 * Data access object for books.
 */
public interface BookDao {
    /**
     * Create new book instance.
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
}
