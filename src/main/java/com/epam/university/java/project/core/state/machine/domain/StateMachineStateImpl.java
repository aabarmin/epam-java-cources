package com.epam.university.java.project.core.state.machine.domain;

import com.epam.university.java.project.domain.BookEvent;
import com.epam.university.java.project.domain.BookStatus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Implementation class for StateMachineDefinition.
 *
 * @author Sergei Titov
 */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public BookStatus getFrom() {
        return from;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setFrom(BookStatus state) {
        this.from = state;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BookStatus getTo() {
        return to;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTo(BookStatus state) {
        this.to = state;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BookEvent getOn() {
        return on;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setOn(BookEvent o) {
        this.on = o;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMethodToCall() {
        return call;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMethodToCall(String method) {
        this.call = method;
    }
}
