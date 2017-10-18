package com.epam.university.java.project.core.state.machine.domain;

import com.epam.university.java.project.domain.BookEvent;
import com.epam.university.java.project.domain.BookStatus;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Created by Александр on 18.10.2017.
 * State machine state.
 */
public class StateMachineStateImpl implements StateMachineState<BookStatus, BookEvent> {
    @XmlAttribute(name = "from")
    private BookStatus from;
    @XmlAttribute(name = "to")
    private BookStatus to;
    @XmlAttribute(name = "on")
    private BookEvent on;
    @XmlAttribute(name = "call")
    private String methodToCall;

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
        from = state;
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
        to = state;
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
     * @param bookEvent event name
     */
    @Override
    public void setOn(BookEvent bookEvent) {
        on = bookEvent;
    }

    /**
     * Get method name to call on event. Method should exists in event handler.
     *
     * @return method name
     */
    @Override
    public String getMethodToCall() {
        return methodToCall;
    }

    /**
     * Set method name to call on event.
     *
     * @param method method name
     */
    @Override
    public void setMethodToCall(String method) {
        methodToCall = method.trim();
    }
}
