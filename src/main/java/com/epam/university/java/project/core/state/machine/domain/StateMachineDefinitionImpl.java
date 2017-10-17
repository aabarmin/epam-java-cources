package com.epam.university.java.project.core.state.machine.domain;

import com.epam.university.java.project.domain.BookEvent;
import com.epam.university.java.project.domain.BookStatus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.Collection;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "definition")
public class StateMachineDefinitionImpl implements StateMachineDefinition<BookStatus, BookEvent> {
    @XmlAttribute
    private BookEvent startEvent;
    @XmlAttribute
    private BookStatus startState;
    @XmlElement(type = StateMachineStateImpl.class, name = "transition")
    private Collection<StateMachineState<BookStatus, BookEvent>> states = new ArrayList<>();
    @XmlAttribute
    private String handler;


    @Override
    public BookEvent getStartEvent() {
        return startEvent;
    }

    @Override
    public BookStatus getStartState() {
        return startState;
    }

    @Override
    public void setStartEvent(BookEvent bookEvent) {
        this.startEvent = bookEvent;

    }

    @Override
    public void setStartState(BookStatus bookStatus) {
        this.startState = bookStatus;

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
            return (Class<? extends StateMachineEventHandler>) Class.forName(handler);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public void setHandlerClass(Class<? extends StateMachineEventHandler> handlerClass) {
        this.handler = handlerClass.getName();

    }
}
