package com.epam.university.java.project.core.state.machine.domain;

import com.epam.university.java.project.domain.BookEvent;
import com.epam.university.java.project.domain.BookStatus;
import java.util.ArrayList;
import java.util.Collection;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "definition")
@XmlAccessorType(XmlAccessType.FIELD)
public class StateMachineDefinitionImpl implements StateMachineDefinition<BookStatus, BookEvent> {

    @XmlAttribute(name = "startEvent")
    private BookEvent startEvent;
    @XmlAttribute(name = "startState")
    private BookStatus startState;
    @XmlAttribute(name = "handler")
    private String handlerClass;
    @XmlElement(type = StateMachineStateImpl.class,
        name = "transition")
    private Collection<StateMachineState<BookStatus, BookEvent>> states = new ArrayList<>();

    @Override
    public BookEvent getStartEvent() {
        return startEvent;
    }

    @Override
    public void setStartEvent(BookEvent bookEvent) {
        this.startEvent = bookEvent;
    }

    @Override
    public BookStatus getStartState() {
        return startState;
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

    @SuppressWarnings("unchecked")
    @Override
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

