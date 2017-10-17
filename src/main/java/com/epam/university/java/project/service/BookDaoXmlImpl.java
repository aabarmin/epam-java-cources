package com.epam.university.java.project.service;

import com.epam.university.java.project.domain.Book;
import com.epam.university.java.project.domain.BookImpl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BookDaoXmlImpl implements BookDao {
    private Map<Integer, Book> books = new HashMap<>();

    /**
     * Create new book instance.
     *
     * @return new book instance
     */
    @Override
    public Book createBook() {
        Book book = new BookImpl();
        book.setId(books.size() + 1);
        return book;
    }

    /**
     * Get the book by id.
     *
     * @param id book id
     * @return book instance
     */
    @Override
    public Book getBook(int id) {
        return books.get(id);
    }

    /**
     * Get all books.
     *
     * @return books collection
     */
    @Override
    public Collection<Book> getBooks() {
        return books.values();
    }

    /**
     * Remove book from library.
     *
     * @param book book to remove
     */
    @Override
    public void remove(Book book) {
        books.remove(book.getId());
    }

    /**
     * Save book to library.
     *
     * @param book book to save
     * @return saved book instance
     */
    @Override
    public Book save(Book book) {
        books.put(book.getId(), book);
        return book;
    }
}
