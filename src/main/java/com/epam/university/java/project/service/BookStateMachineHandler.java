package com.epam.university.java.project.service;

import com.epam.university.java.project.core.state.machine.domain.StateMachineEventHandler;
import com.epam.university.java.project.core.state.machine.domain.StatefulEntity;
import com.epam.university.java.project.domain.Book;
import com.epam.university.java.project.domain.BookEvent;
import com.epam.university.java.project.domain.BookStatus;

/**
 * State machine event handler.
 */
public class BookStateMachineHandler implements StateMachineEventHandler {

    /**
     * Routine method to call when a book is accepted.
     * @param book Book instance
     * @return accepted book
     */
    public Book onAccept(Book book) {
        book.setState(BookStatus.ACCOUNTED);
        return book;
    }

    /**
     * Routine method to call when a book is issued.
     * @param book Book instance
     * @return issued book
     */
    public Book onIssue(Book book) {
        book.setState(BookStatus.ISSUED);
        return book;
    }

    /**
     * Routine method to call when a book is returned.
     * @param book Book instance
     * @return returned book
     */
    public Book onReturn(Book book) {
        book.setState(BookStatus.ACCOUNTED);
        return book;
    }

}
