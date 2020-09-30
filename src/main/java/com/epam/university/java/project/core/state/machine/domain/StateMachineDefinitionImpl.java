package com.epam.university.java.project.core.state.machine.domain;

import com.epam.university.java.project.domain.BookEvent;
import com.epam.university.java.project.domain.BookStatus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Collection;

/**
 * Created by Romin Nuro on 26.09.2020 22:34.
 */
@XmlRootElement(name = "definition")
@XmlAccessorType(XmlAccessType.FIELD)
public class StateMachineDefinitionImpl implements StateMachineDefinition<BookStatus, BookEvent> {
    @XmlAttribute(name = "startEvent")
    private BookEvent startEvent;
    @XmlAttribute(name = "startState")
    private BookStatus startState;
    @XmlElement(name = "transition", type = StateMachineStateImpl.class)
    private Collection<StateMachineState<BookStatus, BookEvent>> states;
    @XmlAttribute(name = "handler")
    @XmlJavaTypeAdapter(HandlerClassAdapter.class)
    private Class<? extends StateMachineEventHandler> handlerClass;

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
    @SuppressWarnings("unchecked")
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
