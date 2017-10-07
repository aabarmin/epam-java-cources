package com.epam.university.java.project.core.state.machine.domain;

import com.epam.university.java.project.domain.BookEvent;
import com.epam.university.java.project.domain.BookStatus;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Default state machine state implementation.
 */
@XmlRootElement(name = "transition")
public class DefaultStateMachineState implements StateMachineState<BookStatus, BookEvent> {

    private BookStatus from;
    private BookStatus to;
    private BookEvent on;
    private String methodToCall;

    /**
     * From state.
     * @return state name
     */
    @Override
    public BookStatus getFrom() {
        return from;
    }

    /**
     * Set from state.
     * @param state state name
     */
    @Override
    @XmlAttribute(name = "from")
    public void setFrom(BookStatus state) {
        from = state;
    }

    /**
     * Get to state.
     * @return state name
     */
    @Override
    public BookStatus getTo() {
        return to;
    }

    /**
     * Set to state.
     * @param state state name
     */
    @Override
    @XmlAttribute(name = "to")
    public void setTo(BookStatus state) {
        to = state;
    }

    /**
     * Get event.
     * @return event name
     */
    @Override
    public BookEvent getOn() {
        return on;
    }

    /**
     * Set event name.
     * @param bookEvent event name
     */
    @Override
    @XmlAttribute(name = "on")
    public void setOn(BookEvent bookEvent) {
        on = bookEvent;
    }

    /**
     * Get method name to call on event. Method should exists in event handler.
     * @return method name
     */
    @Override
    public String getMethodToCall() {
        return methodToCall;
    }

    /**
     * Set method name to call on event.
     * @param method method name
     */
    @Override
    @XmlAttribute(name = "call")
    public void setMethodToCall(String method) {
        methodToCall = method;
    }

}
