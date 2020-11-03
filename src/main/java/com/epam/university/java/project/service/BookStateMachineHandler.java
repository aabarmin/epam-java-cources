package com.epam.university.java.project.service;

import com.epam.university.java.project.core.state.machine.domain.StateMachineEventHandler;
import com.epam.university.java.project.domain.BookImpl;
import com.epam.university.java.project.domain.BookStatus;

public class BookStateMachineHandler implements StateMachineEventHandler {
    public BookImpl onAccept(BookImpl book) {
        book.setState(BookStatus.ACCOUNTED);
        return book;
    }

    public BookImpl onIssue(BookImpl book) {
        book.setState(BookStatus.ISSUED);
        return book;
    }

    public BookImpl onReturn(BookImpl book) {
        book.setState(BookStatus.ACCOUNTED);
        return book;
    }
}
