package com.epam.university.java.project.service;

import com.epam.university.java.project.core.cdi.impl.io.XmlResource;
import com.epam.university.java.project.core.cdi.io.Resource;
import com.epam.university.java.project.core.state.machine.domain.StateMachineDefinition;
import com.epam.university.java.project.core.state.machine.manager.StateMachineManager;
import com.epam.university.java.project.domain.Book;
import com.epam.university.java.project.domain.BookEvent;
import com.epam.university.java.project.domain.BookStatus;

import java.time.LocalDate;
import java.util.Collection;

public class BookServiceImpl implements BookService {
    private BookDao bookDao;
    private StateMachineManager stateMachineManager;
    private Resource resource;

    /**
     * Default constructor.
     */
    public BookServiceImpl() {
        stateMachineManager = new StateMachineManagerImpl();
        bookDao = new BookDaoXmlImpl();
        resource = new XmlResource(getClass()
                .getResource("/project/DefaultBookStateMachineDefinition.xml")
                .getFile());
    }

    @Override
    @SuppressWarnings("unchecked")
    public Book createBook() {
        return (Book) stateMachineManager.handleEvent(
                stateMachineManager.initStateMachine(
                        bookDao.createBook(),
                        (StateMachineDefinition<BookStatus, BookEvent>)
                                stateMachineManager.loadDefinition(resource)
                ),
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
    public Book accept(Book book, String number) {
        book.setSerialNumber(number);
        return bookDao.save((Book) stateMachineManager.handleEvent(book, BookEvent.ACCEPT));
    }

    @Override
    public Book issue(Book book, LocalDate returnDate) {
        book.setReturnDate(returnDate);
        return (Book) stateMachineManager.handleEvent(book, BookEvent.ISSUE);
    }

    @Override
    public Book returnFromIssue(Book book) {
        return (Book) stateMachineManager.handleEvent(book, BookEvent.RETURN);
    }
}
