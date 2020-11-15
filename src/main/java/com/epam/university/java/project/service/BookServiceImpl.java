package com.epam.university.java.project.service;

import com.epam.university.java.project.core.cdi.impl.io.XmlResource;
import com.epam.university.java.project.core.cdi.io.Resource;
import com.epam.university.java.project.core.state.machine.domain.StateMachineDefinition;
import com.epam.university.java.project.core.state.machine.domain.StatefulEntity;
import com.epam.university.java.project.core.state.machine.manager.StateMachineManager;
import com.epam.university.java.project.domain.Book;
import com.epam.university.java.project.domain.BookEvent;

import java.time.LocalDate;
import java.util.Collection;

public class BookServiceImpl implements BookService {

    private BookDao bookDao;
    private StateMachineManager stateMachineManager;

    /**
     * Default book service constructor.
     */
    public BookServiceImpl() {
        this.bookDao = new BookDaoXmlImpl();
    }

    @Override
    public Book createBook() {
        Resource resource = new XmlResource("/project/DefaultBookStateMachineDefinition.xml");
        //Resource resource = new XmlResource("A:\\epam-java-cources\\src\\main"
        //+ "\\resources\\project\\DefaultBookStateMachineDefinition.xml");
        StateMachineDefinition stateMachineDefinition =
                stateMachineManager.loadDefinition(resource);
        StatefulEntity book =
                stateMachineManager.initStateMachine(bookDao.createBook(), stateMachineDefinition);

        book.setState(stateMachineDefinition.getStartState());

        return (Book) stateMachineManager.handleEvent(book, stateMachineDefinition.getStartEvent());
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
        bookDao.remove(book);
        book.setReturnDate(returnDate);

        return (Book) stateMachineManager.handleEvent(book, BookEvent.ISSUE);
    }

    @Override
    public Book returnFromIssue(Book book) {
        bookDao.save(book);
        return (Book) stateMachineManager.handleEvent(book, BookEvent.RETURN);
    }


}
