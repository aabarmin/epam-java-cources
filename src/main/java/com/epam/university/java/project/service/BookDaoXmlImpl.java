package com.epam.university.java.project.service;

import com.epam.university.java.project.domain.Book;
import com.epam.university.java.project.domain.BookImpl;

import java.util.Collection;
import java.util.LinkedHashMap;

public class BookDaoXmlImpl implements BookDao {

    private LinkedHashMap<Integer, Book> books = new LinkedHashMap<>();

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
        return books.getOrDefault(id,null);
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
        book.setId(books.size() + 1);
        books.put(book.getId(), book);
        return book;
    }

}
