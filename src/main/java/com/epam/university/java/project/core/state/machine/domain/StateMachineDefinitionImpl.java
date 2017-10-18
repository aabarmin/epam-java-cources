package com.epam.university.java.project.core.state.machine.domain;

import com.epam.university.java.project.domain.BookEvent;
import com.epam.university.java.project.domain.BookStatus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "definition")
public class StateMachineDefinitionImpl implements StateMachineDefinition<BookStatus, BookEvent> {
    @XmlAttribute(name = "startEvent")
    private BookEvent startEvent;
    @XmlAttribute(name = "startState")
    private BookStatus startState;
    @XmlAttribute(name = "handler")
    private Class<? extends StateMachineEventHandler> handlerClass;
    @XmlElement(name = "transition", type = StateMachineStateImpl.class)
    private Collection<StateMachineState<BookStatus, BookEvent>> states = new ArrayList<>();

    /**
     * Get start event.
     *
     * @return event name
     */
    @Override
    public BookEvent getStartEvent() {
        return startEvent;
    }

    /**
     * Get start state.
     *
     * @return state name
     */
    @Override
    public BookStatus getStartState() {
        return startState;
    }

    /**
     * Set start event.
     *
     * @param event event name
     */
    @Override
    public void setStartEvent(BookEvent event) {
        this.startEvent = event;
    }

    /**
     * Set start state.
     *
     * @param state state name
     */
    @Override
    public void setStartState(BookStatus state) {
        this.startState = state;
    }

    /**
     * Get state machine states collection.
     *
     * @return states
     */
    @Override
    public Collection<StateMachineState<BookStatus, BookEvent>> getStates() {
        return states;
    }

    /**
     * Add state to state machine definition.
     *
     * @param state state to add
     */
    @Override
    public void addState(StateMachineState<BookStatus, BookEvent> state) {
        states.add(state);
    }

    /**
     * Get state machine handler class.
     *
     * @return handler class
     */
    @Override
    public Class<? extends StateMachineEventHandler> getHandlerClass() {
        return handlerClass;
    }

    /**
     * Set state machine handler class.
     *
     * @param handlerClass handler class
     */
    @Override
    public void setHandlerClass(Class<? extends StateMachineEventHandler> handlerClass) {
        this.handlerClass = handlerClass;
    }
}
