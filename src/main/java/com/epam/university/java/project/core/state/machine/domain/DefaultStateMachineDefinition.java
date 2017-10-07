package com.epam.university.java.project.core.state.machine.domain;

import com.epam.university.java.project.domain.BookEvent;
import com.epam.university.java.project.domain.BookStatus;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;

/**
 * State machine definition.
 */
@XmlRootElement(name = "definition")
public class DefaultStateMachineDefinition
    implements StateMachineDefinition<BookStatus, BookEvent> {

    private BookEvent startEvent;
    private BookStatus startStatus;
    private Collection<StateMachineState<BookStatus, BookEvent>> states;
    private Class<? extends StateMachineEventHandler> handlerClass;

    public DefaultStateMachineDefinition() {
        states = new ArrayList<>();
    }

    /**
     * Get start event.
     * @return event name
     */
    @Override
    public BookEvent getStartEvent() {
        return startEvent;
    }

    /**
     * Get start state.
     * @return state name
     */
    @Override
    public BookStatus getStartState() {
        return startStatus;
    }

    /**
     * Set start event.
     * @param bookEvent event name
     */
    @Override
    @XmlAttribute(name = "startEvent")
    public void setStartEvent(BookEvent bookEvent) {
        startEvent = bookEvent;
    }

    /**
     * Set start state.
     * @param bookStatus state name
     */
    @Override
    @XmlAttribute(name = "startState")
    public void setStartState(BookStatus bookStatus) {
        startStatus = bookStatus;
    }

    /**
     * Get state machine states collection.
     * @return states
     */
    @Override
    @XmlElement(name = "transition", type = DefaultStateMachineState.class)
    public Collection<StateMachineState<BookStatus, BookEvent>> getStates() {
        return states;
    }

    /**
     * Add state to state machine definition.
     * @param state state to add
     */
    @Override
    public void addState(StateMachineState<BookStatus, BookEvent> state) {
        states.add(state);
    }

    /**
     * Get state machine handler class.
     * @return handler class
     */
    @Override
    public Class<? extends StateMachineEventHandler> getHandlerClass() {
        return handlerClass;
    }

    /**
     * Set state machine handler class.
     * @param handlerClass handler class
     */
    @Override
    @XmlAttribute(name = "handler")
    public void setHandlerClass(Class<? extends StateMachineEventHandler> handlerClass) {
        this.handlerClass = handlerClass;
    }

}
