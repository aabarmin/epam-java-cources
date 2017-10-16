package com.epam.university.java.project.service;

import com.epam.university.java.project.core.state.machine.domain.StateMachineEventHandler;
import com.epam.university.java.project.domain.Book;
import com.epam.university.java.project.domain.BookStatus;

public class BookStateMachineHandler implements StateMachineEventHandler {

    /**
     * Called when a book is accepted.
     *
     * @param book Book instance
     * @return accepted book
     */
    public Book onAccept(Book book) {
        book.setState(BookStatus.ACCOUNTED);
        return book;
    }

    /**
     * Called when a book is issued.
     *
     * @param book Book instance
     * @return issued book
     */
    public Book onIssue(Book book) {
        book.setState(BookStatus.ISSUED);
        return book;
    }

    /**
     * Called when a book is returned.
     *
     * @param book Book instance
     * @return returned book
     */
    public Book onReturn(Book book) {
        book.setState(BookStatus.ACCOUNTED);
        return book;
    }

}
