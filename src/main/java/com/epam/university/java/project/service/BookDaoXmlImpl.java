package com.epam.university.java.project.service;

import com.epam.university.java.project.domain.Book;
import com.epam.university.java.project.domain.BookImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Romin Nuro on 30.09.2020 15:05.
 */
public class BookDaoXmlImpl implements BookDao {
    private int lastBookId = 0;
    private final List<Book> library = new ArrayList<>();

    /**
     * Create new book instance.
     *
     * @return new book instance
     */
    @Override
    public Book createBook() {
        return new BookImpl();
    }

    /**
     * Get the book by id.
     *
     * @param id book id
     * @return book instance
     */
    @Override
    public Book getBook(int id) {
        for (Book book : library) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    /**
     * Get all books.
     *
     * @return books collection
     */
    @Override
    public Collection<Book> getBooks() {
        return library;
    }

    /**
     * Remove book from library.
     *
     * @param book book to remove
     */
    @Override
    public void remove(Book book) {
        library.remove(book);
    }

    /**
     * Save book to library.
     *
     * @param book book to save
     * @return saved book instance
     */
    @Override
    public Book save(Book book) {
        book.setId(++lastBookId);
        library.add(book);
        return book;
    }
}
