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

    @XmlAttribute(name = "call")
    private String methodToCall;

    /**
     * Default constructor.
     */
    public StateMachineStateImpl() {
    }

    @Override
    public BookStatus getFrom() {
        return from;
    }

    @Override
    public void setFrom(BookStatus from) {
        this.from = from;
    }

    @Override
    public BookStatus getTo() {
        return to;
    }

    @Override
    public void setTo(BookStatus to) {
        this.to = to;
    }

    @Override
    public BookEvent getOn() {
        return on;
    }

    @Override
    public void setOn(BookEvent on) {
        this.on = on;
    }

    @Override
    public String getMethodToCall() {
        return methodToCall;
    }

    @Override
    public void setMethodToCall(String methodToCall) {
        this.methodToCall = methodToCall;
    }
}
