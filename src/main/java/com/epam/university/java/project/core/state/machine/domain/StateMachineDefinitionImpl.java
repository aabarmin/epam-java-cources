package com.epam.university.java.project.core.state.machine.domain;

import com.epam.university.java.project.domain.BookEvent;
import com.epam.university.java.project.domain.BookStatus;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Class implements <code>StateMachineDefinition</code>.
 */
@XmlRootElement(name = "definition")
@XmlAccessorType(XmlAccessType.FIELD)
public class StateMachineDefinitionImpl implements
        StateMachineDefinition<BookStatus, BookEvent> {

    @XmlAttribute(name = "startEvent")
    private BookEvent startEvent;
    @XmlAttribute(name = "startState")
    private BookStatus startState;
    @XmlElement(name = "transition", type = StateMachineStateImpl.class)
    private Collection<StateMachineState<BookStatus, BookEvent>> states = new
            ArrayList<>();
    @XmlAttribute(name = "handler")
    private Class<? extends StateMachineEventHandler> handlerClass;

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
        return new ArrayList<>(states);
    }


    @Override
    public void addState(StateMachineState<BookStatus, BookEvent> state) {
        states.add(state);
    }


    @Override
    public Class<? extends StateMachineEventHandler> getHandlerClass() {
        return handlerClass;
    }

    @Override
    public void setHandlerClass(Class<? extends StateMachineEventHandler>
                                        handlerClass) {
        this.handlerClass = handlerClass;
    }
}