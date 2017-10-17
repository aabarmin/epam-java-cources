package com.epam.university.java.project.service;

import com.epam.university.java.project.domain.Book;
import com.epam.university.java.project.domain.BookImpl;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Александр on 17.10.2017.
 */
public class BookDaoXmlImpl implements BookDao {
    private Collection<Book> books = new ArrayList<>();

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
        return books.stream()
                .filter(b -> (b.getId() == id))
                .findFirst()
                .orElse(null);
    }

    /**
     * Get all books.
     *
     * @return books collection
     */
    @Override
    public Collection<Book> getBooks() {
        return books;
    }

    /**
     * Remove book from library.
     *
     * @param book book to remove
     */
    @Override
    public void remove(Book book) {
        books.remove(book);
    }

    /**
     * Save book to library.
     *
     * @param book book to save
     * @return saved book instance
     */
    @Override
    public Book save(Book book) {
        books.add(book);
        return book;
    }
}
