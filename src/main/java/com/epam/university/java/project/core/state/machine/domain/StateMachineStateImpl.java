package com.epam.university.java.project.core.state.machine.domain;

import com.epam.university.java.project.domain.BookEvent;
import com.epam.university.java.project.domain.BookStatus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "transition")
@XmlAccessorType(XmlAccessType.FIELD)
public class StateMachineStateImpl implements StateMachineState<BookStatus, BookEvent> {
    @XmlAttribute
    private BookStatus from;
    @XmlAttribute
    private BookStatus to;
    @XmlAttribute
    private BookEvent on;
    @XmlAttribute
    private String call;

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
        return call;
    }

    @Override
    public void setMethodToCall(String method) {
        this.call = method;
    }
}