package com.epam.university.java.project.core.state.machine.domain;

import com.epam.university.java.project.domain.BookEvent;
import com.epam.university.java.project.domain.BookStatus;

public class StateMachineStateImpl implements StateMachineState<BookStatus, BookEvent> {

    private BookStatus from;
    private BookStatus to;
    private BookEvent on;
    private String method;


    @Override
    public BookStatus getFrom() {
        return from;
    }

    @Override
    public void setFrom(BookStatus state) {
        this.from = state;
    }

    @Override
    public BookStatus getTo() {
        return to;
    }

    @Override
    public void setTo(BookStatus state) {
        this.to = state;
    }

    @Override
    public BookEvent getOn() {
        return on;
    }

    @Override
    public void setOn(BookEvent bookEvent) {
        this.on = bookEvent;
    }

    @Override
    public String getMethodToCall() {
        return method;
    }

    @Override
    public void setMethodToCall(String method) {
        this.method = method;
    }
}
