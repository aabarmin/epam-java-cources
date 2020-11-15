package com.epam.university.java.project.service;

import com.epam.university.java.project.domain.Book;
import com.epam.university.java.project.domain.BookStatus;
import com.epam.university.java.project.service.StateMachineEventHandler;

public class BookStateMachineHandler implements StateMachineEventHandler {

    public Book onAccept(Book book) {
        book.setState(BookStatus.ACCOUNTED);
        return book;
    }


    public Book onIssue(Book book) {
        book.setState(BookStatus.ISSUED);
        return book;
    }

    public Book onReturn(Book book) {
        book.setState(BookStatus.ACCOUNTED);
        return book;
    }

}
