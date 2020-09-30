package com.epam.university.java.project.core.state.machine.domain;

import com.epam.university.java.project.domain.BookEvent;
import com.epam.university.java.project.domain.BookStatus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Romin Nuro on 26.09.2020 22:40.
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
     * From state.
     *
     * @return state name
     */
    @Override
    public BookStatus getFrom() {
        return from;
    }

    /**
     * Set from state.
     *
     * @param state state name
     */
    @Override
    public void setFrom(BookStatus state) {
        this.from = state;
    }

    /**
     * Get to state.
     *
     * @return state name
     */
    @Override
    public BookStatus getTo() {
        return to;
    }

    /**
     * Set to state.
     *
     * @param state state name
     */
    @Override
    public void setTo(BookStatus state) {
        this.to = state;
    }

    /**
     * Get event.
     *
     * @return event name
     */
    @Override
    public BookEvent getOn() {
        return on;
    }

    /**
     * Set event name.
     *
     * @param event event name
     */
    @Override
    public void setOn(BookEvent event) {
        this.on = event;
    }

    /**
     * Get method name to call on event. Method should exists in event handler.
     *
     * @return method name
     */
    @Override
    public String getMethodToCall() {
        return call;
    }

    /**
     * Set method name to call on event.
     *
     * @param method method name
     */
    @Override
    public void setMethodToCall(String method) {
        this.call = method;
    }
}
