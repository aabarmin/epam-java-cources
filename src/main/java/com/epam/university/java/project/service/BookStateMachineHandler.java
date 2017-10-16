package com.epam.university.java.project.service;

import com.epam.university.java.project.core.state.machine.domain.StateMachineEventHandler;
import com.epam.university.java.project.domain.BookImpl;
import com.epam.university.java.project.domain.BookStatus;

public class BookStateMachineHandler implements StateMachineEventHandler {

    /**
     * Method to handle book create.
     * @return created book
     */
    public BookImpl onCreate(BookImpl book, BookStatus state) {
        book.setState(state);
        return book;
    }

    /**
     * Method to handle book accept.
     * @param book book to accept
     * @return accepted book
     */
    public BookImpl onAccept(BookImpl book, BookStatus state) {
        book.setState(state);
        return book;
    }

    /**
     * Method to handle book issue.
     * @param book book to issue
     * @return issued book
     */
    public BookImpl onIssue(BookImpl book, BookStatus state) {
        book.setState(state);
        return book;
    }

    /**
     * Method to handle book return.
     * @param book to return
     * @return returned book
     */
    public BookImpl onReturn(BookImpl book, BookStatus state) {
        book.setState(state);
        return book;
    }

}
