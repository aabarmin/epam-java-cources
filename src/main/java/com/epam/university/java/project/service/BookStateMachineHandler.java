package com.epam.university.java.project.service;

import com.epam.university.java.project.core.state.machine.domain.StateMachineEventHandler;
import com.epam.university.java.project.domain.BookImpl;
import com.epam.university.java.project.domain.BookStatus;

/**
 * Created by Romin Nuro on 27.09.2020 20:41.
 */
public class BookStateMachineHandler implements StateMachineEventHandler {
    /**
     * This method should be called when accepting book.
     * @param book book
     * @return book
     */
    public BookImpl onAccept(BookImpl book) {
        book.setState(BookStatus.ACCOUNTED);
        return book;
    }

    /**
     * This method should be called when issuing book.
     * @param book book
     * @return book
     */
    public BookImpl onIssue(BookImpl book) {
        book.setState(BookStatus.ISSUED);
        return book;
    }

    /**
     * This method should be called when returning book.
     * @param book book
     * @return book
     */
    public BookImpl onReturn(BookImpl book) {
        book.setState(BookStatus.ACCOUNTED);
        return book;
    }
}
