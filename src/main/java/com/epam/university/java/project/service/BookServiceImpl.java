package com.epam.university.java.project.service;

import com.epam.university.java.project.core.cdi.impl.io.XmlResource;
import com.epam.university.java.project.core.state.machine.domain.StateMachineDefinition;
import com.epam.university.java.project.core.state.machine.manager.StateMachineManager;
import com.epam.university.java.project.domain.Book;
import com.epam.university.java.project.domain.BookEvent;
import com.epam.university.java.project.domain.BookStatus;
import java.time.LocalDate;
import java.util.Collection;

public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoXmlImpl();
    private StateMachineManager stateMachineManager = new StateMachineManagerImpl();
    private StateMachineDefinition<BookStatus, BookEvent> definitions;

    @Override
    public Book createBook() {
        Book book = bookDao.createBook();
        definitions = (StateMachineDefinition<BookStatus, BookEvent>) stateMachineManager
            .loadDefinition(new XmlResource(getClass().getResource
                ("/project/DefaultBookStateMachineDefinition.xml").getFile()));
        stateMachineManager.initStateMachine(book, definitions);
        book = (Book)stateMachineManager.handleEvent(book, BookEvent.CREATE);
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
        book = (Book) stateMachineManager.handleEvent(book, BookEvent.ACCEPT);
        return book;
    }

    @Override
    public Book issue(Book book, LocalDate returnDate) {
        book.setReturnDate(returnDate);
        book = (Book) stateMachineManager.handleEvent(book, BookEvent.ISSUE);
        return book;
    }

    @Override
    public Book returnFromIssue(Book book) {
        book = (Book) stateMachineManager.handleEvent(book, BookEvent.RETURN);
        return book;
    }
}
