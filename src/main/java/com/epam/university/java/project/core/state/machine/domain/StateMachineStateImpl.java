package com.epam.university.java.project.core.state.machine.domain;

import com.epam.university.java.project.domain.BookEvent;
import com.epam.university.java.project.domain.BookStatus;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * Class implements <code>StateMachineState</code>.
 */
@XmlRootElement(name = "transition")
@XmlAccessorType(XmlAccessType.FIELD)
public class StateMachineStateImpl implements StateMachineState<BookStatus,
        BookEvent> {

    @XmlAttribute(name = "from")
    private BookStatus from;
    @XmlAttribute(name = "to")
    private BookStatus to;
    @XmlAttribute(name = "on")
    private BookEvent on;
    @XmlAttribute(name = "call")
    private String methodToCall;

    @Override
    public BookStatus getFrom() {
        return from;
    }

    @Override
    public void setFrom(BookStatus state) {
        from = state;
    }

    @Override
    public BookStatus getTo() {
        return to;
    }

    @Override
    public void setTo(BookStatus state) {
        to = state;
    }

    @Override
    public BookEvent getOn() {
        return on;
    }

    @Override
    public void setOn(BookEvent bookEvent) {
        on = bookEvent;
    }

    @Override
    public String getMethodToCall() {
        return methodToCall;
    }

    @Override
    public void setMethodToCall(String method) {
        methodToCall = method;
    }
}