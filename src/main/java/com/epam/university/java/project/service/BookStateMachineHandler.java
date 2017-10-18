package com.epam.university.java.project.service;

import com.epam.university.java.project.core.state.machine.domain
        .StateMachineEventHandler;
import com.epam.university.java.project.domain.BookImpl;
import com.epam.university.java.project.domain.BookStatus;

/**
 * Class implements <code>StateMachineEventHandler</code>.
 */
public class BookStateMachineHandler implements StateMachineEventHandler {

    /**
     * Handle book creation.
     *
     * @return created book
     */
    public BookImpl onCreate(BookImpl book, BookStatus state) {
        book.setState(state);
        return book;
    }

    /**
     * Handle book return.
     *
     * @param book book to issue
     * @return issued book
     */
    public BookImpl onReturn(BookImpl book, BookStatus state) {
        book.setState(state);
        return book;
    }

    /**
     * Handle book accept.
     *
     * @param book book to accept
     * @return accepted book
     */
    public BookImpl onAccept(BookImpl book, BookStatus state) {
        book.setState(state);
        return book;
    }

    /**
     * Handle book issue.
     *
     * @param book book to issue
     * @return issued book
     */
    public BookImpl onIssue(BookImpl book, BookStatus state) {
        book.setState(state);
        return book;
    }
}