package com.epam.university.java.project.service;

import com.epam.university.java.project.core.state.machine.domain.StateMachineEventHandler;
import com.epam.university.java.project.domain.Book;
import com.epam.university.java.project.domain.BookStatus;

/**
 * Implementation class for StateMachineEventHandler - because there was no such a file.
 *
 * @author Sergei Titov
 */
public class BookStateMachineHandler implements StateMachineEventHandler {

    /**
     * {@inheritDoc}
     */
    public Book onAccept(Book book) {
        book.setState(BookStatus.ACCOUNTED);
        return book;
    }

    /**
     * {@inheritDoc}
     */
    public Book onIssue(Book book) {
        book.setState(BookStatus.ISSUED);
        return book;
    }

    /**
     * {@inheritDoc}
     */
    public Book onReturn(Book book) {
        book.setState(BookStatus.ACCOUNTED);
        return book;
    }

}
