package com.epam.university.java.project.core.state.machine.domain;

import com.epam.university.java.project.domain.BookEvent;
import com.epam.university.java.project.domain.BookStatus;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

import static javax.xml.bind.annotation.XmlAccessType.FIELD;

/**
 * Implementation class for StateMachineDefinition.
 *
 * @author Sergei Titov
 */
@XmlRootElement(name = "definition")
@XmlAccessorType(FIELD)
public class StateMachineDefinitionImpl implements StateMachineDefinition<BookStatus, BookEvent> {

    @XmlAttribute(name = "startEvent")
    private BookEvent startEvent;

    @XmlAttribute(name = "startState")
    private BookStatus startState;

    @XmlAttribute(name = "handler")
    private String handler;

    private Class<? extends StateMachineEventHandler> eventHandler = null;

    @XmlElement(name = "transition", type = StateMachineStateImpl.class)
    Collection<StateMachineState<BookStatus, BookEvent>> transitions;

    /**
     * {@inheritDoc}
     */
    @Override
    public BookEvent getStartEvent() {
        return startEvent;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BookStatus getStartState() {
        return startState;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setStartEvent(BookEvent o) {
        this.startEvent = o;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setStartState(BookStatus o) {
        this.startState = o;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<StateMachineState<BookStatus, BookEvent>> getStates() {
        return transitions;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addState(StateMachineState<BookStatus, BookEvent> state) {
        transitions.add(state);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public Class<? extends StateMachineEventHandler> getHandlerClass() {

        if (null == eventHandler) {
            try {
                eventHandler = (Class<? extends StateMachineEventHandler>) Class.forName(handler);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return eventHandler;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setHandlerClass(Class handlerClass) {
        this.eventHandler = eventHandler;
    }
}
