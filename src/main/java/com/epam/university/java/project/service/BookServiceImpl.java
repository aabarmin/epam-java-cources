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
    private final XmlResource xmlResource;
    private BookDao bookDao = new BookDaoXmlImpl();
    private StateMachineManagerImpl stateMachineManager = new StateMachineManagerImpl();
    private StateMachineDefinition<BookStatus, BookEvent> definition;

    /**
     * Constructor with no args.
     * <p>
     * Set xmlResource.
     * </p>
     */
    public BookServiceImpl() {
        final String testFilePath =
                getClass().getResource("/project/DefaultBookStateMachineDefinition.xml").getFile();
        this.xmlResource = new XmlResource(testFilePath);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Book createBook() {
        definition = (StateMachineDefinition<BookStatus, BookEvent>)
                stateMachineManager.loadDefinition(xmlResource);
        final StatefulEntity<BookStatus, BookEvent> entity =
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
        Book book1 = (Book) stateMachineManager.handleEvent(book, BookEvent.ACCEPT);
        return bookDao.save(book1);
    }

    @Override
    public Book issue(Book book, LocalDate returnDate) {
        book.setReturnDate(returnDate);
        Book book1 = (Book) stateMachineManager.handleEvent(book, BookEvent.ISSUE);
        return book1;
    }

    @Override
    public Book returnFromIssue(Book book) {
        Book book1 = (Book) stateMachineManager.handleEvent(book, BookEvent.RETURN);
        return book1;
    }
}
