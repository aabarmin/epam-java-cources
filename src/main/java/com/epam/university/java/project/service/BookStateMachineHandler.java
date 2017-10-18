package com.epam.university.java.project.service;

import com.epam.university.java.project.core.state.machine.domain.StateMachineEventHandler;
import com.epam.university.java.project.domain.Book;
import com.epam.university.java.project.domain.BookImpl;
import com.epam.university.java.project.domain.BookStatus;

public class BookStateMachineHandler implements StateMachineEventHandler {

    public BookImpl onCreate(BookImpl book, BookStatus state) {
        book.setState(state);
        return book;
    }

    public BookImpl onAccept(BookImpl book, BookStatus state) {
        book.setState(state);
        return book;
    }

    public BookImpl onIssue(BookImpl book, BookStatus state) {
        book.setState(state);
        return book;
    }

    public BookImpl onReturn(BookImpl book, BookStatus state) {
        book.setState(state);
        return book;
    }
}