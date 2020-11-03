package com.epam.university.java.project.core.state.machine.domain;

import com.epam.university.java.project.domain.BookEvent;
import com.epam.university.java.project.domain.BookStatus;

public class StateMachineStateImpl implements StateMachineState<BookStatus, BookEvent> {
    private BookStatus mFrom;
    private BookStatus mTo;
    private BookEvent mOn;
    private String mMethodToCall;

    /**
     * Constructor of StateMachineStateImpl (with method name).
     */
    public StateMachineStateImpl(BookStatus from, BookStatus to, BookEvent on, String method) {
        this.mFrom = from;
        this.mTo = to;
        this.mOn = on;
        this.mMethodToCall = method;
    }

    /**
     * Constructor of StateMachineStateImpl (without method name).
     */
    public StateMachineStateImpl(BookStatus from, BookStatus to, BookEvent on) {
        this(from, to, on, null);
    }

    @Override
    public BookStatus getFrom() {
        return mFrom;
    }

    @Override
    public void setFrom(BookStatus state) {
        this.mFrom = state;
    }

    @Override
    public BookStatus getTo() {
        return mTo;
    }

    @Override
    public void setTo(BookStatus state) {
        this.mTo = state;
    }

    @Override
    public BookEvent getOn() {
        return mOn;
    }

    @Override
    public void setOn(BookEvent bookEvent) {
        this.mOn = bookEvent;
    }

    @Override
    public String getMethodToCall() {
        return mMethodToCall;
    }

    @Override
    public void setMethodToCall(String method) {
        this.mMethodToCall = method;
    }
}
