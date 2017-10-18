package com.epam.university.java.project.service;

import com.epam.university.java.project.core.state.machine.manager.StateMachineManager;
import com.epam.university.java.project.domain.Book;
import com.epam.university.java.project.domain.BookEvent;

import java.time.LocalDate;
import java.util.Collection;

/**
 * Class implements <code>BookService</code>.
 */
public class BookServiceImpl implements BookService {

    private BookDao bookDao;
    private StateMachineManager stateMachineManager;

    @Override
    @SuppressWarnings("all")
    public Book createBook() {
        return (Book) stateMachineManager.handleEvent(bookDao.createBook(),
                BookEvent.CREATE);
    }

    @Override
    public Book getBook(int id) {
        return bookDao.getBook(id);
    }

    @Override
    public Collection<Book> getBooks() {
        return bookDao.getBooks();
    }

    @Override
    public void remove(Book book) {
        bookDao.remove(book);
    }

    @Override
    public Book save(Book book) {
        return bookDao.save(book);
    }

    @Override
    public Book issue(Book book, LocalDate returnDate) {
        book.setReturnDate(returnDate);
        return (Book) stateMachineManager.handleEvent(book, BookEvent.ISSUE);
    }

    @Override
    public Book accept(Book book, String number) {
        book.setSerialNumber(number);
        return bookDao.save((Book) stateMachineManager.handleEvent(book,
                BookEvent.ACCEPT));
    }

    @Override
    public Book returnFromIssue(Book book) {
        return (Book) stateMachineManager.handleEvent(book, BookEvent.RETURN);
    }
}