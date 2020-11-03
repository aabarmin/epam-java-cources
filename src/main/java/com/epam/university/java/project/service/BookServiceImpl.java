package com.epam.university.java.project.service;

import com.epam.university.java.project.core.cdi.impl.io.XmlResource;
import com.epam.university.java.project.core.state.machine.domain.StateMachineDefinition;
import com.epam.university.java.project.core.state.machine.domain.StatefulEntity;
import com.epam.university.java.project.core.state.machine.manager.StateMachineManager;
import com.epam.university.java.project.domain.Book;
import com.epam.university.java.project.domain.BookEvent;
import com.epam.university.java.project.domain.BookImpl;
import com.epam.university.java.project.domain.BookStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class BookServiceImpl implements BookService {
    private StateMachineManager stateMachineManager;
    private BookDao bookDao;
    private StateMachineDefinition<BookStatus, BookEvent> stateMachineDefinition;


    public BookServiceImpl() {
        this.stateMachineManager = new StateMachineManagerImpl();
        this.bookDao = new BookDaoXmlImpl();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Book createBook() {
        Book book = bookDao.createBook();
        final String contextPath = getClass()
                .getResource("/project/DefaultBookStateMachineDefinition.xml")
                .getFile();
        stateMachineDefinition =
                (StateMachineDefinition<BookStatus, BookEvent>) stateMachineManager
                        .loadDefinition(new XmlResource(contextPath));
        StatefulEntity<BookStatus, BookEvent> bookStatusBookEventStatefulEntity =
                stateMachineManager.initStateMachine(book, stateMachineDefinition);
        stateMachineManager.handleEvent(bookStatusBookEventStatefulEntity, BookEvent.CREATE);
        return book;
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
    public Book accept(Book book, String number) {
        stateMachineManager.handleEvent(book, BookEvent.ACCEPT);
        book.setSerialNumber(number);
        return book;
    }

    @Override
    public Book issue(Book book, LocalDate returnDate) {
        bookDao.remove(book);
        book.setReturnDate(returnDate);
        stateMachineManager.handleEvent(book, BookEvent.ISSUE);
        return book;
    }

    @Override
    public Book returnFromIssue(Book book) {
        book.setReturnDate(null);
        stateMachineManager.handleEvent(book, BookEvent.RETURN);
        return book;
    }
}
