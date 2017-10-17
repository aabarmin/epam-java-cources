package com.epam.university.java.project.service;

import com.epam.university.java.project.core.cdi.impl.io.XmlResource;
import com.epam.university.java.project.core.state.machine.manager.StateMachineManager;
import com.epam.university.java.project.core.state.machine.manager.StateMachineManagerImpl;
import com.epam.university.java.project.domain.Book;
import com.epam.university.java.project.domain.BookEvent;
import com.epam.university.java.project.domain.BookImpl;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Implementation class for BookService.
 *
 * @author Sergei Titov
 */
public class BookServiceImpl implements BookService {

    private int newBookIndex = 1;
    private Map<Integer, Book> booksMap = new HashMap<>();

    private StateMachineManager stateMachineManager = new StateMachineManagerImpl();

    /**
     * Default constructor.
     */
    public BookServiceImpl() {

        final String contextPath = getClass().getResource(
                "/project/DefaultBookStateMachineDefinition.xml").getFile();

        stateMachineManager.loadDefinition(new XmlResource(contextPath));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Book createBook() {

        return new BookImpl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Book getBook(int id) {

        return booksMap.get(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<Book> getBooks() {

        return booksMap.values();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(Book book) {

        booksMap.remove(book.getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Book save(Book book) {

        if (0 == book.getId()) {
            book.setId(newBookIndex++);
            booksMap.put(book.getId(), book);
        }
        return book;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Book accept(Book book, String number) {
        book.setSerialNumber(number);
        return (Book) stateMachineManager.handleEvent(book, BookEvent.ACCEPT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Book issue(Book book, LocalDate returnDate) {
        book.setReturnDate(returnDate);
        return (Book) stateMachineManager.handleEvent(book, BookEvent.ISSUE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Book returnFromIssue(Book book) {
        return (Book) stateMachineManager.handleEvent(book, BookEvent.RETURN);
    }
}
