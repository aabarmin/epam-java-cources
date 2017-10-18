package com.epam.university.java.project.service;

import com.epam.university.java.project.core.cdi.impl.io.XmlResource;
import com.epam.university.java.project.core.state.machine.domain.StateMachineDefinition;
import com.epam.university.java.project.core.state.machine.domain.StatefulEntity;
import com.epam.university.java.project.domain.Book;
import com.epam.university.java.project.domain.BookEvent;
import com.epam.university.java.project.domain.BookStatus;

import java.time.LocalDate;
import java.util.Collection;

public class BookServiceImpl implements BookService {
    private XmlResource xmlResource;
    BookDaoImpl bookDao = new BookDaoImpl();
    private StateMachineManagerImpl stateMachineManager = new StateMachineManagerImpl();
    private StateMachineDefinition<BookStatus, BookEvent> definition;

    /**
     * Service constructor.
     */
    public BookServiceImpl() {
        xmlResource = new XmlResource(getClass()
                .getResource("/project/DefaultBookStateMachineDefinition.xml")
                .getFile());
    }

    @Override
    @SuppressWarnings("unchecked")
    public Book createBook() {
        definition = (StateMachineDefinition<BookStatus, BookEvent>) stateMachineManager
                .loadDefinition(xmlResource);
        StatefulEntity<BookStatus, BookEvent> entity =
                stateMachineManager.initStateMachine(bookDao.createBook(), definition);
        Book book = (Book) stateMachineManager.handleEvent(entity, BookEvent.CREATE);
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
        book.setSerialNumber(number);
        Book result = (Book) stateMachineManager.handleEvent(book, BookEvent.ACCEPT);
        return result;
    }

    @Override
    public Book issue(Book book, LocalDate returnDate) {
        book.setReturnDate(returnDate);
        Book result = (Book) stateMachineManager.handleEvent(book, BookEvent.ISSUE);

        return result;
    }

    @Override
    public Book returnFromIssue(Book book) {
        Book result = (Book) stateMachineManager.handleEvent(book, BookEvent.RETURN);
        return result;
    }
}
