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

@XmlRootElement(name = "definition")
@XmlAccessorType(XmlAccessType.FIELD)
public class StateMachineDefinitionImpl implements StateMachineDefinition<BookStatus, BookEvent> {

    @XmlAttribute
    private BookEvent startEvent;

    @XmlAttribute
    private BookStatus startState;

    @XmlAttribute(name = "handler")
    private String handlerClass;

    @XmlElement(name = "transition", type = StateMachineStateImpl.class)
    private Collection<StateMachineState<BookStatus, BookEvent>> states = new ArrayList<>();

    /**
     * Default constructor.
     */
    public StateMachineDefinitionImpl() {
    }

    @Override
    public BookEvent getStartEvent() {
        return startEvent;
    }

    @Override
    public void setStartEvent(BookEvent startEvent) {
        this.startEvent = startEvent;
    }

    @Override
    public BookStatus getStartState() {
        return startState;
    }

    @Override
    public void setStartState(BookStatus startState) {
        this.startState = startState;
    }

    @Override
    public Collection<StateMachineState<BookStatus, BookEvent>> getStates() {
        return states;
    }

    @Override
    public void addState(StateMachineState<BookStatus, BookEvent> state) {
        states.add(state);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Class<? extends StateMachineEventHandler> getHandlerClass() {

        try {
            return (Class<? extends StateMachineEventHandler>) Class.forName(handlerClass);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException();
        }
    }


    @Override
    public void setHandlerClass(Class<? extends StateMachineEventHandler> handlerClass) {
        this.handlerClass = handlerClass.getName();
    }
}
