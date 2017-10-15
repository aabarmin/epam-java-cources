package com.epam.university.java.project.core.state.machine.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;

import com.epam.university.java.project.domain.BookEvent;
import com.epam.university.java.project.domain.BookStatus;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "definition")
public class StateMachineDefinitionImpl implements StateMachineDefinition<BookStatus, BookEvent> {
    @XmlAttribute(name = "startEvent")
    private BookEvent event;
    @XmlAttribute(name = "startState")
    private BookStatus state;
    @XmlAttribute(name = "handler")
    private String handlerClass;
    @XmlElement(type = StateMachineStateImpl.class,
            name = "transition")
    private Collection<StateMachineState<BookStatus, BookEvent>> states = new ArrayList<>();


    public StateMachineDefinitionImpl() {
    }

    @Override
    public BookEvent getStartEvent() {
        return event;
    }

    @Override
    public BookStatus getStartState() {
        return state;
    }

    @Override
    public void setStartEvent(BookEvent event) {
        this.event = event;
    }

    @Override
    public void setStartState(BookStatus state) {
        this.state = state;
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
            throw new RuntimeException(e);
        }
    }

    @Override
    public void setHandlerClass(Class<? extends StateMachineEventHandler> handlerClass) {
        this.handlerClass = handlerClass.getName();
    }
}
